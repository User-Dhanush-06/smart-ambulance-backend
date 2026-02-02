package com.smartambulance.demo.controller;

import com.smartambulance.demo.entity.User;
import com.smartambulance.demo.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userService.registerUser(user);
    }

    @PostMapping("/login")
    public User login(@RequestBody User user) {
        return userService.loginUser(
                user.getEmail(),
                user.getPassword()
        );
    }
}
