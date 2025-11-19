package com.example.SmartGoalTracker.repository;

import com.example.SmartGoalTracker.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    public User findByUsername(String username);
}
