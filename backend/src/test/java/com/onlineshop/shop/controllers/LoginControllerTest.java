package com.onlineshop.shop.controllers;

import com.onlineshop.shop.dto.LoginFormDto;
import com.onlineshop.shop.dto.RegisterFormDto;
import com.onlineshop.shop.dto.UserDto;
import com.onlineshop.shop.exceptions.ItemNotFoundException;
import com.onlineshop.shop.services.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(LoginController.class)
public class LoginControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    public void login_whenUserExists() throws Exception {
        String email = "email";
        UserDto user = new UserDto();
        user.setEmail(email);
        user.setId(23);

        when(userService.emailExist(email)).thenReturn(true);
        when(userService.authorize(any(LoginFormDto.class))).thenReturn(user);

        this.mockMvc.perform(post("http://localhost:8081/api/v1/login")
                .contentType("application/json;charset=UTF-8")
                .content("{\"username\":\"email\", \"password\":\"12345\"}")
        )
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("email", is(user.getEmail())))
                .andExpect(jsonPath("id", is(user.getId())));

        verify(userService, times(1)).emailExist(email);
        verify(userService, times(1)).authorize(any(LoginFormDto.class));
    }

    @Test
    @ExceptionHandler(ItemNotFoundException.class)
    public void login_whenUserDoesNotExists() throws Exception {
        String email = "email";

        when(userService.emailExist(email)).thenReturn(false);

        this.mockMvc.perform(post("http://localhost:8081/api/v1/login")
                .contentType("application/json;charset=UTF-8")
                .content("{\"username\":\"email\", \"password\":\"12345\"}")
        )
                .andExpect(status().isNotFound());

        verify(userService, times(1)).emailExist(email);
        verify(userService, times(0)).authorize(any(LoginFormDto.class));
    }

    @Test
    public void logout() throws Exception {

        this.mockMvc.perform(post("http://localhost:8081/api/v1/logout")
                .contentType("application/json;charset=UTF-8")
                .content("{\"username\":\"email\", \"password\":\"12345\"}")
        )
                .andExpect(status().isOk());

        verify(userService, times(1)).logout();
    }

    @Test
    public void registerUser() throws Exception {
        UserDto user = new UserDto();
        user.setName("Jan");
        user.setId(11);

        when(userService.registerUser(any(RegisterFormDto.class))).thenReturn(user);

        this.mockMvc.perform(post("http://localhost:8081/api/v1/register")
                .contentType("application/json;charset=UTF-8")
                .content("{\"name\":\"Jan\",\"surname\":\"Kowalski\", \"password\":\"12345\"}")
        )
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("name", is(user.getName())))
                .andExpect(jsonPath("id", is(user.getId())));

        verify(userService, times(1)).registerUser(any(RegisterFormDto.class));
    }
}