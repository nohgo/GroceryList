package com.github.nohgo.grocerylist.controller;

import com.github.nohgo.grocerylist.models.AuthUser;
import com.github.nohgo.grocerylist.repository.AuthUserRepository;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@AllArgsConstructor
public class UserController {

    private final AuthUserRepository authUserRepository;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody AuthUser user) {
        if (authUserRepository.findByUsername(user.getUsername()) != null){
            return ResponseEntity.badRequest().body("Username is already taken");
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        authUserRepository.save(user);

        return ResponseEntity.ok("User registered successfully");
    }
    @GetMapping("/login")
    public ResponseEntity<String> login(@RequestBody AuthUser user){
        if (authUserRepository.findByUsername(user.getUsername()) == null){
            return ResponseEntity.badRequest().body("Incorrect details provided");
        }
        if (!passwordEncoder.matches(user.getPassword(), authUserRepository.findByUsername(user.getUsername()).getPassword())){
            return ResponseEntity.badRequest().body("Incorrect details provided");
            }

        return ResponseEntity.ok("User logged in successfully");
    }

}
