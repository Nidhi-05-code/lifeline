package com.lifeline.service.impl;


import com.lifeline.dto.AmbulanceRequestDTO;
import com.lifeline.dto.AmbulanceResponseDTO;
import com.lifeline.entity.Ambulance;
import com.lifeline.enums.AmbulanceStatus;
import com.lifeline.exception.ResourceNotFoundException;
import com.lifeline.mapper.AmbulanceMapper;
import com.lifeline.repository.AmbulanceRepository;
import com.lifeline.service.AmbulanceService;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class AmbulanceServiceImpl implements AmbulanceService {


    private final AmbulanceRepository ambulanceRepository;

    private final AmbulanceMapper ambulanceMapper;



    @Override
    public AmbulanceResponseDTO createAmbulance(
            AmbulanceRequestDTO requestDTO) {


        Ambulance ambulance =
                ambulanceMapper.toEntity(requestDTO);


        ambulance.setStatus(
                AmbulanceStatus.AVAILABLE
        );


        Ambulance saved =
                ambulanceRepository.save(ambulance);


        return ambulanceMapper.toResponseDTO(saved);
    }



    @Override
    public List<AmbulanceResponseDTO> getAllAmbulances() {


        return ambulanceRepository.findAll()
                .stream()
                .map(ambulanceMapper::toResponseDTO)
                .toList();

    }



    @Override
    public AmbulanceResponseDTO getAmbulanceById(
            Long id) {


        Ambulance ambulance =
                ambulanceRepository.findById(id)
                        .orElseThrow(
                                () -> new ResourceNotFoundException(
                                        "Ambulance not found"
                                )
                        );


        return ambulanceMapper.toResponseDTO(ambulance);
    }



    @Override
    public List<AmbulanceResponseDTO> getAvailableAmbulances() {


        return ambulanceRepository
                .findByStatus(AmbulanceStatus.AVAILABLE)
                .stream()
                .map(ambulanceMapper::toResponseDTO)
                .toList();

    }



    @Override
    public AmbulanceResponseDTO updateStatus(
            Long id,
            String status) {


        Ambulance ambulance =
                ambulanceRepository.findById(id)
                        .orElseThrow(
                                () -> new ResourceNotFoundException(
                                        "Ambulance not found"
                                )
                        );


        ambulance.setStatus(
                AmbulanceStatus.valueOf(status)
        );


        Ambulance updated =
                ambulanceRepository.save(ambulance);


        return ambulanceMapper.toResponseDTO(updated);
    }



    @Override
    public void deleteAmbulance(Long id) {

        ambulanceRepository.deleteById(id);

    }

}