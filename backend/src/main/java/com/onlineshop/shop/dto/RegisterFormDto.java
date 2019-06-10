package com.onlineshop.shop.dto;

public class RegisterFormDto {

    private String email;
    private String name;
    private String surname;
    private String password;

    public RegisterFormDto() {
    }

    public RegisterFormDto(Builder builder) {
        this.email = builder.email;
        this.name = builder.name;
        this.surname = builder.surname;
        this.password = builder.password;
    }

    public static class Builder {

        private String email;
        private String name;
        private String surname;
        private String password;

        public Builder() {
        }

        public Builder email(String val) {
            this.email=val;
            return this;
        }

        public Builder name(String val) {
            this.name=val;
            return this;
        }

        public Builder surname(String val) {
            this.surname=val;
            return this;
        }

        public Builder password(String val) {
            this.password=val;
            return this;
        }

        public RegisterFormDto build() {
            return new RegisterFormDto(this);
        }
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

    public String getPassword() {
        return password;
    }
}
