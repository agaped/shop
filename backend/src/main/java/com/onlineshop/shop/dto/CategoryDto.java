package com.onlineshop.shop.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CategoryDto {

    private int id;
    private String name;

}
