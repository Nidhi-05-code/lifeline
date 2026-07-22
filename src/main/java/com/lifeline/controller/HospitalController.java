package com.lifeline.controller;

import com.lifeline.dto.HospitalRequestDTO;
import com.lifeline.dto.HospitalResponseDTO;
import com.lifeline.service.HospitalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hospitals")
@RequiredArgsConstructor
public class HospitalController {

    private final HospitalService hospitalService;

    @PostMapping
    public ResponseEntity<HospitalResponseDTO> createHospital(
            @RequestBody HospitalRequestDTO requestDTO) {

        return new ResponseEntity<>(
                hospitalService.createHospital(requestDTO),
                HttpStatus.CREATED
        );
    }

    @GetMapping
    public ResponseEntity<List<HospitalResponseDTO>> getAllHospitals() {

        return ResponseEntity.ok(
                hospitalService.getAllHospitals()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<HospitalResponseDTO> getHospitalById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                hospitalService.getHospitalById(id)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<HospitalResponseDTO> updateHospital(
            @PathVariable Long id,
            @RequestBody HospitalRequestDTO requestDTO) {

        return ResponseEntity.ok(
                hospitalService.updateHospital(id, requestDTO)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteHospital(
            @PathVariable Long id) {

        hospitalService.deleteHospital(id);

        return ResponseEntity.ok("Hospital deleted successfully");
    }
}