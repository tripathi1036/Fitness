package com.project.Fitness.service;

import com.project.Fitness.dto.ActivityRequest;
import com.project.Fitness.dto.ActivityResponse;
import com.project.Fitness.model.Activity;
import com.project.Fitness.model.User;
import com.project.Fitness.repository.ActivityRepository;
import com.project.Fitness.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ActivityService {
    private final ActivityRepository activityRepository;
    private final UserRepository userRepository;
    public ActivityResponse trackActivity(ActivityRequest request){
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("Invalid user" + request.getUserId()));
        Activity activity =Activity.builder()
                .type(request.getType())
                .duration(request.getDuration())
                .caloriesBurned(request.getCaloriesBurned())
                .additionalMetrics(request.getAdditionalMetrics())
                .user(user)
                .build();
        Activity saveActivity = activityRepository.save(activity);
        return  mapToResponse(saveActivity);
    }

    private ActivityResponse mapToResponse(Activity activity) {
        ActivityResponse response = new ActivityResponse();
        response.setId(activity.getId());
        response.setUserId(activity.getUser().getId());
        response.setType(activity.getType());
        response.setDuration(activity.getDuration());
        response.setCaloriesBurned(activity.getCaloriesBurned());
        response.setAdditionalMetrics(activity.getAdditionalMetrics());
        response.setCreatedAt(activity.getCreatedAt());
        response.setUpdatedAt(activity.getUpdatedAt());
        return response;
    }
}
