package com.lifeline.repository;

import com.lifeline.entity.BloodDonor;
import com.lifeline.entity.User;
import com.lifeline.enums.BloodGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BloodDonorRepository extends JpaRepository<BloodDonor, Long> {

    Optional<BloodDonor> findByUser(User user);

    List<BloodDonor> findByBloodGroup(BloodGroup bloodGroup);

    List<BloodDonor> findByAvailableTrue();
}