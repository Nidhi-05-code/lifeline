package com.lifeline.service.impl;

import com.lifeline.dto.EmergencyRequestDTO;
import com.lifeline.dto.EmergencyResponseDTO;
import com.lifeline.entity.Ambulance;
import com.lifeline.entity.EmergencyRequest;
import com.lifeline.entity.User;
import com.lifeline.enums.EmergencyStatus;
import com.lifeline.exception.ResourceNotFoundException;
import com.lifeline.mapper.EmergencyMapper;
import com.lifeline.repository.AmbulanceRepository;
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
    private final AmbulanceRepository ambulanceRepository;

    @Override
    public EmergencyResponseDTO createEmergency(EmergencyRequestDTO requestDTO) {

        String email = SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName();

        User patient = userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User not found"));

        EmergencyRequest emergency = emergencyMapper.toEntity(requestDTO);

        emergency.setPatient(patient);
        emergency.setStatus(EmergencyStatus.PENDING);

        EmergencyRequest saved = emergencyRepository.save(emergency);

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

        EmergencyRequest emergency = emergencyRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Emergency request not found"));

        return emergencyMapper.toResponseDTO(emergency);
    }

    @Override
    public EmergencyResponseDTO updateStatus(Long id, String status) {

        EmergencyRequest emergency = emergencyRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Emergency request not found"));

        emergency.setStatus(EmergencyStatus.valueOf(status.toUpperCase()));

        EmergencyRequest updated = emergencyRepository.save(emergency);

        return emergencyMapper.toResponseDTO(updated);
    }

    @Override
    public void deleteEmergency(Long id) {

        EmergencyRequest emergency = emergencyRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Emergency request not found"));

        emergencyRepository.delete(emergency);
    }

    @Override
    public EmergencyResponseDTO assignAmbulance(Long emergencyId,
                                                Long ambulanceId) {

        System.out.println("================================");
        System.out.println("Emergency ID: " + emergencyId);
        System.out.println("Ambulance ID: " + ambulanceId);

        System.out.println("Emergency Exists: "
                + emergencyRepository.existsById(emergencyId));

        System.out.println("Ambulance Exists: "
                + ambulanceRepository.existsById(ambulanceId));

        EmergencyRequest emergency = emergencyRepository.findById(emergencyId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Emergency not found"));

        Ambulance ambulance = ambulanceRepository.findById(ambulanceId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Ambulance not found"));

        emergency.setAmbulance(ambulance);

        EmergencyRequest saved = emergencyRepository.save(emergency);

        System.out.println("Ambulance assigned successfully!");

        return emergencyMapper.toResponseDTO(saved);
    }
}