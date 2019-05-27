package com.onlineshop.shop.dto;

import java.util.List;

public class CartDto {

    private List<CartItemDto> cart;
    private Integer orderID;

    public CartDto(List<CartItemDto> cart, Integer orderID) {
        this.cart = cart;
        this.orderID = orderID;
    }

    public CartDto() {
    }

    public List<CartItemDto> getCart() {
        return cart;
    }

    public void setCart(List<CartItemDto> cart) {
        this.cart = cart;
    }

    public Integer getOrderID() {
        return orderID;
    }

    public void setOrderID(Integer orderID) {
        this.orderID = orderID;
    }
}
