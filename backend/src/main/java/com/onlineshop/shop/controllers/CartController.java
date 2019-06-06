package com.onlineshop.shop.controllers;

import com.onlineshop.shop.dto.CartDto;
import com.onlineshop.shop.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping(path = "api/v1/cart")
public class CartController {

    private CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public void saveCart(@RequestBody @NotNull CartDto cart) {
        cartService.saveCart(cart);
    }
}
