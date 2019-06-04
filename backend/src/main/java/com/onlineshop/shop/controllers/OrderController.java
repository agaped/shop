package com.onlineshop.shop.controllers;

import com.onlineshop.shop.dto.OrderDto;
import com.onlineshop.shop.services.OrderService;
import com.onlineshop.shop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/order")
public class OrderController {

    private UserService userService;
    private OrderService orderService;

    @Autowired
    public OrderController(UserService userService, OrderService orderService) {
        this.userService = userService;
        this.orderService = orderService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public int makeOrder(@RequestBody @NotNull OrderDto order) {
        if (!userService.userExists(order.getUserId())) {
            throw new IllegalArgumentException("User does not exist " + order.getUserId());
        }
        return orderService.makeOrder(order);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public List<OrderDto> getOrdersByUserId(@PathVariable ("id") int id) {
        if(!userService.userExists(id)){
            throw new IllegalArgumentException("User does not exist");
        }
        return orderService.getConvertedOrdersByUserId(id);
    }

}
