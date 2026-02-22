package com.smartambulance.demo.service;

import com.smartambulance.demo.dto.AuthResponseDTO;
import com.smartambulance.demo.entity.Hospital;

public interface HospitalService {

    Hospital registerHospital(Hospital hospital);

    AuthResponseDTO loginHospital(String email, String password);

}
