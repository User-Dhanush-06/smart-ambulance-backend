package com.smartambulance.demo.service.impl;

import com.smartambulance.demo.entity.Hospital;
import com.smartambulance.demo.repository.HospitalRepository;
import com.smartambulance.demo.service.HospitalService;

import org.springframework.stereotype.Service;

@Service
public class HospitalServiceImpl implements HospitalService {

    private final HospitalRepository repository;

    public HospitalServiceImpl(HospitalRepository repository) {
        this.repository = repository;
    }

    @Override
    public Hospital registerHospital(Hospital hospital) {
        return repository.save(hospital);
    }

    @Override
    public Hospital loginHospital(String email, String password) {

        Hospital hospital = repository.findByEmail(email);

        if (hospital != null &&
            hospital.getPassword().equals(password)) {
            return hospital;
        }
        return null;
    }
}
