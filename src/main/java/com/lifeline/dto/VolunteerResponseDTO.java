package com.lifeline.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VolunteerResponseDTO {

    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String phoneNumber;

    private String city;

    private Double latitude;

    private Double longitude;

    private String skills;

    private Boolean available;
}