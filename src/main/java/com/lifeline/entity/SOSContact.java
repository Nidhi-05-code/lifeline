package com.lifeline.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "sos_contacts")
public class SOSContact extends BaseEntity {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private String contactName;

    @Column(nullable = false)
    private String relationship;

    @Column(nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private Boolean primaryContact = false;
}