package com.lifeline.controller;


import com.lifeline.dto.EmergencyRequestDTO;
import com.lifeline.dto.EmergencyResponseDTO;
import com.lifeline.service.EmergencyService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/emergencies")
@RequiredArgsConstructor
public class EmergencyController {


    private final EmergencyService emergencyService;



    @PostMapping
    public ResponseEntity<EmergencyResponseDTO> createEmergency(
            @RequestBody EmergencyRequestDTO requestDTO){


        return new ResponseEntity<>(
                emergencyService.createEmergency(requestDTO),
                HttpStatus.CREATED
        );

    }



    @GetMapping
    public ResponseEntity<List<EmergencyResponseDTO>> getAll(){

        return ResponseEntity.ok(
                emergencyService.getAllEmergencies()
        );

    }



    @GetMapping("/{id}")
    public ResponseEntity<EmergencyResponseDTO> getById(
            @PathVariable Long id){


        return ResponseEntity.ok(
                emergencyService.getEmergencyById(id)
        );

    }



    @PutMapping("/{id}/status")
    public ResponseEntity<EmergencyResponseDTO> updateStatus(
            @PathVariable Long id,
            @RequestParam String status){


        return ResponseEntity.ok(
                emergencyService.updateStatus(id,status)
        );

    }



    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(
            @PathVariable Long id){


        emergencyService.deleteEmergency(id);


        return ResponseEntity.ok(
                "Emergency request deleted successfully"
        );

    }

}