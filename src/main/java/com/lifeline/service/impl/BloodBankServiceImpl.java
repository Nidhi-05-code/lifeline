package com.lifeline.service.impl;

import com.lifeline.dto.BloodBankRequestDTO;
import com.lifeline.dto.BloodBankResponseDTO;
import com.lifeline.entity.BloodBank;
import com.lifeline.exception.ResourceAlreadyExistsException;
import com.lifeline.exception.ResourceNotFoundException;
import com.lifeline.mapper.BloodBankMapper;
import com.lifeline.repository.BloodBankRepository;
import com.lifeline.service.BloodBankService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BloodBankServiceImpl implements BloodBankService {

    private final BloodBankRepository bloodBankRepository;
    private final BloodBankMapper bloodBankMapper;

    @Override
    public BloodBankResponseDTO createBloodBank(BloodBankRequestDTO requestDTO) {

        if (bloodBankRepository.existsByEmail(requestDTO.getEmail())) {
            throw new ResourceAlreadyExistsException("Blood bank email already exists");
        }

        if (bloodBankRepository.existsByPhoneNumber(requestDTO.getPhoneNumber())) {
            throw new ResourceAlreadyExistsException("Blood bank phone number already exists");
        }

        BloodBank bloodBank = bloodBankMapper.toEntity(requestDTO);

        BloodBank saved = bloodBankRepository.save(bloodBank);

        return bloodBankMapper.toResponseDTO(saved);
    }

    @Override
    public List<BloodBankResponseDTO> getAllBloodBanks() {

        return bloodBankRepository.findAll()
                .stream()
                .map(bloodBankMapper::toResponseDTO)
                .toList();
    }

    @Override
    public BloodBankResponseDTO getBloodBankById(Long id) {

        BloodBank bloodBank = bloodBankRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Blood bank not found"));

        return bloodBankMapper.toResponseDTO(bloodBank);
    }

    @Override
    public BloodBankResponseDTO updateBloodBank(Long id,
                                                BloodBankRequestDTO requestDTO) {

        BloodBank bloodBank = bloodBankRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Blood bank not found"));

        bloodBank.setBloodBankName(requestDTO.getBloodBankName());
        bloodBank.setEmail(requestDTO.getEmail());
        bloodBank.setPhoneNumber(requestDTO.getPhoneNumber());
        bloodBank.setAddress(requestDTO.getAddress());

        bloodBank.setLatitude(requestDTO.getLatitude());
        bloodBank.setLongitude(requestDTO.getLongitude());

        bloodBank.setAPositive(requestDTO.getAPositive());
        bloodBank.setANegative(requestDTO.getANegative());
        bloodBank.setBPositive(requestDTO.getBPositive());
        bloodBank.setBNegative(requestDTO.getBNegative());
        bloodBank.setAbPositive(requestDTO.getAbPositive());
        bloodBank.setAbNegative(requestDTO.getAbNegative());
        bloodBank.setOPositive(requestDTO.getOPositive());
        bloodBank.setONegative(requestDTO.getONegative());

        BloodBank updated = bloodBankRepository.save(bloodBank);

        return bloodBankMapper.toResponseDTO(updated);
    }

    @Override
    public void deleteBloodBank(Long id) {

        BloodBank bloodBank = bloodBankRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Blood bank not found"));

        bloodBankRepository.delete(bloodBank);
    }
}