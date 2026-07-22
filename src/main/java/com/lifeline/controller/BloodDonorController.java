package com.lifeline.controller;

import com.lifeline.dto.BloodDonorRequestDTO;
import com.lifeline.dto.BloodDonorResponseDTO;
import com.lifeline.enums.BloodGroup;
import com.lifeline.service.BloodDonorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/donors")
@RequiredArgsConstructor
public class BloodDonorController {

    private final BloodDonorService bloodDonorService;

    @PostMapping
    public ResponseEntity<BloodDonorResponseDTO> registerDonor(
            @RequestBody BloodDonorRequestDTO requestDTO) {

        return new ResponseEntity<>(
                bloodDonorService.registerDonor(requestDTO),
                HttpStatus.CREATED
        );
    }

    @GetMapping
    public ResponseEntity<List<BloodDonorResponseDTO>> getAllDonors() {

        return ResponseEntity.ok(
                bloodDonorService.getAllDonors()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<BloodDonorResponseDTO> getDonorById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                bloodDonorService.getDonorById(id)
        );
    }

    @GetMapping("/blood-group/{bloodGroup}")
    public ResponseEntity<List<BloodDonorResponseDTO>> getByBloodGroup(
            @PathVariable BloodGroup bloodGroup) {

        return ResponseEntity.ok(
                bloodDonorService.getDonorsByBloodGroup(bloodGroup)
        );
    }

    @GetMapping("/available")
    public ResponseEntity<List<BloodDonorResponseDTO>> getAvailableDonors() {

        return ResponseEntity.ok(
                bloodDonorService.getAvailableDonors()
        );
    }

    @PutMapping("/{id}/availability")
    public ResponseEntity<BloodDonorResponseDTO> updateAvailability(
            @PathVariable Long id,
            @RequestParam Boolean available) {

        return ResponseEntity.ok(
                bloodDonorService.updateAvailability(id, available)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDonor(
            @PathVariable Long id) {

        bloodDonorService.deleteDonor(id);

        return ResponseEntity.ok(
                "Blood donor deleted successfully"
        );
    }
}