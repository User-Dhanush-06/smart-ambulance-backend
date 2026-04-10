package com.smartambulance.demo.controller;

import com.smartambulance.demo.dto.EmergencyResponseDTO;
import com.smartambulance.demo.service.EmergencyRequestService;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/emergency")
public class EmergencyRequestController {

    private final EmergencyRequestService service;

    public EmergencyRequestController(EmergencyRequestService service) {
        this.service = service;
    }

    // User creates emergency
    @PostMapping("/create")
    public EmergencyResponseDTO create(
            @RequestParam double lat,
            @RequestParam double lon) {

        return service.createEmergency(lat, lon);
    }


    // Ambulance views pending requests
    @GetMapping("/pending")
    public List<EmergencyResponseDTO> getPending() {
        return service.getPendingEmergencies();
    }

    // Ambulance accepts emergency
    @PutMapping("/assign/{requestId}/{ambulanceId}")
    public EmergencyResponseDTO assignAmbulance(
            @PathVariable Long requestId,
            @PathVariable Long ambulanceId) {
        return service.assignAmbulance(requestId, ambulanceId);
    }

    @PutMapping("/{id}/pickup")
    public EmergencyResponseDTO pickup(@PathVariable Long id) {
        return service.pickup(id);
    }

    @PutMapping("/{id}/drop")
    public EmergencyResponseDTO drop(@PathVariable Long id) {
        return service.drop(id);
    }

    @PutMapping("/{id}/complete")
    public EmergencyResponseDTO complete(@PathVariable Long id) {
        return service.complete(id);
    }
}
