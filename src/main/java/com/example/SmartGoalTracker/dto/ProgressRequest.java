package com.example.SmartGoalTracker.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Getter;

@Getter
public class ProgressRequest {

    @Min(value = 0, message = "The progress percent must be at least 0")
    @Max(value = 100, message = "The progress percent must be at most 100")
    int progressPercent;
}
