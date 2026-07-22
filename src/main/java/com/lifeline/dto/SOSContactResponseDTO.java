package com.lifeline.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SOSContactResponseDTO {

    private Long id;

    private String userName;

    private String contactName;

    private String relationship;

    private String phoneNumber;

    private Boolean primaryContact;
}