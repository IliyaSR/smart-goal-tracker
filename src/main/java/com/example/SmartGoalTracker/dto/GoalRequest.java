package com.example.SmartGoalTracker.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoalRequest {

    @NotBlank(message = "Title is required!")
    private String title;
    private String description;

    @Future(message = "Target date must be in the future!")
    private LocalDate targetDate;
}
