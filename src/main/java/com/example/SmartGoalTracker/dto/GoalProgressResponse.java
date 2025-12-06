package com.example.SmartGoalTracker.dto;


import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class GoalProgressResponse {

    private Long goalId;
    private int progressPercent;
    private int totalSubgoals;
    private int completedSubgoals;

}
