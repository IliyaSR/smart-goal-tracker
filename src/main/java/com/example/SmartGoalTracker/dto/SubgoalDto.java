package com.example.SmartGoalTracker.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubgoalDto {
    private Long id;
    private String title;
    private Boolean isCompleted;
    private LocalDateTime createdAt;
}
