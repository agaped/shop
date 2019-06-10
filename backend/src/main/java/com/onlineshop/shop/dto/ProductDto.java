package com.onlineshop.shop.dto;

import java.math.BigDecimal;

public class ProductDto {

    private  int id;
    private  String name;
    private  String producer;
    private  BigDecimal price;
    private  String description;
    private  String category;
    private  String url;

    public ProductDto() {
    }

    private ProductDto(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.producer = builder.producer;
        this.price = builder.price;
        this.description = builder.description;
        this.category = builder.category;
        this.url = builder.url;
    }

    public static class Builder {

        private int id;
        private String name;
        private String producer;
        private BigDecimal price;
        private String description;
        private String category;
        private String url;

        public Builder() {
        }

        public Builder id(int val) {
            this.id=val;
            return this;
        }
        public Builder name(String val) {
            this.name=val;
            return this;
        }
        public Builder producer(String val) {
            this.producer=val;
            return this;
        }
        public Builder price(BigDecimal val) {
            this.price=val;
            return this;
        }
        public Builder description(String val) {
            this.description=val;
            return this;
        }
        public Builder category(String val) {
            this.category=val;
            return this;
        }
        public Builder url(String val) {
            this.url=val;
            return this;
        }
        public ProductDto build() {
            return new ProductDto(this);
        }
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getProducer() {
        return producer;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public String getUrl() {
        return url;
    }

    public String toString() {
        return this.id + ", " + this.name;
    }
}
