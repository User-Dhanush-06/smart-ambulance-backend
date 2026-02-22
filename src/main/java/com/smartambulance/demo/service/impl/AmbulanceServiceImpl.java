package com.smartambulance.demo.service.impl;

import com.smartambulance.demo.config.jwt.JwtUtil;
import com.smartambulance.demo.dto.AuthResponseDTO;
import com.smartambulance.demo.entity.Ambulance;
import com.smartambulance.demo.exception.InvalidCredentialsException;
import com.smartambulance.demo.exception.ResourceNotFoundException;
import com.smartambulance.demo.repository.AmbulanceRepository;
import com.smartambulance.demo.service.AmbulanceService;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AmbulanceServiceImpl implements AmbulanceService {

    private final AmbulanceRepository repository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public AmbulanceServiceImpl(
            AmbulanceRepository repository,
            BCryptPasswordEncoder passwordEncoder,
            JwtUtil jwtUtil
    ) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }


    @Override
    public Ambulance registerAmbulance(Ambulance ambulance) {
        ambulance.setPassword(
            passwordEncoder.encode(ambulance.getPassword())
        );
        ambulance.setStatus("AVAILABLE");
        return repository.save(ambulance);
    }

    @Override
    public AuthResponseDTO loginAmbulance(String email, String password) {

        Ambulance amb = repository.findByEmail(email);

        if (amb == null) {
            throw new ResourceNotFoundException("Ambulance not found");
        }

        if (!passwordEncoder.matches(password, amb.getPassword())) {
            throw new InvalidCredentialsException("Wrong password");
        }

        String token = jwtUtil.generateToken(
                amb.getEmail(),
                "AMBULANCE"
        );

        return new AuthResponseDTO(token);
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
