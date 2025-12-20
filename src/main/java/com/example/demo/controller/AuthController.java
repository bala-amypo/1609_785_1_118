package com.example.demo.controller;

import com.example.demo.model.AppUser;
import com.example.demo.service.AppUserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@Tag(name = "AuthController")
public class AuthController {
    @Autowired
    private AppUserService service;

    @PostMapping("/register")
    public AppUser register(@RequestBody AppUser user) {
        return service.registerUser(user);
    }
    
    // Note: Login logic usually involves Spring Security authentication managers
    @PostMapping("/login")
    public String login(@RequestBody AppUser user) {
        return "Login logic involves JWT generation based on Security context";
    }
}