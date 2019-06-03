package com.onlineshop.shop.controllers;

import com.onlineshop.shop.dto.LoginFormDto;
import com.onlineshop.shop.dto.RegisterFormDto;
import com.onlineshop.shop.dto.UserDto;
import com.onlineshop.shop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping(path = "api/v1")
public class LoginController {

    private UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/login")
    public UserDto login(@RequestBody @NotNull LoginFormDto loginFormDto) {
        if (!userService.emailExist(loginFormDto.getUsername())) {
            throw new IllegalArgumentException("Email does not exist");
        }
        return userService.authorize(loginFormDto);
    }


    @RequestMapping(method = RequestMethod.POST, path = "/logout")
    public void logout(@RequestBody LoginFormDto loginFormDto) {
        userService.logout();
    }

    @RequestMapping(method = RequestMethod.POST, path = "/register")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto registerUser(@RequestBody @NotNull RegisterFormDto registerFormDto) {
        return userService.registerUser(registerFormDto);
    }
}
