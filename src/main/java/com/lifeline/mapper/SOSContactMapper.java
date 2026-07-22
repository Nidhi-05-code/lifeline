package com.lifeline.mapper;

import com.lifeline.dto.SOSContactRequestDTO;
import com.lifeline.dto.SOSContactResponseDTO;
import com.lifeline.entity.SOSContact;
import org.springframework.stereotype.Component;

@Component
public class SOSContactMapper {

    public SOSContact toEntity(SOSContactRequestDTO dto) {

        SOSContact contact = new SOSContact();

        contact.setContactName(dto.getContactName());
        contact.setRelationship(dto.getRelationship());
        contact.setPhoneNumber(dto.getPhoneNumber());
        contact.setPrimaryContact(dto.getPrimaryContact());

        return contact;
    }

    public SOSContactResponseDTO toResponseDTO(SOSContact contact) {

        SOSContactResponseDTO response = new SOSContactResponseDTO();

        response.setId(contact.getId());

        if (contact.getUser() != null) {
            response.setUserName(
                    contact.getUser().getFirstName() + " " +
                            contact.getUser().getLastName()
            );
        }

        response.setContactName(contact.getContactName());
        response.setRelationship(contact.getRelationship());
        response.setPhoneNumber(contact.getPhoneNumber());
        response.setPrimaryContact(contact.getPrimaryContact());

        return response;
    }
}
