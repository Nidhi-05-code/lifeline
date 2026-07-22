package com.lifeline.mapper;

import com.lifeline.dto.EmergencyRequestDTO;
import com.lifeline.dto.EmergencyResponseDTO;
import com.lifeline.entity.EmergencyRequest;
import org.springframework.stereotype.Component;


@Component
public class EmergencyMapper {


    // DTO -> Entity
    public EmergencyRequest toEntity(EmergencyRequestDTO dto) {

        EmergencyRequest emergency = new EmergencyRequest();

        emergency.setEmergencyType(dto.getEmergencyType());
        emergency.setDescription(dto.getDescription());
        emergency.setLatitude(dto.getLatitude());
        emergency.setLongitude(dto.getLongitude());
        emergency.setAddress(dto.getAddress());

        return emergency;
    }


    // Entity -> Response DTO
    public EmergencyResponseDTO toResponseDTO(EmergencyRequest emergency) {

        EmergencyResponseDTO response = new EmergencyResponseDTO();

        response.setId(emergency.getId());

        if (emergency.getPatient() != null) {
            response.setPatientName(
                    emergency.getPatient().getFirstName()
                            + " "
                            + emergency.getPatient().getLastName()
            );
        }
        if (emergency.getAmbulance() != null) {

            response.setAmbulanceId(emergency.getAmbulance().getId());

            response.setVehicleNumber(emergency.getAmbulance().getVehicleNumber());

            response.setDriverName(emergency.getAmbulance().getDriverName());
        }

        response.setEmergencyType(
                emergency.getEmergencyType()
        );

        response.setDescription(
                emergency.getDescription()
        );

        response.setLatitude(
                emergency.getLatitude()
        );

        response.setLongitude(
                emergency.getLongitude()
        );

        response.setAddress(
                emergency.getAddress()
        );

        response.setStatus(
                emergency.getStatus()
        );

        response.setPriority(
                emergency.getPriority()
        );

        return response;
    }
}