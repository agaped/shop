package com.onlineshop.shop.dto;

import java.math.BigDecimal;
import java.util.Date;

public class OrderDto {

    private Date date;
    private String payment;
    private String status;
    private String delivery;
    private BigDecimal total;
    private int userId;

    public OrderDto() {
    }

    private OrderDto(Builder builder) {
        this.date = builder.date;
        this.payment = builder.payment;
        this.status = builder.status;
        this.delivery = builder.delivery;
        this.total = builder.total;
        this.userId = builder.userId;
    }

    public static class Builder {

        private Date date;
        private String payment;
        private String status;
        private String delivery;
        private BigDecimal total;
        private int userId;

        public Builder() {
        }

        public Builder date(Date val) {
            this.date=val;
            return this;
        }
        public Builder payment(String val) {
            this.payment=val;
            return this;
        }
        public Builder status(String val) {
            this.status=val;
            return this;
        }
        public Builder delivery(String val) {
            this.delivery=val;
            return this;
        }
        public Builder total(BigDecimal val) {
            this.total=val;
            return this;
        }
        public Builder userId(int val) {
            this.userId=val;
            return this;
        }
        public OrderDto build() {
            return new OrderDto(this);
        }

    }

    public Date getDate() {
        return date;
    }

    public String getPayment() {
        return payment;
    }

    public String getStatus() {
        return status;
    }

    public String getDelivery() {
        return delivery;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public int getUserId() {
        return userId;
    }

}