package com.onlineshop.shop.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class ProductDto {

    private int id;
    private String name;
    private String producer;
    private BigDecimal price;
    private String description;
    private String category;
    private String url;

}