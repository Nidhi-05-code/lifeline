package com.lifeline.mapper;

import com.lifeline.dto.HospitalRequestDTO;
import com.lifeline.dto.HospitalResponseDTO;
import com.lifeline.entity.Hospital;
import org.springframework.stereotype.Component;

@Component
public class HospitalMapper {

    public Hospital toEntity(HospitalRequestDTO dto) {

        Hospital hospital = new Hospital();

        hospital.setHospitalName(dto.getHospitalName());
        hospital.setEmail(dto.getEmail());
        hospital.setPhoneNumber(dto.getPhoneNumber());
        hospital.setAddress(dto.getAddress());
        hospital.setLatitude(dto.getLatitude());
        hospital.setLongitude(dto.getLongitude());
        hospital.setTotalBeds(dto.getTotalBeds());
        hospital.setAvailableBeds(dto.getAvailableBeds());
        hospital.setIcuBeds(dto.getIcuBeds());
        hospital.setAvailableIcuBeds(dto.getAvailableIcuBeds());
        hospital.setEmergencyAvailable(dto.getEmergencyAvailable());

        return hospital;
    }

    public HospitalResponseDTO toResponseDTO(Hospital hospital) {

        HospitalResponseDTO dto = new HospitalResponseDTO();

        dto.setId(hospital.getId());
        dto.setHospitalName(hospital.getHospitalName());
        dto.setEmail(hospital.getEmail());
        dto.setPhoneNumber(hospital.getPhoneNumber());
        dto.setAddress(hospital.getAddress());
        dto.setLatitude(hospital.getLatitude());
        dto.setLongitude(hospital.getLongitude());
        dto.setTotalBeds(hospital.getTotalBeds());
        dto.setAvailableBeds(hospital.getAvailableBeds());
        dto.setIcuBeds(hospital.getIcuBeds());
        dto.setAvailableIcuBeds(hospital.getAvailableIcuBeds());
        dto.setEmergencyAvailable(hospital.getEmergencyAvailable());

        return dto;
    }
}