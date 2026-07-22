package com.lifeline.service.impl;

import com.lifeline.dto.BloodDonorRequestDTO;
import com.lifeline.dto.BloodDonorResponseDTO;
import com.lifeline.entity.BloodDonor;
import com.lifeline.entity.User;
import com.lifeline.enums.BloodGroup;
import com.lifeline.exception.ResourceAlreadyExistsException;
import com.lifeline.exception.ResourceNotFoundException;
import com.lifeline.mapper.BloodDonorMapper;
import com.lifeline.repository.BloodDonorRepository;
import com.lifeline.repository.UserRepository;
import com.lifeline.service.BloodDonorService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BloodDonorServiceImpl implements BloodDonorService {

    private final BloodDonorRepository bloodDonorRepository;
    private final BloodDonorMapper bloodDonorMapper;
    private final UserRepository userRepository;

    @Override
    public BloodDonorResponseDTO registerDonor(BloodDonorRequestDTO requestDTO) {

        String email = SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName();

        User user = userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User not found"));

        if (bloodDonorRepository.findByUser(user).isPresent()) {
            throw new ResourceAlreadyExistsException(
                    "User is already registered as a blood donor");
        }

        BloodDonor donor = bloodDonorMapper.toEntity(requestDTO);
        donor.setUser(user);

        BloodDonor saved = bloodDonorRepository.save(donor);

        return bloodDonorMapper.toResponseDTO(saved);
    }

    @Override
    public List<BloodDonorResponseDTO> getAllDonors() {

        return bloodDonorRepository.findAll()
                .stream()
                .map(bloodDonorMapper::toResponseDTO)
                .toList();
    }

    @Override
    public BloodDonorResponseDTO getDonorById(Long id) {

        BloodDonor donor = bloodDonorRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Blood donor not found"));

        return bloodDonorMapper.toResponseDTO(donor);
    }

    @Override
    public List<BloodDonorResponseDTO> getDonorsByBloodGroup(BloodGroup bloodGroup) {

        return bloodDonorRepository.findByBloodGroup(bloodGroup)
                .stream()
                .map(bloodDonorMapper::toResponseDTO)
                .toList();
    }

    @Override
    public List<BloodDonorResponseDTO> getAvailableDonors() {

        return bloodDonorRepository.findByAvailableTrue()
                .stream()
                .map(bloodDonorMapper::toResponseDTO)
                .toList();
    }

    @Override
    public BloodDonorResponseDTO updateAvailability(Long id, Boolean available) {

        BloodDonor donor = bloodDonorRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Blood donor not found"));

        donor.setAvailable(available);

        BloodDonor updated = bloodDonorRepository.save(donor);

        return bloodDonorMapper.toResponseDTO(updated);
    }

    @Override
    public void deleteDonor(Long id) {

        bloodDonorRepository.deleteById(id);
    }
}