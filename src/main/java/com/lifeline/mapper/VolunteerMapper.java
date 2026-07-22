package com.lifeline.mapper;

import com.lifeline.dto.VolunteerRequestDTO;
import com.lifeline.dto.VolunteerResponseDTO;
import com.lifeline.entity.Volunteer;
import org.springframework.stereotype.Component;

@Component
public class VolunteerMapper {

    public Volunteer toEntity(VolunteerRequestDTO dto) {

        Volunteer volunteer = new Volunteer();

        volunteer.setFirstName(dto.getFirstName());
        volunteer.setLastName(dto.getLastName());
        volunteer.setEmail(dto.getEmail());
        volunteer.setPhoneNumber(dto.getPhoneNumber());
        volunteer.setCity(dto.getCity());
        volunteer.setLatitude(dto.getLatitude());
        volunteer.setLongitude(dto.getLongitude());
        volunteer.setSkills(dto.getSkills());
        volunteer.setAvailable(dto.getAvailable());

        return volunteer;
    }

    public VolunteerResponseDTO toResponseDTO(Volunteer volunteer) {

        VolunteerResponseDTO response = new VolunteerResponseDTO();

        response.setId(volunteer.getId());
        response.setFirstName(volunteer.getFirstName());
        response.setLastName(volunteer.getLastName());
        response.setEmail(volunteer.getEmail());
        response.setPhoneNumber(volunteer.getPhoneNumber());
        response.setCity(volunteer.getCity());
        response.setLatitude(volunteer.getLatitude());
        response.setLongitude(volunteer.getLongitude());
        response.setSkills(volunteer.getSkills());
        response.setAvailable(volunteer.getAvailable());

        return response;
    }
}