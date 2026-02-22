package com.smartambulance.demo.service;

import com.smartambulance.demo.dto.AuthResponseDTO;
import com.smartambulance.demo.entity.Ambulance;

public interface AmbulanceService {

    Ambulance registerAmbulance(Ambulance ambulance);

    AuthResponseDTO loginAmbulance(String email, String password);

    Ambulance updateLocation(Long ambulanceId,
                             Double latitude,
                             Double longitude);
}
