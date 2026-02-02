package com.smartambulance.demo.service;

import com.smartambulance.demo.entity.Hospital;

public interface HospitalService {

    Hospital registerHospital(Hospital hospital);

    Hospital loginHospital(String email, String password);
}
