package com.lifeline.service;

import com.lifeline.dto.SOSContactRequestDTO;
import com.lifeline.dto.SOSContactResponseDTO;

import java.util.List;

public interface SOSContactService {

    SOSContactResponseDTO addContact(SOSContactRequestDTO requestDTO);

    List<SOSContactResponseDTO> getMyContacts();

    SOSContactResponseDTO getContactById(Long id);

    SOSContactResponseDTO updateContact(
            Long id,
            SOSContactRequestDTO requestDTO);

    void deleteContact(Long id);
}