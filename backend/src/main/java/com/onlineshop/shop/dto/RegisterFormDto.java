package com.onlineshop.shop.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RegisterFormDto {

    private String email;
    private String name;
    private String surname;
    private String password;
}
