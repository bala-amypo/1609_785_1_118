package com.example.demo.service.impl;
import com.example.demo.model.AppUser;
import com.example.demo.repository.AppUserRepository;
import com.example.demo.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    private AppUserRepository userRepo;
    @Override
    public AppUser registerUser(AppUser user) {
        return userRepo.save(user);
    }
    @Override
    public AppUser findByUsername(String username) {
        return userRepo.findByUsername(username);
    }

    @Override
    public boolean existsByEmail(String email) {
        return userRepo.existsByEmail(email);
    }
}
