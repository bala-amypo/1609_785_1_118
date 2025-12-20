package com.example.demo.repository;

import com.example.demo.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    // FIX: Add these to resolve AuthServiceImpl errors
    AppUser findByUsername(String username);
    boolean existsByEmail(String email);
}