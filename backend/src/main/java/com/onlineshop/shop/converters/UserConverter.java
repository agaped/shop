package com.onlineshop.shop.converters;

import com.onlineshop.shop.dto.UserDto;
import com.onlineshop.shop.model.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserConverter implements Converter<User, UserDto> {
    @Override
    public UserDto convert(User source) {

        UserDto user = new UserDto();
        user.setId(source.getId());
        user.setEmail(source.getEmail());
        user.setName(source.getName());
        user.setSurname(source.getSurname());

        return user;
    }
}
