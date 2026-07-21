package com.lifeline.mapper;

import com.lifeline.dto.UserDTO;
import com.lifeline.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserDTO toDTO(User user) {

        UserDTO dto = new UserDTO();

        dto.setId(user.getId());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setEmail(user.getEmail());
        dto.setPhoneNumber(user.getPhoneNumber());
        dto.setRole(user.getRole().getRoleName().name());
        dto.setActive(user.isActive());
        dto.setEmailVerified(user.isEmailVerified());

        return dto;
    }
}