package com.lifeline.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "blood_banks")
public class BloodBank extends BaseEntity {

    @Column(nullable = false)
    private String bloodBankName;

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
    private Integer aPositive;

    @Column(nullable = false)
    private Integer aNegative;

    @Column(nullable = false)
    private Integer bPositive;

    @Column(nullable = false)
    private Integer bNegative;

    @Column(nullable = false)
    private Integer abPositive;

    @Column(nullable = false)
    private Integer abNegative;

    @Column(nullable = false)
    private Integer oPositive;

    @Column(nullable = false)
    private Integer oNegative;
}