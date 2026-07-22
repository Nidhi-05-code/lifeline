package com.lifeline.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HospitalResponseDTO {

    private Long id;

    private String hospitalName;

    private String email;

    private String phoneNumber;

    private String address;

    private Double latitude;

    private Double longitude;

    private Integer totalBeds;

    private Integer availableBeds;

    private Integer icuBeds;

    private Integer availableIcuBeds;

    private Boolean emergencyAvailable;
}