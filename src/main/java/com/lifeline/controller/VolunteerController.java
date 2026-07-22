package com.lifeline.controller;

import com.lifeline.dto.VolunteerRequestDTO;
import com.lifeline.dto.VolunteerResponseDTO;
import com.lifeline.service.VolunteerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/volunteers")
@RequiredArgsConstructor
public class VolunteerController {

    private final VolunteerService volunteerService;

    @PostMapping
    public ResponseEntity<VolunteerResponseDTO> registerVolunteer(
            @RequestBody VolunteerRequestDTO requestDTO) {

        return new ResponseEntity<>(
                volunteerService.registerVolunteer(requestDTO),
                HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<VolunteerResponseDTO>> getAllVolunteers() {

        return ResponseEntity.ok(
                volunteerService.getAllVolunteers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<VolunteerResponseDTO> getVolunteerById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                volunteerService.getVolunteerById(id));
    }

    @GetMapping("/city/{city}")
    public ResponseEntity<List<VolunteerResponseDTO>> getVolunteersByCity(
            @PathVariable String city) {

        return ResponseEntity.ok(
                volunteerService.getVolunteersByCity(city));
    }

    @GetMapping("/available")
    public ResponseEntity<List<VolunteerResponseDTO>> getAvailableVolunteers() {

        return ResponseEntity.ok(
                volunteerService.getAvailableVolunteers());
    }

    @PutMapping("/{id}/availability")
    public ResponseEntity<VolunteerResponseDTO> updateAvailability(
            @PathVariable Long id,
            @RequestParam Boolean available) {

        return ResponseEntity.ok(
                volunteerService.updateAvailability(id, available));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteVolunteer(
            @PathVariable Long id) {

        volunteerService.deleteVolunteer(id);

        return ResponseEntity.ok("Volunteer deleted successfully");
    }
}