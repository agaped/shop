package com.onlineshop.shop.controllers;

import com.onlineshop.shop.dto.CartDto;
import com.onlineshop.shop.services.CartService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CartController.class)
public class CartControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CartService cartService;

    @Test
    public void saveCartSuccessfully() throws Exception {

        this.mockMvc.perform(post("http://localhost:8081/api/v1/cart")
                .contentType("application/json;charset=UTF-8")
                .content("{\"cartItems\":[{\"item\":{\"id\":1, \"name\":\"Rower\"}, \"quantity\":1}]," +
                        " \"orderId\":1}")
        )
                .andExpect(status().isOk());
        verify(cartService, times(1)).saveCart(any(CartDto.class));
    }

}