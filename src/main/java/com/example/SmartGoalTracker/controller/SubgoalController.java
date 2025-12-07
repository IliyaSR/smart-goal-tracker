package com.example.SmartGoalTracker.controller;

import com.example.SmartGoalTracker.dto.SubgoalRequest;
import com.example.SmartGoalTracker.dto.SubgoalResponse;
import com.example.SmartGoalTracker.service.SubgoalServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class SubgoalController {

    private final SubgoalServiceImpl subgoalService;

    SubgoalController(SubgoalServiceImpl subgoalService){
        this.subgoalService = subgoalService;
    }

    @PostMapping("/goals/{goalId}/subgoals")
    public ResponseEntity<SubgoalResponse> createSubgoal(@RequestBody @Valid SubgoalRequest subgoalRequest, @PathVariable Long goalId){
        return ResponseEntity.ok().body(subgoalService.createSubgoal(goalId, subgoalRequest));
    }

    @PutMapping("/subgoals/{id}")
    public ResponseEntity<SubgoalResponse> updateSubgoal(@PathVariable Long id){
        return ResponseEntity.ok().body(subgoalService.updateSubgoal(id));
    }
}
