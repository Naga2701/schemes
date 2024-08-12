package com.project.practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.project.practice.model.Signup;
import com.project.practice.service.SignupService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "http://localhost:3000")
public class AdminController {

    @Autowired
    private SignupService signupService;

    @GetMapping("/users")
    public ResponseEntity<List<Signup>> getAllUsers() {
        List<Signup> users = signupService.getAllSignups();
        return ResponseEntity.ok(users);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        Optional<Signup> userOptional = signupService.getSignupById(id);
        if (userOptional.isPresent()) {
            signupService.deleteSignup(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
