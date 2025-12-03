package com.example.SmartGoalTracker.repository;

import com.example.SmartGoalTracker.model.Subgoal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubgoalRepository extends JpaRepository<Subgoal, Long> {
}
