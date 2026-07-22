package com.lifeline.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class AmbulanceRequestDTO {


    @NotBlank
    private String vehicleNumber;


    @NotBlank
    private String driverName;


    @NotBlank
    private String driverPhone;


    @NotNull
    private Double latitude;


    @NotNull
    private Double longitude;

}