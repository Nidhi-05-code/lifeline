package com.lifeline.entity;


import com.lifeline.enums.AmbulanceStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "ambulances")
public class Ambulance extends BaseEntity {


    @Column(nullable = false, unique = true)
    private String vehicleNumber;


    @Column(nullable = false)
    private String driverName;


    @Column(nullable = false)
    private String driverPhone;


    @Column(nullable = false)
    private Double latitude;


    @Column(nullable = false)
    private Double longitude;


    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AmbulanceStatus status = AmbulanceStatus.AVAILABLE;

}