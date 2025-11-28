package com.example.SmartGoalTracker.dto;

import com.example.SmartGoalTracker.model.Subgoal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GoalDto {
    private Long id;
    private String title;
    private String description;
    private LocalDateTime targetDate;
    private LocalDateTime createdAt;
    private Long userId;
    private List<SubgoalDto> subgoals;
}
