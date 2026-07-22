package com.lifeline.dto;

import com.lifeline.enums.OrganType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrganDonationResponseDTO {

    private Long id;

    private Long hospitalId;

    private String hospitalName;

    private String donorName;

    private OrganType organType;

    private String bloodGroup;

    private Boolean available;
}