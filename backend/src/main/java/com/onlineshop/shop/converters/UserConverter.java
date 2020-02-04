package com.onlineshop.shop.converters;

import com.onlineshop.shop.dto.UserDto;
import com.onlineshop.shop.model.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserConverter implements Converter<User, UserDto> {
    @Override
    public UserDto convert(User source) {

        return UserDto.builder()
                .id(source.getId())
                .name(source.getName())
                .email(source.getEmail())
                .surname(source.getSurname())
                .build();
    }
}
