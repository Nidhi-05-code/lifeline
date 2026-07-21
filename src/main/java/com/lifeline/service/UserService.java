package com.lifeline.service;

import com.lifeline.dto.AuthResponseDTO;
import com.lifeline.dto.LoginRequestDTO;
import com.lifeline.dto.RegisterRequestDTO;

public interface UserService {

    AuthResponseDTO register(RegisterRequestDTO request);

    AuthResponseDTO login(LoginRequestDTO request);

}