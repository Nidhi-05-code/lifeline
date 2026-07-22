package com.lifeline.service;

import com.lifeline.dto.HospitalRequestDTO;
import com.lifeline.dto.HospitalResponseDTO;

import java.util.List;

public interface HospitalService {

    HospitalResponseDTO createHospital(HospitalRequestDTO requestDTO);

    List<HospitalResponseDTO> getAllHospitals();

    HospitalResponseDTO getHospitalById(Long id);

    HospitalResponseDTO updateHospital(Long id, HospitalRequestDTO requestDTO);

    void deleteHospital(Long id);
}