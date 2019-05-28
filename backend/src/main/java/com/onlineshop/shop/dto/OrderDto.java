package com.onlineshop.shop.dto;

import java.math.BigDecimal;
import java.util.Date;

public class OrderDto {

    private Date date;
    private String payment;
    private String status;
    private String delivery;
    private BigDecimal total;
    private  int userId;

    public OrderDto(Date date, String payment, String status, String delivery, BigDecimal total, int userId) {
        this.date = date;
        this.payment = payment;
        this.status = status;
        this.delivery = delivery;
        this.total = total;
        this.userId = userId;
    }

    public OrderDto() {
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDelivery() {
        return delivery;
    }

    public void setDelivery(String delivery) {
        this.delivery = delivery;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
