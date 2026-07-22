package com.lifeline.mapper;

import com.lifeline.dto.BloodBankRequestDTO;
import com.lifeline.dto.BloodBankResponseDTO;
import com.lifeline.entity.BloodBank;
import org.springframework.stereotype.Component;

@Component
public class BloodBankMapper {

    public BloodBank toEntity(BloodBankRequestDTO dto) {

        BloodBank bank = new BloodBank();

        bank.setBloodBankName(dto.getBloodBankName());
        bank.setEmail(dto.getEmail());
        bank.setPhoneNumber(dto.getPhoneNumber());
        bank.setAddress(dto.getAddress());

        bank.setLatitude(dto.getLatitude());
        bank.setLongitude(dto.getLongitude());

        bank.setAPositive(dto.getAPositive());
        bank.setANegative(dto.getANegative());

        bank.setBPositive(dto.getBPositive());
        bank.setBNegative(dto.getBNegative());

        bank.setAbPositive(dto.getAbPositive());
        bank.setAbNegative(dto.getAbNegative());

        bank.setOPositive(dto.getOPositive());
        bank.setONegative(dto.getONegative());

        return bank;
    }

    public BloodBankResponseDTO toResponseDTO(BloodBank bank) {

        BloodBankResponseDTO dto = new BloodBankResponseDTO();

        dto.setId(bank.getId());

        dto.setBloodBankName(bank.getBloodBankName());
        dto.setEmail(bank.getEmail());
        dto.setPhoneNumber(bank.getPhoneNumber());
        dto.setAddress(bank.getAddress());

        dto.setLatitude(bank.getLatitude());
        dto.setLongitude(bank.getLongitude());

        dto.setAPositive(bank.getAPositive());
        dto.setANegative(bank.getANegative());

        dto.setBPositive(bank.getBPositive());
        dto.setBNegative(bank.getBNegative());

        dto.setAbPositive(bank.getAbPositive());
        dto.setAbNegative(bank.getAbNegative());

        dto.setOPositive(bank.getOPositive());
        dto.setONegative(bank.getONegative());

        return dto;
    }
}