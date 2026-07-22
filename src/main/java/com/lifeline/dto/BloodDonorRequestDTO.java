package com.lifeline.dto;

import com.lifeline.enums.BloodGroup;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class BloodDonorRequestDTO {

    @NotNull
    private BloodGroup bloodGroup;

    @NotBlank
    private String city;

    @NotNull
    private Double latitude;

    @NotNull
    private Double longitude;

    private Boolean available = true;

    private LocalDate lastDonationDate;
}