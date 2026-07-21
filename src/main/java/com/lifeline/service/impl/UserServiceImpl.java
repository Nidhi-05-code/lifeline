package com.lifeline.service.impl;

import com.lifeline.dto.AuthResponseDTO;
import com.lifeline.dto.ChangePasswordDTO;
import com.lifeline.dto.LoginRequestDTO;
import com.lifeline.dto.RegisterRequestDTO;
import com.lifeline.dto.UpdateUserDTO;
import com.lifeline.dto.UserDTO;
import com.lifeline.entity.Role;
import com.lifeline.entity.User;
import com.lifeline.enums.RoleType;
import com.lifeline.exception.ResourceAlreadyExistsException;
import com.lifeline.exception.ResourceNotFoundException;
import com.lifeline.jwt.JwtService;
import com.lifeline.mapper.UserMapper;
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
    private final JwtService jwtService;
    private final UserMapper userMapper;

    public UserServiceImpl(
            UserRepository userRepository,
            RoleRepository roleRepository,
            PasswordEncoder passwordEncoder,
            JwtService jwtService,
            UserMapper userMapper) {

        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.userMapper = userMapper;
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
                new ResourceNotFoundException("Role not found")
        );

        User user = new User();

        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());
        user.setPhoneNumber(request.getPhoneNumber());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(role);

        userRepository.save(user);

        return new AuthResponseDTO(
                null,
                "User Registered Successfully"
        );
    }

    @Override
    public AuthResponseDTO login(LoginRequestDTO request) {

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Invalid email or password")
                );

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new ResourceNotFoundException("Invalid email or password");
        }

        String token = jwtService.generateToken(user.getEmail());

        return new AuthResponseDTO(
                token,
                "Login Successful"
        );
    }

    @Override
    public UserDTO getProfile(String email) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User not found")
                );

        return userMapper.toDTO(user);
    }

    @Override
    public UserDTO updateProfile(String email, UpdateUserDTO request) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User not found")
                );

        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setPhoneNumber(request.getPhoneNumber());

        userRepository.save(user);

        return userMapper.toDTO(user);
    }

    @Override
    public void changePassword(String email, ChangePasswordDTO request) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User not found")
                );

        if (!passwordEncoder.matches(request.getCurrentPassword(), user.getPassword())) {
            throw new ResourceNotFoundException("Current password is incorrect");
        }

        user.setPassword(passwordEncoder.encode(request.getNewPassword()));

        userRepository.save(user);
    }
}