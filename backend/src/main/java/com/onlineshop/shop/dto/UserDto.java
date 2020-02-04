package com.onlineshop.shop.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserDto {

    private int id;
    private String email;
    private String name;
    private String surname;
}
