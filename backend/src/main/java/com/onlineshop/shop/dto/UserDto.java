package com.onlineshop.shop.dto;

public class UserDto {

    private int id;
    private String email;
    private String name;
    private String surname;

    public UserDto() {
    }

    public UserDto(Builder builder) {
        this.id = builder.id;
        this.email = builder.email;
        this.name = builder.name;
        this.surname = builder.surname;
    }

    public static class Builder {
        private int id;
        private String email;
        private String name;
        private String surname;

        public Builder() {
        }

        public Builder id(int val) {
            this.id = val;
            return this;
        }
        public Builder email(String val) {
            this.email = val;
            return this;
        }
        public Builder name(String val) {
            this.name = val;
            return this;
        }
        public Builder surname(String val) {
            this.surname = val;
            return this;
        }

        public UserDto build() {
            return new UserDto(this);
        }
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
}
