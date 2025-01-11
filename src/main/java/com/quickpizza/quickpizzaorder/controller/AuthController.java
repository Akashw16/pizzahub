package com.quickpizza.quickpizzaorder.controller;

import com.quickpizza.quickpizzaorder.dto.UserRegistrationDTO;
import com.quickpizza.quickpizzaorder.model.User;
import com.quickpizza.quickpizzaorder.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserRegistrationDTO userRegistrationDTO) {
        User registeredUser = userService.registerUser(userRegistrationDTO);
        return ResponseEntity.ok("User registered successfully with ID: " + registeredUser.getId());
    }
}
