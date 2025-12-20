package com.example.demo.service.impl;

import com.example.demo.model.AppUser;
import com.example.demo.repository.AppUserRepository;
import com.example.demo.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppUserServiceImpl implements AppUserService {
    @Autowired private AppUserRepository repository;
    @Override public AppUser registerUser(AppUser u) { return repository.save(u); }
    @Override public AppUser findByEmail(String email) { return repository.findByEmail(email).orElse(null); }
}