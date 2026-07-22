package com.lifeline.service.impl;

import com.lifeline.dto.MedicineRequestDTO;
import com.lifeline.dto.MedicineResponseDTO;
import com.lifeline.entity.Hospital;
import com.lifeline.entity.Medicine;
import com.lifeline.exception.ResourceNotFoundException;
import com.lifeline.mapper.MedicineMapper;
import com.lifeline.repository.HospitalRepository;
import com.lifeline.repository.MedicineRepository;
import com.lifeline.service.MedicineService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MedicineServiceImpl implements MedicineService {

    private final MedicineRepository medicineRepository;
    private final HospitalRepository hospitalRepository;
    private final MedicineMapper medicineMapper;

    @Override
    public MedicineResponseDTO addMedicine(MedicineRequestDTO requestDTO) {

        Hospital hospital = hospitalRepository.findById(requestDTO.getHospitalId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Hospital not found"));

        Medicine medicine = medicineMapper.toEntity(requestDTO);
        medicine.setHospital(hospital);

        Medicine saved = medicineRepository.save(medicine);

        return medicineMapper.toResponseDTO(saved);
    }

    @Override
    public List<MedicineResponseDTO> getAllMedicines() {

        return medicineRepository.findAll()
                .stream()
                .map(medicineMapper::toResponseDTO)
                .toList();
    }

    @Override
    public MedicineResponseDTO getMedicineById(Long id) {

        Medicine medicine = medicineRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Medicine not found"));

        return medicineMapper.toResponseDTO(medicine);
    }

    @Override
    public List<MedicineResponseDTO> searchMedicine(String medicineName) {

        return medicineRepository
                .findByMedicineNameContainingIgnoreCase(medicineName)
                .stream()
                .map(medicineMapper::toResponseDTO)
                .toList();
    }

    @Override
    public List<MedicineResponseDTO> getMedicinesByHospital(Long hospitalId) {

        Hospital hospital = hospitalRepository.findById(hospitalId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Hospital not found"));

        return medicineRepository.findByHospital(hospital)
                .stream()
                .map(medicineMapper::toResponseDTO)
                .toList();
    }

    @Override
    public List<MedicineResponseDTO> getAvailableMedicines() {

        return medicineRepository.findByAvailableTrue()
                .stream()
                .map(medicineMapper::toResponseDTO)
                .toList();
    }

    @Override
    public MedicineResponseDTO updateMedicine(Long id,
                                              MedicineRequestDTO requestDTO) {

        Medicine medicine = medicineRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Medicine not found"));

        Hospital hospital = hospitalRepository.findById(requestDTO.getHospitalId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Hospital not found"));

        medicine.setHospital(hospital);
        medicine.setMedicineName(requestDTO.getMedicineName());
        medicine.setManufacturer(requestDTO.getManufacturer());
        medicine.setQuantity(requestDTO.getQuantity());
        medicine.setPrice(requestDTO.getPrice());
        medicine.setExpiryDate(requestDTO.getExpiryDate());
        medicine.setAvailable(requestDTO.getAvailable());

        Medicine updated = medicineRepository.save(medicine);

        return medicineMapper.toResponseDTO(updated);
    }

    @Override
    public void deleteMedicine(Long id) {

        medicineRepository.deleteById(id);
    }
}