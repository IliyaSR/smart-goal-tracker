package com.example.SmartGoalTracker.controller;

import com.example.SmartGoalTracker.dto.GoalDto;
import com.example.SmartGoalTracker.service.GoalServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/goals")
public class GoalController {

    private final GoalServiceImpl goalService;

    GoalController(GoalServiceImpl goalService){
        this.goalService = goalService;
    }

    @GetMapping
    public List<GoalDto> getAllGoals(){
        return goalService.getAllGoals();
    }
}
