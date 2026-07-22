package com.lifeline.repository;

import com.lifeline.entity.SOSContact;
import com.lifeline.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SOSContactRepository extends JpaRepository<SOSContact, Long> {

    List<SOSContact> findByUser(User user);
}