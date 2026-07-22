package com.lifeline.service;

import com.lifeline.dto.BloodBankRequestDTO;
import com.lifeline.dto.BloodBankResponseDTO;

import java.util.List;

public interface BloodBankService {

    BloodBankResponseDTO createBloodBank(BloodBankRequestDTO requestDTO);

    List<BloodBankResponseDTO> getAllBloodBanks();

    BloodBankResponseDTO getBloodBankById(Long id);

    BloodBankResponseDTO updateBloodBank(Long id, BloodBankRequestDTO requestDTO);

    void deleteBloodBank(Long id);
}