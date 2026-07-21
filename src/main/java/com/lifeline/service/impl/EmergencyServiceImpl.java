package com.lifeline.service.impl;


import com.lifeline.dto.EmergencyRequestDTO;
import com.lifeline.dto.EmergencyResponseDTO;
import com.lifeline.entity.EmergencyRequest;
import com.lifeline.entity.User;
import com.lifeline.enums.EmergencyStatus;
import com.lifeline.exception.ResourceNotFoundException;
import com.lifeline.mapper.EmergencyMapper;
import com.lifeline.repository.EmergencyRequestRepository;
import com.lifeline.repository.UserRepository;
import com.lifeline.service.EmergencyService;

import lombok.RequiredArgsConstructor;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class EmergencyServiceImpl implements EmergencyService {


    private final EmergencyRequestRepository emergencyRepository;

    private final EmergencyMapper emergencyMapper;

    private final UserRepository userRepository;



    @Override
    public EmergencyResponseDTO createEmergency(
            EmergencyRequestDTO requestDTO) {


        // Get logged-in user's email from JWT
        String email =
                SecurityContextHolder
                        .getContext()
                        .getAuthentication()
                        .getName();


        // Find patient from database
        User patient =
                userRepository.findByEmail(email)
                        .orElseThrow(
                                () -> new ResourceNotFoundException(
                                        "User not found"
                                )
                        );


        EmergencyRequest emergency =
                emergencyMapper.toEntity(requestDTO);


        // Attach patient
        emergency.setPatient(patient);


        emergency.setStatus(EmergencyStatus.PENDING);


        EmergencyRequest saved =
                emergencyRepository.save(emergency);


        return emergencyMapper.toResponseDTO(saved);
    }



    @Override
    public List<EmergencyResponseDTO> getAllEmergencies() {

        return emergencyRepository.findAll()
                .stream()
                .map(emergencyMapper::toResponseDTO)
                .toList();
    }



    @Override
    public EmergencyResponseDTO getEmergencyById(Long id) {

        EmergencyRequest emergency =
                emergencyRepository.findById(id)
                        .orElseThrow(
                                () -> new ResourceNotFoundException(
                                        "Emergency request not found"
                                )
                        );


        return emergencyMapper.toResponseDTO(emergency);
    }



    @Override
    public EmergencyResponseDTO updateStatus(
            Long id,
            String status) {


        EmergencyRequest emergency =
                emergencyRepository.findById(id)
                        .orElseThrow(
                                () -> new ResourceNotFoundException(
                                        "Emergency request not found"
                                )
                        );


        emergency.setStatus(
                EmergencyStatus.valueOf(status)
        );


        EmergencyRequest updated =
                emergencyRepository.save(emergency);


        return emergencyMapper.toResponseDTO(updated);
    }



    @Override
    public void deleteEmergency(Long id) {

        emergencyRepository.deleteById(id);

    }

}