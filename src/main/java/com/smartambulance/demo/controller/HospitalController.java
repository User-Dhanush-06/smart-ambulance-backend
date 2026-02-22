package com.smartambulance.demo.controller;

import com.smartambulance.demo.dto.AuthResponseDTO;
import com.smartambulance.demo.entity.Hospital;
import com.smartambulance.demo.service.HospitalService;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/hospital")
public class HospitalController {

    private final HospitalService service;

    public HospitalController(HospitalService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public Hospital register(@RequestBody Hospital hospital) {
        return service.registerHospital(hospital);
    }

    @PostMapping("/login")
    public AuthResponseDTO login(@RequestBody Hospital hospital) {
        return service.loginHospital(
                hospital.getEmail(),
                hospital.getPassword()
        );
    }
}
