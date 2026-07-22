package com.lifeline.dto;


import com.lifeline.enums.AmbulanceStatus;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class AmbulanceResponseDTO {


    private Long id;

    private String vehicleNumber;

    private String driverName;

    private String driverPhone;

    private Double latitude;

    private Double longitude;

    private AmbulanceStatus status;

}