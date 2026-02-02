package com.smartambulance.demo.controller;

import com.smartambulance.demo.entity.EmergencyRequest;
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
    public EmergencyRequest create(
            @RequestParam Long userId,
            @RequestParam double lat,
            @RequestParam double lon) {

        return service.createEmergency(userId, lat, lon);
    }


    // Ambulance views pending requests
    @GetMapping("/pending")
    public List<EmergencyRequest> getPending() {
        return service.getPendingEmergencies();
    }

    // Ambulance accepts emergency
    @PutMapping("/assign/{requestId}/{ambulanceId}")
    public EmergencyRequest assignAmbulance(
            @PathVariable Long requestId,
            @PathVariable Long ambulanceId) {
        return service.assignAmbulance(requestId, ambulanceId);
    }
}
