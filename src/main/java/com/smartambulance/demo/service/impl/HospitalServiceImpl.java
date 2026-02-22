package com.smartambulance.demo.service.impl;

import com.smartambulance.demo.config.jwt.JwtUtil;
import com.smartambulance.demo.dto.AuthResponseDTO;
import com.smartambulance.demo.entity.Hospital;
import com.smartambulance.demo.exception.InvalidCredentialsException;
import com.smartambulance.demo.exception.ResourceNotFoundException;
import com.smartambulance.demo.repository.AmbulanceRepository;
import com.smartambulance.demo.repository.HospitalRepository;
import com.smartambulance.demo.service.HospitalService;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class HospitalServiceImpl implements HospitalService {

    private final HospitalRepository repository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public HospitalServiceImpl(HospitalRepository repository,BCryptPasswordEncoder passwordEncoder,
            JwtUtil jwtUtil) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    @Override
    public Hospital registerHospital(Hospital hospital) {
        hospital.setPassword(
        passwordEncoder.encode(hospital.getPassword())
    );
    return repository.save(hospital);

    }

    @Override
    public AuthResponseDTO loginHospital(String email, String password) {

        Hospital hospital = repository.findByEmail(email);

        if (hospital == null) {
            throw new ResourceNotFoundException("Hospital not found");
        }

        if (!passwordEncoder.matches(password, hospital.getPassword())) {
            throw new InvalidCredentialsException("Wrong password");
        }

        String token = jwtUtil.generateToken(
                hospital.getEmail(),
                "HOSPITAL"
        );

        return new AuthResponseDTO(token);
    }
}
