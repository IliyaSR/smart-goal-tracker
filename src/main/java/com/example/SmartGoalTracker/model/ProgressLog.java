package com.example.SmartGoalTracker.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "progress_logs")
public class ProgressLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "subgoal_id")
    private Subgoal subgoal;

    @Column(name = "progress_date", nullable = false)
    private LocalDate progressDate;

    @Column(name = "progress_percent", nullable = false)
    private int progressPercent;

    /// Внимавай може да не работи!!!
    public void setProgressPercent(int progressPercent) throws Exception {
        if (0 <= progressPercent && progressPercent <= 100) {
            this.progressPercent = progressPercent;
        } else {
            throw new Exception("The progress must be between 0 and 100");
        }
    }
}
