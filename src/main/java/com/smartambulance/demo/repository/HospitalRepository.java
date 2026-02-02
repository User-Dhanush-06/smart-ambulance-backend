package com.smartambulance.demo.repository;

import com.smartambulance.demo.entity.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalRepository
        extends JpaRepository<Hospital, Long> {

    Hospital findByEmail(String email);
}
