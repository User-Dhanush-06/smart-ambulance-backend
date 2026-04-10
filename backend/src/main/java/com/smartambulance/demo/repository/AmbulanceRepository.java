package com.smartambulance.demo.repository;

import com.smartambulance.demo.entity.Ambulance;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface AmbulanceRepository
        extends JpaRepository<Ambulance, Long> {

    Optional<Ambulance> findByEmail(String email);

    boolean existsByEmail(String email);
}
