package com.lifeline.service;

import com.lifeline.dto.VolunteerRequestDTO;
import com.lifeline.dto.VolunteerResponseDTO;

import java.util.List;

public interface VolunteerService {

    VolunteerResponseDTO registerVolunteer(VolunteerRequestDTO requestDTO);

    List<VolunteerResponseDTO> getAllVolunteers();

    VolunteerResponseDTO getVolunteerById(Long id);

    List<VolunteerResponseDTO> getVolunteersByCity(String city);

    List<VolunteerResponseDTO> getAvailableVolunteers();

    VolunteerResponseDTO updateAvailability(Long id, Boolean available);

    void deleteVolunteer(Long id);
}