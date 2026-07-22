package com.lifeline.controller;

import com.lifeline.dto.SOSContactRequestDTO;
import com.lifeline.dto.SOSContactResponseDTO;
import com.lifeline.service.SOSContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sos")
@RequiredArgsConstructor
public class SOSContactController {

    private final SOSContactService contactService;

    @PostMapping
    public ResponseEntity<SOSContactResponseDTO> addContact(
            @RequestBody SOSContactRequestDTO requestDTO) {

        return new ResponseEntity<>(
                contactService.addContact(requestDTO),
                HttpStatus.CREATED
        );
    }

    @GetMapping
    public ResponseEntity<List<SOSContactResponseDTO>> getMyContacts() {

        return ResponseEntity.ok(
                contactService.getMyContacts()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<SOSContactResponseDTO> getContactById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                contactService.getContactById(id)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<SOSContactResponseDTO> updateContact(
            @PathVariable Long id,
            @RequestBody SOSContactRequestDTO requestDTO) {

        return ResponseEntity.ok(
                contactService.updateContact(id, requestDTO)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteContact(
            @PathVariable Long id) {

        contactService.deleteContact(id);

        return ResponseEntity.ok(
                "SOS Contact deleted successfully"
        );
    }
}