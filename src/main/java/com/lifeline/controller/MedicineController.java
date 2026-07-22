package com.lifeline.controller;

import com.lifeline.dto.MedicineRequestDTO;
import com.lifeline.dto.MedicineResponseDTO;
import com.lifeline.service.MedicineService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medicines")
@RequiredArgsConstructor
public class MedicineController {

    private final MedicineService medicineService;

    @PostMapping
    public ResponseEntity<MedicineResponseDTO> addMedicine(
            @RequestBody MedicineRequestDTO requestDTO) {

        return new ResponseEntity<>(
                medicineService.addMedicine(requestDTO),
                HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<MedicineResponseDTO>> getAllMedicines() {

        return ResponseEntity.ok(
                medicineService.getAllMedicines());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicineResponseDTO> getMedicineById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                medicineService.getMedicineById(id));
    }

    @GetMapping("/search")
    public ResponseEntity<List<MedicineResponseDTO>> searchMedicine(
            @RequestParam String medicineName) {

        return ResponseEntity.ok(
                medicineService.searchMedicine(medicineName));
    }

    @GetMapping("/hospital/{hospitalId}")
    public ResponseEntity<List<MedicineResponseDTO>> getMedicinesByHospital(
            @PathVariable Long hospitalId) {

        return ResponseEntity.ok(
                medicineService.getMedicinesByHospital(hospitalId));
    }

    @GetMapping("/available")
    public ResponseEntity<List<MedicineResponseDTO>> getAvailableMedicines() {

        return ResponseEntity.ok(
                medicineService.getAvailableMedicines());
    }

    @PutMapping("/{id}")
    public ResponseEntity<MedicineResponseDTO> updateMedicine(
            @PathVariable Long id,
            @RequestBody MedicineRequestDTO requestDTO) {

        return ResponseEntity.ok(
                medicineService.updateMedicine(id, requestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMedicine(
            @PathVariable Long id) {

        medicineService.deleteMedicine(id);

        return ResponseEntity.ok("Medicine deleted successfully");
    }
}