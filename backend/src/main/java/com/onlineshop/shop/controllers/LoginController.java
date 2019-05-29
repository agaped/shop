package com.onlineshop.shop.controllers;

import com.onlineshop.shop.converters.UserConverter;
import com.onlineshop.shop.dto.RegisterFormDto;
import com.onlineshop.shop.dto.UserDto;
import com.onlineshop.shop.dto.LoginFormDto;
import com.onlineshop.shop.model.User;
import com.onlineshop.shop.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping(path = "api/v1")
public class LoginController {

    private UserRepository userRepository;
    private UserConverter userConverter;
    UserDto loggedUser;

    @Autowired
    public LoginController(UserRepository userRepository, UserConverter userConverter) {
        this.userRepository = userRepository;
        this.userConverter = userConverter;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/login")
    public UserDto login(@RequestBody @NotNull LoginFormDto loginFormDto) {
        if (!emailExist(loginFormDto.getUsername())) {
            throw new IllegalArgumentException("Email does not exist");
        }
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

    private boolean emailExist(String email) {
        return userRepository.findByEmail(email).isPresent();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/currentIdentity")
    public UserDto checkLoginStatus() {
        if (null == this.loggedUser) {
            throw new RuntimeException("Nobody logged in");
        }
        return this.loggedUser;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/logout")
    public void logout(@RequestBody LoginFormDto loginFormDto) {
        this.loggedUser=null;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/register")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto registerUser(@RequestBody @NotNull RegisterFormDto registerFormDto) {
        User user = new User(registerFormDto.getEmail(), registerFormDto.getName(),
                registerFormDto.getSurname(), registerFormDto.getPassword(), "client");
        userRepository.save(user);
        return userConverter.convert(user);
    }
}
