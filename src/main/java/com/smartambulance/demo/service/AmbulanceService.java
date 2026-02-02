package com.smartambulance.demo.service;

import com.smartambulance.demo.entity.Ambulance;

public interface AmbulanceService {

    Ambulance registerAmbulance(Ambulance ambulance);

    Ambulance loginAmbulance(String email, String password);

    Ambulance updateLocation(Long ambulanceId,
                             Double latitude,
                             Double longitude);
}
