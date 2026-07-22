package com.lifeline.repository;

import com.lifeline.entity.Hospital;
import com.lifeline.entity.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicineRepository extends JpaRepository<Medicine, Long> {

    List<Medicine> findByMedicineNameContainingIgnoreCase(String medicineName);

    List<Medicine> findByHospital(Hospital hospital);

    List<Medicine> findByAvailableTrue();
}