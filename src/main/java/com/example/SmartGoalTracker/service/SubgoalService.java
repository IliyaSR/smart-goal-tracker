package com.example.SmartGoalTracker.service;


import com.example.SmartGoalTracker.dto.SubgoalRequest;
import com.example.SmartGoalTracker.dto.SubgoalResponse;

public interface SubgoalService {
    public SubgoalResponse createSubgoal(Long goalId, SubgoalRequest subgoalRequest);
    public SubgoalResponse updateSubgoal(Long id);
}
