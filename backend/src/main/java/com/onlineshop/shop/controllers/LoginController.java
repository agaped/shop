package com.onlineshop.shop.controllers;

import com.onlineshop.shop.converters.UserConverter;
import com.onlineshop.shop.dto.UserDto;
import com.onlineshop.shop.dto.UserFormDto;
import com.onlineshop.shop.model.User;
import com.onlineshop.shop.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
    public UserDto login(@RequestBody @NotNull UserFormDto userFormDto) {
        if (checkIfEmailExist(userFormDto.getUsername())) {
            User user = userRepository.findByEmail(userFormDto.getUsername()).get();
            return authorize(userFormDto, user);

        }else{
            throw new IllegalArgumentException("Email does not exist");
        }
    }

    private UserDto authorize(@RequestBody @NotNull UserFormDto userFormDto, User user) {
        if (user.getPassword().equals(userFormDto.getPassword())) {
            loggedUser = userConverter.convert(user);
        }else{
            throw new IllegalArgumentException("Wrong password for "+user.getEmail());
        }
        return loggedUser;
    }

    private boolean checkIfEmailExist(String email) {
        return userRepository.findByEmail(email).isPresent();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/currentIdentity")
    public UserDto checkLoginStatus() {
        if (null == this.loggedUser) {
            throw new RuntimeException("Nobody logged in");
        }else {
            return this.loggedUser;
        }
    }

    @RequestMapping(method = RequestMethod.POST, path = "/logout")
    public void logout(@RequestBody UserFormDto userFormDto) {
        this.loggedUser=null;
    }
}
