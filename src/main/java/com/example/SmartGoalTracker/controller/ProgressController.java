package com.example.SmartGoalTracker.controller;

import com.example.SmartGoalTracker.dto.ProgressRequest;
import com.example.SmartGoalTracker.dto.ProgressResponse;
import com.example.SmartGoalTracker.service.ProgressServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ProgressController {

    private final ProgressServiceImpl progressService;

    public ProgressController(ProgressServiceImpl progressService) {
        this.progressService = progressService;
    }

    @PostMapping("/subgoals/{id}/progress")
    public ResponseEntity<ProgressResponse> createProgress(@PathVariable Long id, @RequestBody @Valid ProgressRequest progressRequest){
        return ResponseEntity.ok().body(progressService.createProgress(id, progressRequest));
    }
}
