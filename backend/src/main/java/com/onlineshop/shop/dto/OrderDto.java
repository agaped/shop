package com.onlineshop.shop.dto;

public class OrderDto {

    private String payment;
    private String status;
    private String delivery;
    private  int userId;

    public OrderDto(String payment, String status, String delivery, int userId) {
        this.payment = payment;
        this.status = status;
        this.delivery = delivery;
        this.userId = userId;
    }

    public OrderDto() {
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
