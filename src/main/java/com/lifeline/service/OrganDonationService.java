package com.lifeline.service;

import com.lifeline.dto.OrganDonationRequestDTO;
import com.lifeline.dto.OrganDonationResponseDTO;
import com.lifeline.enums.OrganType;

import java.util.List;

public interface OrganDonationService {

    OrganDonationResponseDTO registerDonation(
            OrganDonationRequestDTO requestDTO);

    List<OrganDonationResponseDTO> getAllDonations();

    OrganDonationResponseDTO getDonationById(Long id);

    List<OrganDonationResponseDTO> getAvailableOrgans();

    List<OrganDonationResponseDTO> getByOrganType(
            OrganType organType);

    List<OrganDonationResponseDTO> getByHospital(
            Long hospitalId);

    void deleteDonation(Long id);
}