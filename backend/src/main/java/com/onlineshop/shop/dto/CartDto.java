package com.onlineshop.shop.dto;

import java.util.List;

public class CartDto {

    private List<CartItemDto> cartItems;
    private Integer orderId;

    public CartDto(List<CartItemDto> cart, Integer orderId) {
        this.cartItems = cart;
        this.orderId = orderId;
    }

    public CartDto() {
    }

    public List<CartItemDto> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItemDto> cartItems) {
        this.cartItems = cartItems;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }
}
