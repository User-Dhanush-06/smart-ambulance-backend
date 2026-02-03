package com.smartambulance.demo.service;

import com.smartambulance.demo.dto.UserRequestDTO;
import com.smartambulance.demo.dto.UserResponseDTO;
import com.smartambulance.demo.entity.User;

public interface UserService {

    UserResponseDTO register(UserRequestDTO dto);

    UserResponseDTO login(String email, String password);

}
