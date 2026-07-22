package com.lifeline.repository;


import com.lifeline.entity.Ambulance;
import com.lifeline.enums.AmbulanceStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AmbulanceRepository extends JpaRepository<Ambulance, Long> {


    List<Ambulance> findByStatus(AmbulanceStatus status);


    boolean existsByVehicleNumber(String vehicleNumber);

}