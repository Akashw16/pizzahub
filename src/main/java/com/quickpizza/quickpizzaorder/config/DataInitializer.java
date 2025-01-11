package com.quickpizza.quickpizzaorder.config;

import com.quickpizza.quickpizzaorder.model.User;
import com.quickpizza.quickpizzaorder.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collections;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner initData(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            if (userRepository.findByEmail("admin@quickpizza.com").isEmpty()) {
                User admin = new User();
                admin.setName("Admin");
                admin.setEmail("admin@quickpizza.com");
                admin.setPassword(passwordEncoder.encode("admin123"));
                admin.setRoles(Collections.singletonList("ROLE_ADMIN"));
                userRepository.save(admin);
                System.out.println("Default admin user created: admin@quickpizza.com / admin123");
            }
        };
    }
}
