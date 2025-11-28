package com.example.SmartGoalTracker.controller;

import com.example.SmartGoalTracker.dto.GoalResponse;
import com.example.SmartGoalTracker.service.GoalServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/goals")
public class GoalController {

    private final GoalServiceImpl goalService;

    GoalController(GoalServiceImpl goalService) {
        this.goalService = goalService;
    }

    @GetMapping
    public ResponseEntity<List<GoalResponse>> getAllGoals() {
        return ResponseEntity.ok().body(goalService.getAllGoals());
    }
}
