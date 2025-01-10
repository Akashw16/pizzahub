package com.quickpizza.quickpizzaorder.repository;

import com.quickpizza.quickpizzaorder.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
