package com.lifeline.service.impl;

import com.lifeline.dto.OrganDonationRequestDTO;
import com.lifeline.dto.OrganDonationResponseDTO;
import com.lifeline.entity.Hospital;
import com.lifeline.entity.OrganDonation;
import com.lifeline.exception.ResourceNotFoundException;
import com.lifeline.mapper.OrganDonationMapper;
import com.lifeline.repository.HospitalRepository;
import com.lifeline.repository.OrganDonationRepository;
import com.lifeline.service.OrganDonationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrganDonationServiceImpl implements OrganDonationService {

    private final OrganDonationRepository donationRepository;
    private final HospitalRepository hospitalRepository;
    private final OrganDonationMapper donationMapper;

    @Override
    public OrganDonationResponseDTO registerDonation(
            OrganDonationRequestDTO requestDTO) {

        Hospital hospital = hospitalRepository.findById(requestDTO.getHospitalId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Hospital not found"));

        OrganDonation donation = donationMapper.toEntity(requestDTO);

        donation.setHospital(hospital);

        OrganDonation saved = donationRepository.save(donation);

        return donationMapper.toResponseDTO(saved);
    }

    @Override
    public List<OrganDonationResponseDTO> getAllDonations() {

        return donationRepository.findAll()
                .stream()
                .map(donationMapper::toResponseDTO)
                .toList();
    }

    @Override
    public OrganDonationResponseDTO getDonationById(Long id) {

        OrganDonation donation = donationRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Donation not found"));

        return donationMapper.toResponseDTO(donation);
    }

    @Override
    public List<OrganDonationResponseDTO> getAvailableOrgans() {

        return donationRepository.findByAvailableTrue()
                .stream()
                .map(donationMapper::toResponseDTO)
                .toList();
    }

    @Override
    public List<OrganDonationResponseDTO> getByOrganType(
            com.lifeline.enums.OrganType organType) {

        return donationRepository.findByOrganType(organType)
                .stream()
                .map(donationMapper::toResponseDTO)
                .toList();
    }

    @Override
    public List<OrganDonationResponseDTO> getByHospital(
            Long hospitalId) {

        Hospital hospital = hospitalRepository.findById(hospitalId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Hospital not found"));

        return donationRepository.findByHospital(hospital)
                .stream()
                .map(donationMapper::toResponseDTO)
                .toList();
    }

    @Override
    public void deleteDonation(Long id) {

        donationRepository.deleteById(id);
    }
}