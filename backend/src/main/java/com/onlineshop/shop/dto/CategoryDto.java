package com.onlineshop.shop.dto;

public class CategoryDto {

    private int id;
    private String name;

    public CategoryDto() {
    }

    private CategoryDto(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
    }

    public static class Builder {
        private int id;
        private String name;

        public Builder() {
        }

        public Builder id(int val) {
            this.id=val;
            return this;
        }
        public Builder name(String val) {
            this.name = val;
            return this;
        }

        public CategoryDto build() {
            return new CategoryDto(this);
        }
    }
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }


}
