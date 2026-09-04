package com.project.Fitness.service;

import com.project.Fitness.dto.RegisterRequest;
import com.project.Fitness.dto.UserResponse;
import com.project.Fitness.model.User;
import com.project.Fitness.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.ZoneOffset;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserResponse regester(RegisterRequest request) {
        User user = User.builder()
                .email(request.getEmail())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .password(request.getPassword())
                .build();
//         User user = new User(
//                 null,
//                 request.getEmail(),
//                 request.getPassword(),
//                 request.getFirstName(),
//                 request.getLastName(),
//                 Instant.now()
//                         .atZone(ZoneOffset.UTC)
//                         .toLocalDateTime(),
//
//                 Instant.now()
//                         .atZone(ZoneOffset.UTC)
//                         .toLocalDateTime(),
//
//                 List.of(),
//                 List.of()
//         );
         User savedUser = userRepository.save(user);
         return mapToResponse(savedUser);

    }
    private UserResponse mapToResponse(User savedUser){
        UserResponse response = new UserResponse();
        response.setId(savedUser.getId());
        response.setEmail(savedUser.getEmail());
        response.setPassword(savedUser.getPassword());
        response.setFirstName(savedUser.getFirstName());
        response.setLastName(savedUser.getLastName());
        response.setCreatedAt(savedUser.getCreatedAt());
        response.setUpdatedAt(savedUser.getUpdatedAt());
        return response;
    }
}
