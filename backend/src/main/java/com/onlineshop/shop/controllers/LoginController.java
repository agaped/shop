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
@RequestMapping(path = "api/v1/login")
public class LoginController {

    private UserRepository userRepository;
    private UserConverter userConverter;

    @Autowired
    public LoginController(UserRepository userRepository, UserConverter userConverter) {
        this.userRepository = userRepository;
        this.userConverter = userConverter;
    }

    @RequestMapping(method = RequestMethod.POST)
    public UserDto login(@RequestBody @NotNull UserFormDto userFormDto) {
        if (checkIfEmailExist(userFormDto.getUsername())) {
            User user = userRepository.findByEmail(userFormDto.getUsername()).get();
            return authorize(userFormDto, user);

        }else{
            throw new IllegalArgumentException("Email does not exist");
        }
    }

    private UserDto authorize(@RequestBody @NotNull UserFormDto userFormDto, User user) {
        UserDto loggedUser;
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
}
