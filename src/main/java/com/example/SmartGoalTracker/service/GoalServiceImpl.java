package com.example.SmartGoalTracker.service;

import com.example.SmartGoalTracker.dto.GoalRequest;
import com.example.SmartGoalTracker.dto.GoalResponse;
import com.example.SmartGoalTracker.exception.ResourceNotFoundException;
import com.example.SmartGoalTracker.model.Goal;
import com.example.SmartGoalTracker.repository.GoalRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoalServiceImpl implements GoalService {

    private final GoalRepository goalRepository;

    GoalServiceImpl(GoalRepository goalRepository) {
        this.goalRepository = goalRepository;
    }

    @Override
    public List<GoalResponse> getAllGoals() {

        List<Goal> goals = goalRepository.findAll();

        return goals.stream()
                .map(this::mapToResponse)
                .toList();
    }

    public GoalResponse mapToResponse(Goal goal) {
        return GoalResponse.builder()
                .id(goal.getId())
                .userId(goal.getUser().getId())
                .title(goal.getTitle())
                .description(goal.getDescription())
                .targetDate(goal.getTargetDate())
                .createdAt(goal.getCreatedAt())
                .build();
    }
}

