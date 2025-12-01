package com.example.SmartGoalTracker.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubgoalDto {
    private Long id;
    private String title;
    private Boolean isCompleted;
    private LocalDateTime createdAt;
    private Long goalId;
    private List<ProgressLogDto> progressLogsList;
}
