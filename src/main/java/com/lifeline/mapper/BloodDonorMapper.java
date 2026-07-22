package com.lifeline.mapper;

import com.lifeline.dto.BloodDonorRequestDTO;
import com.lifeline.dto.BloodDonorResponseDTO;
import com.lifeline.entity.BloodDonor;
import org.springframework.stereotype.Component;

@Component
public class BloodDonorMapper {

    // DTO -> Entity
    public BloodDonor toEntity(BloodDonorRequestDTO dto) {

        BloodDonor donor = new BloodDonor();

        donor.setBloodGroup(dto.getBloodGroup());
        donor.setCity(dto.getCity());
        donor.setLatitude(dto.getLatitude());
        donor.setLongitude(dto.getLongitude());
        donor.setAvailable(dto.getAvailable());
        donor.setLastDonationDate(dto.getLastDonationDate());

        return donor;
    }

    // Entity -> Response DTO
    public BloodDonorResponseDTO toResponseDTO(BloodDonor donor) {

        BloodDonorResponseDTO response = new BloodDonorResponseDTO();

        response.setId(donor.getId());

        if (donor.getUser() != null) {
            response.setDonorName(
                    donor.getUser().getFirstName()
                            + " "
                            + donor.getUser().getLastName()
            );

            response.setPhoneNumber(
                    donor.getUser().getPhoneNumber()
            );
        }

        response.setBloodGroup(donor.getBloodGroup());
        response.setCity(donor.getCity());
        response.setLatitude(donor.getLatitude());
        response.setLongitude(donor.getLongitude());
        response.setAvailable(donor.getAvailable());
        response.setLastDonationDate(donor.getLastDonationDate());

        return response;
    }
}