package com.lifeline.service;


import com.lifeline.dto.AmbulanceRequestDTO;
import com.lifeline.dto.AmbulanceResponseDTO;

import java.util.List;


public interface AmbulanceService {


    AmbulanceResponseDTO createAmbulance(
            AmbulanceRequestDTO requestDTO
    );


    List<AmbulanceResponseDTO> getAllAmbulances();


    AmbulanceResponseDTO getAmbulanceById(
            Long id
    );


    List<AmbulanceResponseDTO> getAvailableAmbulances();


    AmbulanceResponseDTO updateStatus(
            Long id,
            String status
    );


    void deleteAmbulance(
            Long id
    );

}