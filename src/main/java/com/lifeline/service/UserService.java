package com.lifeline.service;

import com.lifeline.dto.AuthResponseDTO;
import com.lifeline.dto.ChangePasswordDTO;
import com.lifeline.dto.LoginRequestDTO;
import com.lifeline.dto.RegisterRequestDTO;
import com.lifeline.dto.UpdateUserDTO;
import com.lifeline.dto.UserDTO;

public interface UserService {

    AuthResponseDTO register(RegisterRequestDTO request);

    AuthResponseDTO login(LoginRequestDTO request);

    UserDTO getProfile(String email);

    UserDTO updateProfile(String email, UpdateUserDTO request);

    void changePassword(String email, ChangePasswordDTO request);
}