package com.example.SmartGoalTracker.service;

import com.example.SmartGoalTracker.dto.GoalRequest;
import com.example.SmartGoalTracker.dto.GoalResponse;
import com.example.SmartGoalTracker.exception.ResourceNotFoundException;
import com.example.SmartGoalTracker.model.Goal;
import com.example.SmartGoalTracker.model.User;
import com.example.SmartGoalTracker.repository.GoalRepository;
import com.example.SmartGoalTracker.repository.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoalServiceImpl implements GoalService {

    private final GoalRepository goalRepository;
    private final UserRepository userRepository;

    GoalServiceImpl(GoalRepository goalRepository, UserRepository userRepository) {
        this.goalRepository = goalRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<GoalResponse> getAllGoals() {

        List<Goal> goals = goalRepository.findAll();

        return goals.stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public GoalResponse createGoal(GoalRequest goalRequest) {

        String username = SecurityContextHolder.getContext().getAuthentication().getName();

        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found!"));

        Goal goal = Goal.builder()
                .user(user)
                .title(goalRequest.getTitle())
                .description(goalRequest.getDescription())
                .targetDate(goalRequest.getTargetDate())
                .build();

        goalRepository.save(goal);

        return mapToResponse(goal);
    }

    @Override
    public GoalResponse getGoalById(Long id) {
        Goal goal = getGoal(id);

        return mapToResponse(goal);
    }

    @Override
    public GoalResponse updateGoal(GoalRequest goalRequest, Long id) {
        Goal goal = getGoal(id);

        goal.setTitle(goalRequest.getTitle());
        goal.setDescription(goalRequest.getDescription());
        goal.setTargetDate(goalRequest.getTargetDate());

        goalRepository.save(goal);

        return mapToResponse(goal);
    }

    public Goal getGoal(Long id){
        return goalRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("The goal with this ID does not exist."));
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

