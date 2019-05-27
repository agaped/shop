package com.onlineshop.shop.dto;

public class CartItemDto {

    private ProductDto product;
    private Integer quantity;

    public CartItemDto(ProductDto product, Integer quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public CartItemDto() {
    }

    public ProductDto getProduct() {
        return product;
    }

    public void setProduct(ProductDto product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
