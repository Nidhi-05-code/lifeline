package com.lifeline.controller;

import com.lifeline.dto.AuthResponseDTO;
import com.lifeline.dto.LoginRequestDTO;
import com.lifeline.dto.RegisterRequestDTO;
import com.lifeline.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public AuthResponseDTO register(@Valid @RequestBody RegisterRequestDTO request) {
        return userService.register(request);
    }

    @PostMapping("/login")
    public AuthResponseDTO login(@Valid @RequestBody LoginRequestDTO request) {
        return userService.login(request);
    }
}