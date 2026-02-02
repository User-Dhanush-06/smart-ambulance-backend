package com.smartambulance.demo.service.impl;

import com.smartambulance.demo.entity.Ambulance;
import com.smartambulance.demo.repository.AmbulanceRepository;
import com.smartambulance.demo.service.AmbulanceService;

import org.springframework.stereotype.Service;

@Service
public class AmbulanceServiceImpl implements AmbulanceService {

    private final AmbulanceRepository repository;

    public AmbulanceServiceImpl(AmbulanceRepository repository) {
        this.repository = repository;
    }

    @Override
    public Ambulance registerAmbulance(Ambulance ambulance) {
        ambulance.setStatus("AVAILABLE");
        return repository.save(ambulance);
    }

    @Override
    public Ambulance loginAmbulance(String email, String password) {
        Ambulance amb = repository.findByEmail(email);

        if (amb != null && amb.getPassword().equals(password)) {
            return amb;
        }
        return null;
    }

    @Override
    public Ambulance updateLocation(Long ambulanceId,
                                    Double latitude,
                                    Double longitude) {

        Ambulance amb =
                repository.findById(ambulanceId).orElseThrow();

        amb.setLatitude(latitude);
        amb.setLongitude(longitude);

        return repository.save(amb);
    }
}
