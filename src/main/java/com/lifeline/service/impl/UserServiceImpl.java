package com.lifeline.service.impl;

import com.lifeline.dto.AuthResponseDTO;
import com.lifeline.dto.LoginRequestDTO;
import com.lifeline.dto.RegisterRequestDTO;
import com.lifeline.entity.Role;
import com.lifeline.entity.User;
import com.lifeline.enums.RoleType;
import com.lifeline.exception.ResourceAlreadyExistsException;
import com.lifeline.repository.RoleRepository;
import com.lifeline.repository.UserRepository;
import com.lifeline.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository,
                           RoleRepository roleRepository,
                           PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public AuthResponseDTO register(RegisterRequestDTO request) {

        if (userRepository.existsByEmail(request.getEmail())) {
            throw new ResourceAlreadyExistsException("Email already exists");
        }

        if (userRepository.existsByPhoneNumber(request.getPhoneNumber())) {
            throw new ResourceAlreadyExistsException("Phone number already exists");
        }

        Role role = roleRepository.findByRoleName(
                RoleType.valueOf(request.getRole().toUpperCase())
        ).orElseThrow(() ->
                new RuntimeException("Role not found"));

        User user = new User();

        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());
        user.setPhoneNumber(request.getPhoneNumber());

        user.setPassword(passwordEncoder.encode(request.getPassword()));

        user.setRole(role);

        userRepository.save(user);

        return new AuthResponseDTO(null, "User Registered Successfully");
    }

    @Override
    public AuthResponseDTO login(LoginRequestDTO request) {

        return new AuthResponseDTO(null, "Login Coming Soon");
    }
}