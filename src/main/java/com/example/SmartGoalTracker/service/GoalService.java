package com.example.SmartGoalTracker.service;

import com.example.SmartGoalTracker.dto.GoalRequest;
import com.example.SmartGoalTracker.dto.GoalResponse;

import java.util.List;

public interface GoalService {
    public List<GoalResponse> getAllGoals();
    public GoalResponse createGoal(GoalRequest goalRequest);
    public GoalResponse getGoalById(Long id);
    public GoalResponse updateGoal(GoalRequest goalRequest, Long id);
}
