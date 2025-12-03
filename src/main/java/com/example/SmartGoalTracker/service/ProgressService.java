package com.example.SmartGoalTracker.service;

import com.example.SmartGoalTracker.dto.ProgressRequest;
import com.example.SmartGoalTracker.dto.ProgressResponse;
import com.example.SmartGoalTracker.dto.SubgoalRequest;
import org.springframework.stereotype.Service;

@Service
public interface ProgressService {

    public ProgressResponse createProgress(Long subGoalId, ProgressRequest progressRequest);
}
