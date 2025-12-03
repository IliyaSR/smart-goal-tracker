package com.example.SmartGoalTracker.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
@Getter
public class SubgoalResponse {
    private Long id;
    private Long goalId;
    private String title;
    private Boolean isCompleted;
    private LocalDateTime createdAt;
}
