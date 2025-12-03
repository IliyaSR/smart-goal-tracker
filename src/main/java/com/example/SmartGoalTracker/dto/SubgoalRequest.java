package com.example.SmartGoalTracker.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubgoalRequest {

    @NotBlank(message = "The is required!")
    private String title;
    private boolean completed;
}
