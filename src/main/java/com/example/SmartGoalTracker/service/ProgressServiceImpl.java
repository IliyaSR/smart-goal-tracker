package com.example.SmartGoalTracker.service;

import com.example.SmartGoalTracker.dto.*;
import com.example.SmartGoalTracker.model.Goal;
import com.example.SmartGoalTracker.model.ProgressLog;
import com.example.SmartGoalTracker.model.Subgoal;
import com.example.SmartGoalTracker.repository.ProgressRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProgressServiceImpl implements ProgressService {

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

    private ProgressResponse mapToResponse(ProgressLog progressLog) {
        return ProgressResponse.builder()
                .id(progressLog.getId())
                .subgoalId(progressLog.getSubgoal().getId())
                .progressDate(progressLog.getProgressDate())
                .progressPercent(progressLog.getProgressPercent())
                .build();
    }

    public GoalProgressResponse getGoalProgress(Long goalId) {
        int progressPercent = getGoalStats(goalId).getFirst();
        int totalSubgoal = getGoalStats(goalId).get(1);
        int completedSubgoals = getGoalStats(goalId).get(2);


        return GoalProgressResponse.builder()
                .goalId(goalId)
                .progressPercent(progressPercent / totalSubgoal)
                .totalSubgoals(totalSubgoal)
                .completedSubgoals(completedSubgoals)
                .build();

    }

    private List<Integer> getGoalStats(Long goalId) {
        Goal goal = goalServiceImpl.getGoal(goalId);

        int progressPercent = 0;
        int totalSubgoal = 0;
        int completedSubgoals = 0;

        for (Subgoal subgoal : goal.getSubgoals()) {
            totalSubgoal += 1;
            if (subgoal.isCompleted()) {
                completedSubgoals += 1;
            }
            for (ProgressLog progressLog : subgoal.getProgressLogs()) {
                progressPercent += progressLog.getProgressPercent();
            }
        }

        return new ArrayList<>(List.of(progressPercent, totalSubgoal, completedSubgoals));
    }

    @Override
    public GoalRecommendationResponse getRecommendation(Long goalId) {

        Goal goal = goalServiceImpl.getGoal(goalId);

        int daysLeft = goal.getTargetDate().getDayOfYear() - LocalDate.now().getDayOfYear();

        return GoalRecommendationResponse.builder()
                .goalId(goalId)
                .goalTitle(goal.getTitle())
                .progressPercent(getGoalStats(goalId).getFirst())
                .daysLeft(daysLeft)
                .message(String.format("You have only %d days to complete it!", daysLeft))
                .build();

    }
}
