package com.lifeline.dto;

import com.lifeline.enums.BloodGroup;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class BloodDonorResponseDTO {

    private Long id;

    private String donorName;

    private String phoneNumber;

    private BloodGroup bloodGroup;

    private String city;

    private Double latitude;

    private Double longitude;

    private Boolean available;

    private LocalDate lastDonationDate;
}