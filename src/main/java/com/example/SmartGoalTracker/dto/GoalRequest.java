package com.example.SmartGoalTracker.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoalRequest {

    private String title;
    private String description;
    private LocalDate targetDate;
}
