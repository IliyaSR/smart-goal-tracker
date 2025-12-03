package com.example.SmartGoalTracker.repository;

import com.example.SmartGoalTracker.model.ProgressLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgressRepository extends JpaRepository<ProgressLog, Long> {
}
