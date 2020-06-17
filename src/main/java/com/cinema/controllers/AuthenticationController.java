package com.cinema.controllers;

import com.cinema.model.dto.request.UserRequestDto;
import com.cinema.security.AuthenticationService;
import javax.validation.Valid;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public void register(@RequestBody @Valid UserRequestDto requestDto) {
        authenticationService.register(
                requestDto.getEmail(),
                new BCryptPasswordEncoder().encode(requestDto.getPassword()));
    }
}
