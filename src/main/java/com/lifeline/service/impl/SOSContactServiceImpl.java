package com.lifeline.service.impl;

import com.lifeline.dto.SOSContactRequestDTO;
import com.lifeline.dto.SOSContactResponseDTO;
import com.lifeline.entity.SOSContact;
import com.lifeline.entity.User;
import com.lifeline.exception.ResourceNotFoundException;
import com.lifeline.mapper.SOSContactMapper;
import com.lifeline.repository.SOSContactRepository;
import com.lifeline.repository.UserRepository;
import com.lifeline.service.SOSContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SOSContactServiceImpl implements SOSContactService {

    private final SOSContactRepository contactRepository;
    private final UserRepository userRepository;
    private final SOSContactMapper contactMapper;

    @Override
    public SOSContactResponseDTO addContact(
            SOSContactRequestDTO requestDTO) {

        String email = SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName();

        User user = userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User not found"));

        SOSContact contact = contactMapper.toEntity(requestDTO);

        contact.setUser(user);

        SOSContact saved = contactRepository.save(contact);

        return contactMapper.toResponseDTO(saved);
    }

    @Override
    public List<SOSContactResponseDTO> getMyContacts() {

        String email = SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName();

        User user = userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User not found"));

        return contactRepository.findByUser(user)
                .stream()
                .map(contactMapper::toResponseDTO)
                .toList();
    }

    @Override
    public SOSContactResponseDTO getContactById(Long id) {

        SOSContact contact = contactRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Contact not found"));

        return contactMapper.toResponseDTO(contact);
    }

    @Override
    public SOSContactResponseDTO updateContact(
            Long id,
            SOSContactRequestDTO requestDTO) {

        SOSContact contact = contactRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Contact not found"));

        contact.setContactName(requestDTO.getContactName());
        contact.setRelationship(requestDTO.getRelationship());
        contact.setPhoneNumber(requestDTO.getPhoneNumber());
        contact.setPrimaryContact(requestDTO.getPrimaryContact());

        SOSContact updated = contactRepository.save(contact);

        return contactMapper.toResponseDTO(updated);
    }

    @Override
    public void deleteContact(Long id) {

        contactRepository.deleteById(id);
    }
}