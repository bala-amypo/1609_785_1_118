package com.example.demo.service.Impl;

import com.example.demo.model.AppUser;
import com.example.demo.repository.AppUserRepository;
import com.example.demo.service.AuthService;
import org.springframework.stereotype.Service;
import java.util.Collections;

@Service
public class AuthServiceImpl implements AuthService {

    private final AppUserRepository repo;

    public AuthServiceImpl(AppUserRepository repo) {
        this.repo = repo;
    }

    public AppUser registerUser(AppUser user) {
        if (repo.existsByEmail(user.getEmail())) {
            throw new RuntimeException("Email already exists");
        }
        user.setRoles(Collections.singletonList("USER"));
        return repo.save(user);
    }

    public AppUser findByUsername(String username) {
        return repo.findByUsername(username).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public boolean existsByEmail(String email) {
        return repo.existsByEmail(email);
    }
}
