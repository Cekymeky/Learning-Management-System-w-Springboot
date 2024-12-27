package com.example.demo.controllers;

import com.example.demo.models.User;
import com.example.demo.services.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import com.example.demo.services.UserRegistrationService;

import java.util.List;


@RestController
@RequestMapping("/admin")
public class AdminsController {
    @Autowired
    private UserRegistrationService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtService jwtService;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create-user")
    public ResponseEntity<String> createUser(@RequestBody User user) {
        try {
            if (!List.of("ADMIN", "INSTRUCTOR", "STUDENT").contains(user.getRole().toUpperCase())) {
                return ResponseEntity.status(400).body("incorrect role");
            }
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userService.addPerson(user);
            return ResponseEntity.ok("User registered successfully");
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    //should add manage courses

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable("id") int id) {
        try {
            userService.deleteUser(userService.getUserById(id).getUsername());
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

}