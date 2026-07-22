package com.lifeline.service;

import com.lifeline.dto.MedicineRequestDTO;
import com.lifeline.dto.MedicineResponseDTO;

import java.util.List;

public interface MedicineService {

    MedicineResponseDTO addMedicine(MedicineRequestDTO requestDTO);

    List<MedicineResponseDTO> getAllMedicines();

    MedicineResponseDTO getMedicineById(Long id);

    List<MedicineResponseDTO> searchMedicine(String medicineName);

    List<MedicineResponseDTO> getMedicinesByHospital(Long hospitalId);

    List<MedicineResponseDTO> getAvailableMedicines();

    MedicineResponseDTO updateMedicine(Long id,
                                       MedicineRequestDTO requestDTO);

    void deleteMedicine(Long id);
}