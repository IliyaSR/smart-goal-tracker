package com.example.SmartGoalTracker.service;

import com.example.SmartGoalTracker.dto.GoalProgressResponse;
import com.example.SmartGoalTracker.dto.ProgressRequest;
import com.example.SmartGoalTracker.dto.ProgressResponse;
import com.example.SmartGoalTracker.dto.SubgoalRequest;
import com.example.SmartGoalTracker.model.Goal;
import com.example.SmartGoalTracker.model.ProgressLog;
import com.example.SmartGoalTracker.model.Subgoal;
import com.example.SmartGoalTracker.repository.ProgressRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProgressServiceImpl implements ProgressService{

    private final ProgressRepository progressRepository;
    private final SubgoalServiceImpl subgoalService;
    private final GoalServiceImpl goalServiceImpl;

    public ProgressServiceImpl(ProgressRepository progressRepository, SubgoalServiceImpl subgoalService, GoalServiceImpl goalServiceImpl) {
        this.progressRepository = progressRepository;
        this.subgoalService = subgoalService;
        this.goalServiceImpl = goalServiceImpl;
    }

    @Override
    public ProgressResponse createProgress(Long subGoalId, ProgressRequest progressRequest) {

        Subgoal subgoal = subgoalService.getSubgoal(subGoalId);

        ProgressLog progressLog =
                ProgressLog.builder()
                        .subgoal(subgoal)
                        .progressPercent(progressRequest.getProgressPercent())
                        .build();

        progressRepository.save(progressLog);

        return mapToResponse(progressLog);

    }

    private ProgressResponse mapToResponse(ProgressLog progressLog){
        return ProgressResponse.builder()
                .id(progressLog.getId())
                .subgoalId(progressLog.getSubgoal().getId())
                .progressDate(progressLog.getProgressDate())
                .progressPercent(progressLog.getProgressPercent())
                .build();
    }

    public GoalProgressResponse getGoalProgress(Long goalId) {

        Goal goal = goalServiceImpl.getGoal(goalId);

        int currentProgress = 0;
        int totalSubgoal = 0;
        int completedSubgoals = 0;

        for(Subgoal subgoal : goal.getSubgoals()){
            totalSubgoal += 1;
            if(subgoal.isCompleted()){
                completedSubgoals += 1;
            }
            for(ProgressLog progressLog : subgoal.getProgressLogs()){
                currentProgress += progressLog.getProgressPercent();
            }
        }

        return GoalProgressResponse.builder()
                .goalId(goalId)
                .currentProgress(currentProgress / totalSubgoal)
                .totalSubgoals(totalSubgoal)
                .completedSubgoals(completedSubgoals)
                .build();

    }
}
