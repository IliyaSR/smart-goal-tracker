package com.example.SmartGoalTracker.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "progress_logs")
public class ProgressLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime progressDate;

    @Column(nullable = false)
    private int progressPercent;

    @ManyToOne
    @JoinColumn(name = "subgoal_id", nullable = false,
            foreignKey = @ForeignKey(
                    name = "fk_subgoal_id",
                    foreignKeyDefinition = "FOREIGN KEY (   subgoal_id) REFERENCES subgoals(id) ON DELETE CASCADE"
            ))
    private Subgoal subgoal;

    /// Внимавай може да не работи!!!
    public void setProgressPercent(int progressPercent) throws Exception {
        if (0 <= progressPercent && progressPercent <= 100) {
            this.progressPercent = progressPercent;
        } else {
            throw new Exception("The progress must be between 0 and 100");
        }
    }
}
