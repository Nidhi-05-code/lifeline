package com.lifeline.controller;


import com.lifeline.dto.AmbulanceRequestDTO;
import com.lifeline.dto.AmbulanceResponseDTO;
import com.lifeline.service.AmbulanceService;

import jakarta.validation.Valid;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/ambulances")
@RequiredArgsConstructor
public class AmbulanceController {


    private final AmbulanceService ambulanceService;



    // Create ambulance
    @PostMapping
    public ResponseEntity<AmbulanceResponseDTO> createAmbulance(
            @Valid @RequestBody AmbulanceRequestDTO requestDTO) {


        return new ResponseEntity<>(
                ambulanceService.createAmbulance(requestDTO),
                HttpStatus.CREATED
        );
    }



    // Get all ambulances
    @GetMapping
    public ResponseEntity<List<AmbulanceResponseDTO>> getAllAmbulances() {


        return ResponseEntity.ok(
                ambulanceService.getAllAmbulances()
        );
    }



    // Get ambulance by id
    @GetMapping("/{id}")
    public ResponseEntity<AmbulanceResponseDTO> getAmbulanceById(
            @PathVariable Long id) {


        return ResponseEntity.ok(
                ambulanceService.getAmbulanceById(id)
        );
    }



    // Get available ambulances
    @GetMapping("/available")
    public ResponseEntity<List<AmbulanceResponseDTO>> getAvailableAmbulances() {


        return ResponseEntity.ok(
                ambulanceService.getAvailableAmbulances()
        );
    }



    // Update ambulance status
    @PutMapping("/{id}/status")
    public ResponseEntity<AmbulanceResponseDTO> updateStatus(
            @PathVariable Long id,
            @RequestParam String status) {


        return ResponseEntity.ok(
                ambulanceService.updateStatus(id, status)
        );
    }



    // Delete ambulance
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAmbulance(
            @PathVariable Long id) {


        ambulanceService.deleteAmbulance(id);

        return ResponseEntity.ok(
                "Ambulance deleted successfully"
        );
    }

}