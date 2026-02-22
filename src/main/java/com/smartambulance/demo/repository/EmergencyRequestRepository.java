package com.smartambulance.demo.repository;

import com.smartambulance.demo.entity.EmergencyRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import com.smartambulance.demo.entity.User;
import com.smartambulance.demo.entity.Ambulance;

import java.util.List;

public interface EmergencyRequestRepository 
        extends JpaRepository<EmergencyRequest, Long> {

    List<EmergencyRequest> findByStatus(String status);

    boolean existsByUserAndStatusIn(User user, List<String> statuses);

    boolean existsByAmbulanceAndStatusIn(Ambulance ambulance, List<String> statuses);

    List<EmergencyRequest> findByHospitalId(Long hospitalId);

    List<EmergencyRequest> findByHospitalIdAndStatus(Long hospitalId, String status);
}
