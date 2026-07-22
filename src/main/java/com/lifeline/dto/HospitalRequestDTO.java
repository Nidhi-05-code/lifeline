package com.lifeline.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HospitalRequestDTO {

    @NotBlank
    private String hospitalName;

    @NotBlank
    private String email;

    @NotBlank
    private String phoneNumber;

    @NotBlank
    private String address;

    @NotNull
    private Double latitude;

    @NotNull
    private Double longitude;

    @NotNull
    private Integer totalBeds;

    @NotNull
    private Integer availableBeds;

    @NotNull
    private Integer icuBeds;

    @NotNull
    private Integer availableIcuBeds;

    @NotNull
    private Boolean emergencyAvailable;
}