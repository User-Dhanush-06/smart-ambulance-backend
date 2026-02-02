package com.smartambulance.demo.service;

import com.smartambulance.demo.entity.User;

public interface UserService {

    User registerUser(User user);

    User loginUser(String email, String password);
}
