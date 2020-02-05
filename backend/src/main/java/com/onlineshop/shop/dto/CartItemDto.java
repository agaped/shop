package com.onlineshop.shop.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data

public class CartItemDto {

    private ProductDto item;
    private Integer quantity;

}
