package com.example.SmartGoalTracker.service;

import com.example.SmartGoalTracker.dto.ProgressRequest;
import com.example.SmartGoalTracker.dto.ProgressResponse;
import com.example.SmartGoalTracker.dto.SubgoalRequest;
import com.example.SmartGoalTracker.model.ProgressLog;
import com.example.SmartGoalTracker.model.Subgoal;
import com.example.SmartGoalTracker.repository.ProgressRepository;
import org.springframework.stereotype.Service;

@Service
public class ProgressServiceImpl implements ProgressService{

    private final ProgressRepository progressRepository;
    private final SubgoalServiceImpl subgoalService;

    public ProgressServiceImpl(ProgressRepository progressRepository, SubgoalServiceImpl subgoalService) {
        this.progressRepository = progressRepository;
        this.subgoalService = subgoalService;
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
}
