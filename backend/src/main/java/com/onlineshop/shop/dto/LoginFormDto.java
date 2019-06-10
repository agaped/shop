package com.onlineshop.shop.dto;

public class LoginFormDto {

    private String username;
    private String password;

    public LoginFormDto() {
    }

    public LoginFormDto(Builder builder) {
        this.username = builder.username;
        this.password = builder.password;
    }

    public static class Builder {

        private String username;
        private String password;

        public Builder() {
        }

        public Builder username(String val) {
            this.username = val;
            return this;
        }

        public Builder password(String val) {
            this.password = val;
            return this;
        }

        public LoginFormDto build() {
            return new LoginFormDto(this);
        }
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
