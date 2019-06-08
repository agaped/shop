package com.onlineshop.shop.controllers;

import com.onlineshop.shop.dto.OrderDto;
import com.onlineshop.shop.exceptions.ItemNotFoundException;
import com.onlineshop.shop.services.OrderService;
import com.onlineshop.shop.services.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(OrderController.class)
public class OrderControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OrderService orderService;

    @MockBean
    private UserService userService;

    @Test
    public void getUserOrders_whenUserExists() throws Exception {
        int userId=1;
        OrderDto orderOne=createOrder("odbior osobisty", 1999, userId);
        OrderDto orderTwo=createOrder("odbior w sklepie", 1000, userId);
        List<OrderDto> orders = Arrays.asList(orderOne, orderTwo);

        when(userService.userExists(userId)).thenReturn(true);
        when(orderService.getConvertedOrdersByUserId(userId)).thenReturn(orders);

        this.mockMvc.perform(get("http://localhost:8081/api/v1/order/"+userId))
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$",hasSize(2)))
                .andExpect(jsonPath("$[0].delivery",is(orderOne.getDelivery())))
                .andExpect(jsonPath("$[1].total",is(orderTwo.getTotal().intValue())));
    }

    @Test
    @ExceptionHandler(ItemNotFoundException.class)
    public void getUserOrders_whenInvalidUser() throws Exception {
        int userId=1;

        when(userService.userExists(userId)).thenReturn(false);
        when(orderService.getConvertedOrdersByUserId(userId)).thenThrow(ItemNotFoundException.class);

        this.mockMvc.perform(get("http://localhost:8081/api/v1/order/"+userId))
                .andExpect(status().isNotFound());
    }

    @Test
    public void makeOrder_whenUserExists() throws Exception {
        int userId=1;

        when(userService.userExists(userId)).thenReturn(true);

        this.mockMvc.perform(post("http://localhost:8081/api/v1/order")
                .contentType("application/json;charset=UTF-8")
                .content("{\"payment\":\"karta\", \"delivery\":\"odbior osobisty\", \"userId\":1}")
                )
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(status().isOk());
    }

    @Test
    @ExceptionHandler(ItemNotFoundException.class)
    public void makeOrder_whenInvalidUser() throws Exception {
        int userId=1;
        OrderDto order=createOrder("odbior osobisty", 1999, userId);

        when(userService.userExists(userId)).thenReturn(false);
        when(orderService.makeOrder(order)).thenThrow(ItemNotFoundException.class);

        this.mockMvc.perform(post("http://localhost:8081/api/v1/order")
                .contentType("application/json;charset=UTF-8")
                .content("{\"payment\":\"karta\", \"delivery\":\"odbior osobisty\", \"userId\":1}")
                )
                .andExpect(status().isNotFound());
    }

    private OrderDto createOrder(String delivery, int total, int userId) {
        return new OrderDto.Builder()
                .delivery(delivery)
                .total(new BigDecimal(total))
                .userId(userId)
                .build();
    }
}