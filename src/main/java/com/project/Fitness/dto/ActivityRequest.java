package com.project.Fitness.dto;

import com.project.Fitness.model.ActivityType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActivityRequest {

    private String userId;
    private ActivityType type;
    private Map<String, Object> additionalMetrics;
    private Integer duration;
    private Integer caloriesBurned;
}
