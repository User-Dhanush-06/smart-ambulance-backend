package com.smartambulance.demo.repository;

import com.smartambulance.demo.entity.EmergencyRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EmergencyRequestRepository 
        extends JpaRepository<EmergencyRequest, Long> {

    List<EmergencyRequest> findByStatus(String status);
}
