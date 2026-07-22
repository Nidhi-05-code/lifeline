package com.lifeline.service;

import com.lifeline.dto.BloodDonorRequestDTO;
import com.lifeline.dto.BloodDonorResponseDTO;
import com.lifeline.enums.BloodGroup;

import java.util.List;

public interface BloodDonorService {

    BloodDonorResponseDTO registerDonor(BloodDonorRequestDTO requestDTO);

    List<BloodDonorResponseDTO> getAllDonors();

    BloodDonorResponseDTO getDonorById(Long id);

    List<BloodDonorResponseDTO> getDonorsByBloodGroup(BloodGroup bloodGroup);

    List<BloodDonorResponseDTO> getAvailableDonors();

    BloodDonorResponseDTO updateAvailability(Long id, Boolean available);

    void deleteDonor(Long id);
}