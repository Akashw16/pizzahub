package com.quickpizza.quickpizzaorder.controller;

import com.quickpizza.quickpizzaorder.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@Valid @RequestBody User user) {
        // Registration logic
        return new ResponseEntity<>("User registered successfully", HttpStatus.CREATED);
    }
}
