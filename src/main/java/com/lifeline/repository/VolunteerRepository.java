package com.lifeline.repository;

import com.lifeline.entity.Volunteer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VolunteerRepository extends JpaRepository<Volunteer, Long> {

    List<Volunteer> findByCityIgnoreCase(String city);

    List<Volunteer> findByAvailableTrue();
}