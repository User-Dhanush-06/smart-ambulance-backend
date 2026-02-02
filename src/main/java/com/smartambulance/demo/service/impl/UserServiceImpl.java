package com.smartambulance.demo.service.impl;

import com.smartambulance.demo.entity.User;
import com.smartambulance.demo.repository.UserRepository;
import com.smartambulance.demo.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User registerUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User loginUser(String email, String password) {

        User user = userRepository.findByEmail(email);

        if (user != null && user.getPassword().equals(password)) {
            return user;
        }

        return null; // later we replace with proper exception
    }
}
