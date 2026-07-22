package com.lifeline.controller;

import com.lifeline.dto.BloodBankRequestDTO;
import com.lifeline.dto.BloodBankResponseDTO;
import com.lifeline.service.BloodBankService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blood-banks")
@RequiredArgsConstructor
public class BloodBankController {

    private final BloodBankService bloodBankService;

    @PostMapping
    public ResponseEntity<BloodBankResponseDTO> createBloodBank(
            @RequestBody BloodBankRequestDTO requestDTO) {

        return new ResponseEntity<>(
                bloodBankService.createBloodBank(requestDTO),
                HttpStatus.CREATED
        );
    }

    @GetMapping
    public ResponseEntity<List<BloodBankResponseDTO>> getAllBloodBanks() {

        return ResponseEntity.ok(
                bloodBankService.getAllBloodBanks()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<BloodBankResponseDTO> getBloodBankById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                bloodBankService.getBloodBankById(id)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<BloodBankResponseDTO> updateBloodBank(
            @PathVariable Long id,
            @RequestBody BloodBankRequestDTO requestDTO) {

        return ResponseEntity.ok(
                bloodBankService.updateBloodBank(id, requestDTO)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBloodBank(
            @PathVariable Long id) {

        bloodBankService.deleteBloodBank(id);

        return ResponseEntity.ok("Blood bank deleted successfully");
    }
}