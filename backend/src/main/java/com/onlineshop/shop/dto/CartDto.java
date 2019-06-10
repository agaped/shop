package com.onlineshop.shop.dto;

import java.util.List;

public class CartDto {

    private List<CartItemDto> cartItems;
    private Integer orderId;

    public CartDto(Builder builder) {
        this.cartItems = builder.cart;
        this.orderId = builder.orderId;
    }

    public CartDto() {
    }

    public static class Builder {

        private List<CartItemDto> cart;
        private Integer orderId;

        public Builder() {
        }

        public Builder cart(List<CartItemDto> val) {
            this.cart = val;
            return this;
        }

        public Builder orderId(Integer val) {
            this.orderId = val;
            return this;
        }

        public CartDto build() {
            return new CartDto(this);
        }
    }

    public List<CartItemDto> getCartItems() {
        return cartItems;
    }

    public Integer getOrderId() {
        return orderId;
    }
}
