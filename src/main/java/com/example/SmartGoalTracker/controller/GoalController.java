package com.example.SmartGoalTracker.controller;

import com.example.SmartGoalTracker.dto.GoalRequest;
import com.example.SmartGoalTracker.dto.GoalResponse;
import com.example.SmartGoalTracker.service.GoalServiceImpl;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/goals")
public class GoalController {

    private final GoalServiceImpl goalService;

    GoalController(GoalServiceImpl goalService) {
        this.goalService = goalService;
    }

    @GetMapping
    public ResponseEntity<List<GoalResponse>> getAllGoals() {
        return ResponseEntity.ok().body(goalService.getAllGoals());
    }

    @PostMapping
    public ResponseEntity<GoalResponse> createGoal(@RequestBody @Valid GoalRequest goalRequest) {
        return ResponseEntity.ok().body(goalService.createGoal(goalRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GoalResponse> getGoalById(@PathVariable Long id) {
        return ResponseEntity.ok().body(goalService.getGoalById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<GoalResponse> updateGoal(@PathVariable Long id, @RequestBody @Valid GoalRequest goalRequest) {
        return ResponseEntity.ok().body(goalService.updateGoal(goalRequest, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGoal(@PathVariable Long id){
        goalService.deleteGoal(id);
        return ResponseEntity.noContent().build();
    }
}
