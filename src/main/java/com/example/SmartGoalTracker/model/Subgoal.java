package com.example.SmartGoalTracker.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "subgoals")
public class SubGoal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String title;

    private Boolean isCompleted = false;

    private LocalDateTime createdAt = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "goal_id", nullable = false,
            foreignKey = @ForeignKey(
                    name = "fk_goal_id",
                    foreignKeyDefinition = "FOREIGN KEY (goal_id) REFERENCES goals(id) ON DELETE CASCADE"
            ))
    private Goal goal;

    @OneToMany(mappedBy = "subGoal", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProgressLogs> progressLogsList = new ArrayList<>();
}
