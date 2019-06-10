package com.onlineshop.shop.dto;

public class CartItemDto {

    private ProductDto item;
    private Integer quantity;

    public CartItemDto(Builder builder) {
        this.item = builder.item;
        this.quantity = builder.quantity;
    }

    public CartItemDto() {
    }

    public static class Builder {

        private ProductDto item;
        private Integer quantity;

        public Builder() {
        }

        public Builder item(ProductDto val) {
            this.item = val;
            return this;
        }

        public Builder quantity(Integer val) {
            this.quantity = val;
            return this;
        }

        public CartItemDto build() {
            return new CartItemDto(this);
        }
    }

    public ProductDto getItem() {
        return item;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public String toString() {
        return item + ", quantity: " + quantity;
    }
}
