package com.lifeline.mapper;


import com.lifeline.dto.AmbulanceRequestDTO;
import com.lifeline.dto.AmbulanceResponseDTO;
import com.lifeline.entity.Ambulance;
import org.springframework.stereotype.Component;


@Component
public class AmbulanceMapper {


    public Ambulance toEntity(AmbulanceRequestDTO dto) {


        Ambulance ambulance = new Ambulance();


        ambulance.setVehicleNumber(dto.getVehicleNumber());

        ambulance.setDriverName(dto.getDriverName());

        ambulance.setDriverPhone(dto.getDriverPhone());

        ambulance.setLatitude(dto.getLatitude());

        ambulance.setLongitude(dto.getLongitude());


        return ambulance;
    }



    public AmbulanceResponseDTO toResponseDTO(Ambulance ambulance) {


        AmbulanceResponseDTO response = new AmbulanceResponseDTO();


        response.setId(ambulance.getId());

        response.setVehicleNumber(
                ambulance.getVehicleNumber()
        );

        response.setDriverName(
                ambulance.getDriverName()
        );

        response.setDriverPhone(
                ambulance.getDriverPhone()
        );

        response.setLatitude(
                ambulance.getLatitude()
        );

        response.setLongitude(
                ambulance.getLongitude()
        );

        response.setStatus(
                ambulance.getStatus()
        );


        return response;
    }

}