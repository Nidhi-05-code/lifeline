package com.lifeline.mapper;

import com.lifeline.dto.OrganDonationRequestDTO;
import com.lifeline.dto.OrganDonationResponseDTO;
import com.lifeline.entity.OrganDonation;
import org.springframework.stereotype.Component;

@Component
public class OrganDonationMapper {

    public OrganDonation toEntity(OrganDonationRequestDTO dto) {

        OrganDonation donation = new OrganDonation();

        donation.setDonorName(dto.getDonorName());
        donation.setOrganType(dto.getOrganType());
        donation.setBloodGroup(dto.getBloodGroup());
        donation.setAvailable(dto.getAvailable());

        return donation;
    }

    public OrganDonationResponseDTO toResponseDTO(OrganDonation donation) {

        OrganDonationResponseDTO response = new OrganDonationResponseDTO();

        response.setId(donation.getId());

        if (donation.getHospital() != null) {
            response.setHospitalId(donation.getHospital().getId());
            response.setHospitalName(donation.getHospital().getHospitalName());
        }

        response.setDonorName(donation.getDonorName());
        response.setOrganType(donation.getOrganType());
        response.setBloodGroup(donation.getBloodGroup());
        response.setAvailable(donation.getAvailable());

        return response;
    }
}