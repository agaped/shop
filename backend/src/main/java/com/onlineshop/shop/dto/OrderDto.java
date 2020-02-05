package com.onlineshop.shop.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Builder
@Data
public class OrderDto {

    private Date date;
    private String payment;
    private String status;
    private String delivery;
    private BigDecimal total;
    private int userId;

}