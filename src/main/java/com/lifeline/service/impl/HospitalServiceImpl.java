package com.lifeline.service.impl;

import com.lifeline.dto.HospitalRequestDTO;
import com.lifeline.dto.HospitalResponseDTO;
import com.lifeline.entity.Hospital;
import com.lifeline.exception.ResourceAlreadyExistsException;
import com.lifeline.exception.ResourceNotFoundException;
import com.lifeline.mapper.HospitalMapper;
import com.lifeline.repository.HospitalRepository;
import com.lifeline.service.HospitalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HospitalServiceImpl implements HospitalService {

    private final HospitalRepository hospitalRepository;
    private final HospitalMapper hospitalMapper;

    @Override
    public HospitalResponseDTO createHospital(HospitalRequestDTO requestDTO) {

        if (hospitalRepository.existsByEmail(requestDTO.getEmail())) {
            throw new ResourceAlreadyExistsException("Hospital email already exists");
        }

        if (hospitalRepository.existsByPhoneNumber(requestDTO.getPhoneNumber())) {
            throw new ResourceAlreadyExistsException("Hospital phone number already exists");
        }

        Hospital hospital = hospitalMapper.toEntity(requestDTO);

        Hospital savedHospital = hospitalRepository.save(hospital);

        return hospitalMapper.toResponseDTO(savedHospital);
    }

    @Override
    public List<HospitalResponseDTO> getAllHospitals() {

        return hospitalRepository.findAll()
                .stream()
                .map(hospitalMapper::toResponseDTO)
                .toList();
    }

    @Override
    public HospitalResponseDTO getHospitalById(Long id) {

        Hospital hospital = hospitalRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Hospital not found"));

        return hospitalMapper.toResponseDTO(hospital);
    }

    @Override
    public HospitalResponseDTO updateHospital(Long id,
                                              HospitalRequestDTO requestDTO) {

        Hospital hospital = hospitalRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Hospital not found"));

        hospital.setHospitalName(requestDTO.getHospitalName());
        hospital.setEmail(requestDTO.getEmail());
        hospital.setPhoneNumber(requestDTO.getPhoneNumber());
        hospital.setAddress(requestDTO.getAddress());
        hospital.setLatitude(requestDTO.getLatitude());
        hospital.setLongitude(requestDTO.getLongitude());
        hospital.setTotalBeds(requestDTO.getTotalBeds());
        hospital.setAvailableBeds(requestDTO.getAvailableBeds());
        hospital.setIcuBeds(requestDTO.getIcuBeds());
        hospital.setAvailableIcuBeds(requestDTO.getAvailableIcuBeds());
        hospital.setEmergencyAvailable(requestDTO.getEmergencyAvailable());

        Hospital updatedHospital = hospitalRepository.save(hospital);

        return hospitalMapper.toResponseDTO(updatedHospital);
    }

    @Override
    public void deleteHospital(Long id) {

        Hospital hospital = hospitalRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Hospital not found"));

        hospitalRepository.delete(hospital);
    }
}