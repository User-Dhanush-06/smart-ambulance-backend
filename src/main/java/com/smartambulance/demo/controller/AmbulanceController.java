package com.smartambulance.demo.controller;

import com.smartambulance.demo.dto.AuthResponseDTO;
import com.smartambulance.demo.entity.Ambulance;
import com.smartambulance.demo.service.AmbulanceService;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ambulance")
public class AmbulanceController {

    private final AmbulanceService service;

    public AmbulanceController(AmbulanceService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public Ambulance register(@RequestBody Ambulance ambulance) {
        return service.registerAmbulance(ambulance);
    }

    @PostMapping("/login")
    public AuthResponseDTO login(@RequestBody Ambulance ambulance) {
        return service.loginAmbulance(
                ambulance.getEmail(),
                ambulance.getPassword()
        );
    }

    @PutMapping("/location/{id}")
    public Ambulance updateLocation(
            @PathVariable Long id,
            @RequestParam Double lat,
            @RequestParam Double lon) {

        return service.updateLocation(id, lat, lon);
    }
}
