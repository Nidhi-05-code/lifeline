package com.lifeline.repository;

import com.lifeline.entity.BloodBank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BloodBankRepository extends JpaRepository<BloodBank, Long> {

    boolean existsByEmail(String email);

    boolean existsByPhoneNumber(String phoneNumber);
}