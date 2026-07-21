package com.lifeline.entity;

import com.lifeline.enums.EmergencyPriority;
import com.lifeline.enums.EmergencyStatus;
import com.lifeline.enums.EmergencyType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "emergency_requests")
public class EmergencyRequest extends BaseEntity {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "patient_id", nullable = false)
    private User patient;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EmergencyType emergencyType;

    @Column(nullable = false, length = 500)
    private String description;

    @Column(nullable = false)
    private Double latitude;

    @Column(nullable = false)
    private Double longitude;

    @Column(nullable = false)
    private String address;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EmergencyStatus status = EmergencyStatus.PENDING;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EmergencyPriority priority = EmergencyPriority.HIGH;
}