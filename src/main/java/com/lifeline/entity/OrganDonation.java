package com.lifeline.entity;

import com.lifeline.enums.OrganType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "organ_donations")
public class OrganDonation extends BaseEntity {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "hospital_id", nullable = false)
    private Hospital hospital;

    @Column(nullable = false)
    private String donorName;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private OrganType organType;

    @Column(nullable = false)
    private String bloodGroup;

    @Column(nullable = false)
    private Boolean available = true;
}