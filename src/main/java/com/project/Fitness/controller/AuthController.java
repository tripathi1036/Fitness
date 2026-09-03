package com.project.Fitness.controller;

import com.project.Fitness.dto.RegisterRequest;
import com.project.Fitness.dto.UserResponse;
import com.project.Fitness.model.User;
import com.project.Fitness.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;

    @PostMapping("/register")
    public UserResponse register(@RequestBody RegisterRequest registerRequest){
         return userService.regester(registerRequest);

    }
}
