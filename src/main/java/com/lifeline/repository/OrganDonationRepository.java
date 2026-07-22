package com.lifeline.repository;

import com.lifeline.entity.Hospital;
import com.lifeline.entity.OrganDonation;
import com.lifeline.enums.OrganType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrganDonationRepository
        extends JpaRepository<OrganDonation, Long> {

    List<OrganDonation> findByAvailableTrue();

    List<OrganDonation> findByOrganType(OrganType organType);

    List<OrganDonation> findByHospital(Hospital hospital);
}