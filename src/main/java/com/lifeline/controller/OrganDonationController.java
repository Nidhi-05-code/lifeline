package com.lifeline.controller;

import com.lifeline.dto.OrganDonationRequestDTO;
import com.lifeline.dto.OrganDonationResponseDTO;
import com.lifeline.enums.OrganType;
import com.lifeline.service.OrganDonationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/organs")
@RequiredArgsConstructor
public class OrganDonationController {

    private final OrganDonationService donationService;

    @PostMapping
    public ResponseEntity<OrganDonationResponseDTO> registerDonation(
            @RequestBody OrganDonationRequestDTO requestDTO) {

        return new ResponseEntity<>(
                donationService.registerDonation(requestDTO),
                HttpStatus.CREATED
        );
    }

    @GetMapping
    public ResponseEntity<List<OrganDonationResponseDTO>> getAllDonations() {

        return ResponseEntity.ok(
                donationService.getAllDonations()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrganDonationResponseDTO> getDonationById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                donationService.getDonationById(id)
        );
    }

    @GetMapping("/available")
    public ResponseEntity<List<OrganDonationResponseDTO>> getAvailableOrgans() {

        return ResponseEntity.ok(
                donationService.getAvailableOrgans()
        );
    }

    @GetMapping("/type/{organType}")
    public ResponseEntity<List<OrganDonationResponseDTO>> getByOrganType(
            @PathVariable OrganType organType) {

        return ResponseEntity.ok(
                donationService.getByOrganType(organType)
        );
    }

    @GetMapping("/hospital/{hospitalId}")
    public ResponseEntity<List<OrganDonationResponseDTO>> getByHospital(
            @PathVariable Long hospitalId) {

        return ResponseEntity.ok(
                donationService.getByHospital(hospitalId)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDonation(
            @PathVariable Long id) {

        donationService.deleteDonation(id);

        return ResponseEntity.ok(
                "Organ donation deleted successfully"
        );
    }
}