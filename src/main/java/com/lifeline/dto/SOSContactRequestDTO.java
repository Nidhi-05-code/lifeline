package com.lifeline.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SOSContactRequestDTO {

    @NotBlank
    private String contactName;

    @NotBlank
    private String relationship;

    @NotBlank
    private String phoneNumber;

    private Boolean primaryContact = false;
}