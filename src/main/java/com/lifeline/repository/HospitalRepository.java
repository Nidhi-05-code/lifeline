package com.lifeline.repository;

import com.lifeline.entity.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Long> {

    List<Hospital> findByEmergencyAvailableTrue();

    List<Hospital> findByAvailableBedsGreaterThan(Integer beds);

    List<Hospital> findByAvailableIcuBedsGreaterThan(Integer beds);

    boolean existsByEmail(String email);

    boolean existsByPhoneNumber(String phoneNumber);
}