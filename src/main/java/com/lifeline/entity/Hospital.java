package com.lifeline.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "hospitals")
public class Hospital extends BaseEntity {

    @Column(nullable = false)
    private String hospitalName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String phoneNumber;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private Double latitude;

    @Column(nullable = false)
    private Double longitude;

    @Column(nullable = false)
    private Integer totalBeds;

    @Column(nullable = false)
    private Integer availableBeds;

    @Column(nullable = false)
    private Integer icuBeds;

    @Column(nullable = false)
    private Integer availableIcuBeds;

    @Column(nullable = false)
    private Boolean emergencyAvailable = true;
}