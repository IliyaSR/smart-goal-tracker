package com.example.SmartGoalTracker.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

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

    @CreationTimestamp
    @Column(name = "progress_date", nullable = false, updatable = false)
    private LocalDate progressDate;

    @Column(name = "progress_percent", nullable = false)
    private int progressPercent;
}
