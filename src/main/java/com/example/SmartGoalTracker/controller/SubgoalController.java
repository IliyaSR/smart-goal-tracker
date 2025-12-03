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

    @PostMapping("/goals/{id}/subgoals")
    public ResponseEntity<SubgoalResponse> createSubgoal(@RequestBody @Valid SubgoalRequest subgoalRequest, @PathVariable Long id){
        return ResponseEntity.ok().body(subgoalService.createSubgoal(id, subgoalRequest));
    }
}
