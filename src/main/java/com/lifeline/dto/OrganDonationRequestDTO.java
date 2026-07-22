package com.lifeline.dto;

import com.lifeline.enums.OrganType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrganDonationRequestDTO {

    @NotNull
    private Long hospitalId;

    @NotBlank
    private String donorName;

    @NotNull
    private OrganType organType;

    @NotBlank
    private String bloodGroup;

    private Boolean available = true;
}