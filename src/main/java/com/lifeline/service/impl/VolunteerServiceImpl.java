package com.lifeline.service.impl;

import com.lifeline.dto.VolunteerRequestDTO;
import com.lifeline.dto.VolunteerResponseDTO;
import com.lifeline.entity.Volunteer;
import com.lifeline.exception.ResourceNotFoundException;
import com.lifeline.mapper.VolunteerMapper;
import com.lifeline.repository.VolunteerRepository;
import com.lifeline.service.VolunteerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VolunteerServiceImpl implements VolunteerService {

    private final VolunteerRepository volunteerRepository;
    private final VolunteerMapper volunteerMapper;

    @Override
    public VolunteerResponseDTO registerVolunteer(VolunteerRequestDTO requestDTO) {

        Volunteer volunteer = volunteerMapper.toEntity(requestDTO);

        Volunteer saved = volunteerRepository.save(volunteer);

        return volunteerMapper.toResponseDTO(saved);
    }

    @Override
    public List<VolunteerResponseDTO> getAllVolunteers() {

        return volunteerRepository.findAll()
                .stream()
                .map(volunteerMapper::toResponseDTO)
                .toList();
    }

    @Override
    public VolunteerResponseDTO getVolunteerById(Long id) {

        Volunteer volunteer = volunteerRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Volunteer not found"));

        return volunteerMapper.toResponseDTO(volunteer);
    }

    @Override
    public List<VolunteerResponseDTO> getVolunteersByCity(String city) {

        return volunteerRepository.findByCityIgnoreCase(city)
                .stream()
                .map(volunteerMapper::toResponseDTO)
                .toList();
    }

    @Override
    public List<VolunteerResponseDTO> getAvailableVolunteers() {

        return volunteerRepository.findByAvailableTrue()
                .stream()
                .map(volunteerMapper::toResponseDTO)
                .toList();
    }

    @Override
    public VolunteerResponseDTO updateAvailability(Long id, Boolean available) {

        Volunteer volunteer = volunteerRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Volunteer not found"));

        volunteer.setAvailable(available);

        Volunteer updated = volunteerRepository.save(volunteer);

        return volunteerMapper.toResponseDTO(updated);
    }

    @Override
    public void deleteVolunteer(Long id) {

        volunteerRepository.deleteById(id);
    }
}