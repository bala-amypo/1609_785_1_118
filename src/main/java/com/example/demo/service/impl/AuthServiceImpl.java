package com.example.demo.service.impl;

import com.example.demo.model.AppUser;
import com.example.demo.repository.AppUserRepository;
import com.example.demo.security.JwtTokenProvider;
import com.example.demo.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private AppUserRepository userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Override
    public String register(AppUser user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        AppUser savedUser = userRepo.save(user);
        return jwtTokenProvider.generateToken(savedUser.getUsername());
    }

    @Override
    public String login(String username, String password) {
        AppUser user = userRepo.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        return jwtTokenProvider.generateToken(user.getUsername());
    }
}
