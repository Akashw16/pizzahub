package com.quickpizza.quickpizzaorder.service;

import com.quickpizza.quickpizzaorder.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    // For demonstration purposes, using a static user. Replace with actual DB logic.
    public User findUserByUsername(String username) {
        if ("user".equals(username)) {
            User user = new User();
            user.setUsername("user");
            user.setPassword("password");  // Ensure this password is encoded when saving to DB
            user.setRoles("USER");
            return user;
        }
        return null;
    }
}
