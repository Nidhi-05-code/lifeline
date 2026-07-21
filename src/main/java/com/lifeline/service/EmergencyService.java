package com.lifeline.service;

import com.lifeline.dto.EmergencyRequestDTO;
import com.lifeline.dto.EmergencyResponseDTO;

import java.util.List;


public interface EmergencyService {


    EmergencyResponseDTO createEmergency(
            EmergencyRequestDTO requestDTO
    );


    List<EmergencyResponseDTO> getAllEmergencies();


    EmergencyResponseDTO getEmergencyById(Long id);


    EmergencyResponseDTO updateStatus(
            Long id,
            String status
    );


    void deleteEmergency(Long id);

}