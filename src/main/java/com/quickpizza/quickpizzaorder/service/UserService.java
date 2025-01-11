package com.quickpizza.quickpizzaorder.service;

import com.quickpizza.quickpizzaorder.dto.UserRegistrationDTO;
import com.quickpizza.quickpizzaorder.model.User;
import com.quickpizza.quickpizzaorder.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User registerUser(UserRegistrationDTO userRegistrationDTO) {
        // Check if user already exists
        if (userRepository.findByEmail(userRegistrationDTO.getEmail()).isPresent()) {
            throw new IllegalArgumentException("User with this email already exists.");
        }

        // Create a new user
        User user = new User();
        user.setEmail(userRegistrationDTO.getEmail());
        user.setPassword(passwordEncoder.encode(userRegistrationDTO.getPassword()));
        user.setName(userRegistrationDTO.getName());
        user.setRoles(Collections.singletonList("ROLE_USER")); // Pass List<String> for roles

        // Save user to the database
        return userRepository.save(user);
    }
}
