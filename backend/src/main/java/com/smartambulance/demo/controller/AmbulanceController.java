package com.smartambulance.demo.controller;

import com.smartambulance.demo.dto.AmbulanceRequestDTO;
import com.smartambulance.demo.dto.AmbulanceResponseDTO;
import com.smartambulance.demo.dto.AuthResponseDTO;
import com.smartambulance.demo.entity.Ambulance;
import com.smartambulance.demo.service.AmbulanceService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ambulance")
public class AmbulanceController {

    private final AmbulanceService service;

    public AmbulanceController(AmbulanceService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public AmbulanceResponseDTO register(@Valid @RequestBody AmbulanceRequestDTO dto) {
        return service.register(dto);
    }

    @PostMapping("/login")
    public AuthResponseDTO login(@RequestBody Ambulance ambulance) {
        return service.loginAmbulance(
                ambulance.getEmail(),
                ambulance.getPassword()
        );
    }

    @PutMapping("/location/{id}")
    public AmbulanceResponseDTO updateLocation(
            @PathVariable Long id,
            @RequestParam Double lat,
            @RequestParam Double lon) {

        return service.updateLocation(id, lat, lon);
    }
}
