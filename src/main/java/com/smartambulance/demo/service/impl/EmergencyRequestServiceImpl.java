package com.smartambulance.demo.service.impl;

import com.smartambulance.demo.entity.Ambulance;
import com.smartambulance.demo.entity.EmergencyRequest;
import com.smartambulance.demo.entity.User;
import com.smartambulance.demo.repository.AmbulanceRepository;
import com.smartambulance.demo.repository.EmergencyRequestRepository;
import com.smartambulance.demo.repository.UserRepository;
import com.smartambulance.demo.service.EmergencyRequestService;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmergencyRequestServiceImpl
        implements EmergencyRequestService {

    private final EmergencyRequestRepository emergencyRepository;
    private final UserRepository userRepository;
    private final AmbulanceRepository ambulanceRepository;

    public EmergencyRequestServiceImpl(
            EmergencyRequestRepository emergencyRepository,
            UserRepository userRepository,
            AmbulanceRepository ambulanceRepository
    ) {
        this.emergencyRepository = emergencyRepository;
        this.userRepository = userRepository;
        this.ambulanceRepository = ambulanceRepository;
    }

    // CREATE EMERGENCY
    @Override
    public EmergencyRequest createEmergency(Long userId,
                                            double lat,
                                            double lon) {

        User user = userRepository
                .findById(userId)
                .orElseThrow();

        EmergencyRequest request = new EmergencyRequest();
        request.setLatitude(lat);
        request.setLongitude(lon);
        request.setStatus("PENDING");
        request.setCreatedAt(LocalDateTime.now());
        request.setUser(user);

        return emergencyRepository.save(request);
    }

    // GET ALL PENDING
    @Override
    public List<EmergencyRequest> getPendingEmergencies() {
        return emergencyRepository.findByStatus("PENDING");
    }

    // ASSIGN AMBULANCE
    @Override
    public EmergencyRequest assignAmbulance(Long requestId,
                                             Long ambulanceId) {

        EmergencyRequest request =
                emergencyRepository.findById(requestId)
                        .orElseThrow();

        Ambulance ambulance =
                ambulanceRepository.findById(ambulanceId)
                        .orElseThrow();

        request.setAmbulance(ambulance);
        request.setStatus("ACCEPTED");

        return emergencyRepository.save(request);
    }
}
