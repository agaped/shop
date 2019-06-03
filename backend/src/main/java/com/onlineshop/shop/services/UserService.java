package com.onlineshop.shop.services;

import com.onlineshop.shop.converters.UserConverter;
import com.onlineshop.shop.dto.LoginFormDto;
import com.onlineshop.shop.dto.RegisterFormDto;
import com.onlineshop.shop.dto.UserDto;
import com.onlineshop.shop.model.User;
import com.onlineshop.shop.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.constraints.NotNull;

@Service
public class UserService {


    private UserRepository userRepository;
    private UserConverter userConverter;
    UserDto loggedUser;

    @Autowired
    public UserService(UserRepository userRepository, UserConverter userConverter) {
        this.userRepository = userRepository;
        this.userConverter = userConverter;
    }

    public boolean emailExist(String email) {
        return userRepository.findByEmail(email).isPresent();
    }

    public UserDto authorize(LoginFormDto loginFormDto) {
        User user = userRepository.findByEmail(loginFormDto.getUsername()).get();
        return authorize(loginFormDto, user);
    }

    private UserDto authorize(@RequestBody @NotNull LoginFormDto loginFormDto, User user) {
        if (!user.getPassword().equals(loginFormDto.getPassword())) {
            throw new IllegalArgumentException("Wrong password for "+user.getEmail());
        }
        loggedUser = userConverter.convert(user);
        return loggedUser;
    }

    public void logout() {
        this.loggedUser=null;
    }

    public UserDto registerUser(RegisterFormDto registerFormDto) {
        User user = new User(registerFormDto.getEmail(), registerFormDto.getName(),
                registerFormDto.getSurname(), registerFormDto.getPassword(), "client");
        userRepository.save(user);
        return userConverter.convert(user);
    }

    public boolean userExists(int userId) {
        return userRepository.findById(userId).isPresent();
    }
}
