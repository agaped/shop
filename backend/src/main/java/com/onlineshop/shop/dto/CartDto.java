package com.onlineshop.shop.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class CartDto {

    private List<CartItemDto> cartItems;
    private Integer orderId;
}
