package com.smartambulance.demo.repository;

import com.smartambulance.demo.entity.Ambulance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AmbulanceRepository
        extends JpaRepository<Ambulance, Long> {

    Ambulance findByEmail(String email);
}
