package com.lifeline.mapper;

import com.lifeline.dto.MedicineRequestDTO;
import com.lifeline.dto.MedicineResponseDTO;
import com.lifeline.entity.Medicine;
import org.springframework.stereotype.Component;

@Component
public class MedicineMapper {

    public Medicine toEntity(MedicineRequestDTO dto) {

        Medicine medicine = new Medicine();

        medicine.setMedicineName(dto.getMedicineName());
        medicine.setManufacturer(dto.getManufacturer());
        medicine.setQuantity(dto.getQuantity());
        medicine.setPrice(dto.getPrice());
        medicine.setExpiryDate(dto.getExpiryDate());
        medicine.setAvailable(dto.getAvailable());

        return medicine;
    }

    public MedicineResponseDTO toResponseDTO(Medicine medicine) {

        MedicineResponseDTO response = new MedicineResponseDTO();

        response.setId(medicine.getId());

        if (medicine.getHospital() != null) {

            response.setHospitalId(
                    medicine.getHospital().getId());

            response.setHospitalName(
                    medicine.getHospital().getHospitalName());
        }

        response.setMedicineName(medicine.getMedicineName());
        response.setManufacturer(medicine.getManufacturer());
        response.setQuantity(medicine.getQuantity());
        response.setPrice(medicine.getPrice());
        response.setExpiryDate(medicine.getExpiryDate());
        response.setAvailable(medicine.getAvailable());

        return response;
    }
}