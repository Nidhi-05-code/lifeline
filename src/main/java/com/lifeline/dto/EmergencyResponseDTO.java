package com.lifeline.dto;

import com.lifeline.enums.EmergencyPriority;
import com.lifeline.enums.EmergencyStatus;
import com.lifeline.enums.EmergencyType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmergencyResponseDTO {

    private Long id;

    private String patientName;

    private EmergencyType emergencyType;

    private String description;

    private Double latitude;

    private Double longitude;

    private String address;

    private EmergencyStatus status;

    private EmergencyPriority priority;

    private Long ambulanceId;

    private String vehicleNumber;

    private String driverName;
}