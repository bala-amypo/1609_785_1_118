package com.example.demo.controller;
import com.example.demo.model.AppUser;
import com.example.demo.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService; 
    @PostMapping("/register")
    public AppUser register(@RequestBody AppUser user) {
        return authService.registerUser(user);
    }
    @PostMapping("/login")
    public String login(@RequestBody AppUser user) {
        return "Login Successful";
    }
}