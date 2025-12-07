package com.example.SmartGoalTracker.service;

import com.example.SmartGoalTracker.dto.*;
import org.springframework.stereotype.Service;

@Service
public interface ProgressService {

    public ProgressResponse createProgress(Long subGoalId, ProgressRequest progressRequest) throws Exception;
    public GoalProgressResponse getGoalProgress(Long goalId);
    public GoalRecommendationResponse getRecommendation(Long goalId);
}
