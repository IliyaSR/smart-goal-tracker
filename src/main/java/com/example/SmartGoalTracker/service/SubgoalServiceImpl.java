package com.example.SmartGoalTracker.service;

import com.example.SmartGoalTracker.dto.SubgoalRequest;
import com.example.SmartGoalTracker.dto.SubgoalResponse;
import com.example.SmartGoalTracker.model.Subgoal;
import com.example.SmartGoalTracker.repository.SubgoalRepository;
import org.springframework.stereotype.Service;

@Service
public class SubgoalServiceImpl implements SubgoalService{

    private final SubgoalRepository subgoalRepository;
    private final GoalServiceImpl goalService;

    public SubgoalServiceImpl(SubgoalRepository subgoalRepository, GoalServiceImpl goalService) {
        this.subgoalRepository = subgoalRepository;
        this.goalService = goalService;
    }


    @Override
    public SubgoalResponse createSubgoal(Long goalId, SubgoalRequest subgoalRequest) {
        Subgoal subgoal =
                Subgoal.builder()
                        .goal(goalService.getGoal(goalId))
                        .title(subgoalRequest.getTitle())
                        .completed(subgoalRequest.isCompleted())
                        .build();

        subgoalRepository.save(subgoal);

        return mapToResponse(subgoal);
    }

    public SubgoalResponse mapToResponse(Subgoal subgoal){
        return SubgoalResponse.builder()
                .id(subgoal.getId())
                .goalId(subgoal.getGoal().getId())
                .title(subgoal.getTitle())
                .isCompleted(subgoal.isCompleted())
                .createdAt(subgoal.getCreatedAt())
                .build();
    }
}
