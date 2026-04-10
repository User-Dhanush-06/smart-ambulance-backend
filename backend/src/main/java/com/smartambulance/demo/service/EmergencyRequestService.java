package com.smartambulance.demo.service;


import com.smartambulance.demo.dto.EmergencyResponseDTO;
import java.util.List;

public interface EmergencyRequestService {

    EmergencyResponseDTO createEmergency(double lat, double lon);

    List<EmergencyResponseDTO> getPendingEmergencies();

    EmergencyResponseDTO assignAmbulance(Long emergencyId, Long ambulanceId);

    EmergencyResponseDTO pickup(Long id);

    EmergencyResponseDTO drop(Long id);
    
    EmergencyResponseDTO complete(Long id);
}
