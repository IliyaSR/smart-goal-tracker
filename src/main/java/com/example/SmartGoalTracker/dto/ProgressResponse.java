package com.example.SmartGoalTracker.dto;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Builder
@Getter
public class ProgressResponse {
    private Long id;
    private Long subgoalId;
    private LocalDate progressDate;
    private int progressPercent;
}
