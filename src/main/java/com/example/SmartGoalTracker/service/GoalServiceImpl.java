package com.example.SmartGoalTracker.service;

import com.example.SmartGoalTracker.dto.GoalDto;
import com.example.SmartGoalTracker.dto.SubgoalDto;
import com.example.SmartGoalTracker.exception.ResourceNotFoundException;
import com.example.SmartGoalTracker.model.Goal;
import com.example.SmartGoalTracker.repository.GoalRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class GoalServiceImpl implements GoalService {

    private final GoalRepository goalRepository;

    GoalServiceImpl(GoalRepository goalRepository) {
        this.goalRepository = goalRepository;
    }

    @Override
    public List<GoalDto> getAllGoals() {

        List<GoalDto> goals =  goalRepository.findAll()
                .stream()
                .map(
                        goal ->
                                new GoalDto(
                                        goal.getId(),
                                        goal.getTitle(),
                                        goal.getDescription(),
                                        goal.getTargetDate(),
                                        goal.getCreatedAt(),
                                        goal.getUser().getId(),
                                        goal.getSubgoals()
                                                .stream()
                                                .map(subgoal ->
                                                        new SubgoalDto(
                                                                subgoal.getId(),
                                                                subgoal.getTitle(),
                                                                subgoal.getIsCompleted(),
                                                                subgoal.getCreatedAt()
                                                        )
                                                ).toList()
                                )
                ).toList();

        if(goals.isEmpty()){
            throw new ResourceNotFoundException("No goals found!");
        }else{
            return goals;
        }

    }
}
