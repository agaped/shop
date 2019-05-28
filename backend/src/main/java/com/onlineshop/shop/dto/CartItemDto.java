package com.onlineshop.shop.dto;

public class CartItemDto {

    private ProductDto item;
    private Integer quantity;

    public CartItemDto(ProductDto product, Integer quantity) {
        this.item = product;
        this.quantity = quantity;
    }

    public CartItemDto() {
    }

    public ProductDto getItem() {
        return item;
    }

    public void setItem(ProductDto item) {
        this.item = item;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String toString() {
        return item + ", quantity: " + quantity;
    }
}
