package com.example.demo.model;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String password;

    @ElementCollection
    private Set<String> roles;

    private LocalDateTime createdAt;

    public AppUser() {
        this.createdAt = LocalDateTime.now();
    }

    public AppUser(String email, String password, Set<String> roles) {
        this();
        this.email = email;
        this.password = password;
        this.roles = roles;
    }
}
