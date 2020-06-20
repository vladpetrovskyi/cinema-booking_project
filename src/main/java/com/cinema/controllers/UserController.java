package com.cinema.controllers;

import com.cinema.model.User;
import com.cinema.model.dto.request.UserRequestDto;
import com.cinema.model.dto.response.UserResponseDto;
import com.cinema.model.mapper.ItemMapper;
import com.cinema.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
@AllArgsConstructor
public class UserController {

    private final UserService userService;
    private final ItemMapper<User, UserRequestDto, UserResponseDto> itemMapper;

    @GetMapping(value = "/by-email")
    public UserResponseDto getUserByEmail(Authentication auth) {
        UserDetails user = (UserDetails) auth.getPrincipal();
        return itemMapper.toDto(userService.findByEmail(user.getUsername()));
    }
}
