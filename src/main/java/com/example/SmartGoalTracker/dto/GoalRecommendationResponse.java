package com.example.SmartGoalTracker.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class GoalRecommendationResponse {
    private Long goalId;
    private String goalTitle;
    private int progressPercent;
    private int daysLeft;
    private String message;
}
