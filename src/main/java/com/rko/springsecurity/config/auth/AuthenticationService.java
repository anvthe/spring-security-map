package com.rko.springsecurity.config.auth;

import com.rko.springsecurity.dto.AuthenticationResponse;
import com.rko.springsecurity.dto.RegisterRequest;
import com.rko.springsecurity.entity.UserInfo;
import com.rko.springsecurity.entity.UserRole;
import com.rko.springsecurity.repository.UserInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserInfoRepository repository;
    private final PasswordEncoder passwordEncoder;


    public AuthenticationResponse register(RegisterRequest request) {
        var user = UserInfo.builder()
                .username(request.getUsername())
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .enabled(request.getEnabled())
                .role(UserRole.ROLE_USER)
                .build();
        repository.save(user);
        return null;
    }
}
