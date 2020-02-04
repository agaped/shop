package com.onlineshop.shop.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class LoginFormDto {

    private String username;
    private String password;
}
