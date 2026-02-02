package com.smartambulance.demo.service;

import com.smartambulance.demo.entity.EmergencyRequest;
import java.util.List;

public interface EmergencyRequestService {

    public EmergencyRequest createEmergency(Long userId, double lat, double lon);

    List<EmergencyRequest> getPendingEmergencies();

    public EmergencyRequest assignAmbulance(Long emergencyId, Long ambulanceId);
}
