package com.example.demo.service.impl;

import com.example.demo.dto.ApiResponse;
import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.model.AppUser;
import com.example.demo.repository.AppUserRepository;
import com.example.demo.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private AppUserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public ApiResponse register(RegisterRequest request) {

        AppUser user = new AppUser();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        userRepository.save(user);

        return new ApiResponse(true, "User registered successfully");
    }

    @Override
    public ApiResponse login(LoginRequest request) {

        AppUser user = userRepository.findByUsername(request.getUsername())
                .orElse(null);

        if (user == null) {
            return new ApiResponse(false, "User not found");
        }

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            return new ApiResponse(false, "Invalid credentials");
        }

        return new ApiResponse(true, "Login successful");
    }
}
