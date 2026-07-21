package com.lifeline.controller;

import com.lifeline.dto.ChangePasswordDTO;
import com.lifeline.dto.UpdateUserDTO;
import com.lifeline.dto.UserDTO;
import com.lifeline.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/profile")
    public ResponseEntity<UserDTO> getProfile(Authentication authentication) {
        return ResponseEntity.ok(
                userService.getProfile(authentication.getName())
        );
    }

    @PutMapping("/profile")
    public ResponseEntity<UserDTO> updateProfile(
            Authentication authentication,
            @Valid @RequestBody UpdateUserDTO request) {

        return ResponseEntity.ok(
                userService.updateProfile(authentication.getName(), request)
        );
    }

    @PutMapping("/change-password")
    public ResponseEntity<String> changePassword(
            Authentication authentication,
            @Valid @RequestBody ChangePasswordDTO request) {

        userService.changePassword(authentication.getName(), request);

        return ResponseEntity.ok("Password changed successfully");
    }
}