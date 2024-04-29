package com.rko.springsecurity.config.auth;

import com.rko.springsecurity.dto.RegisterRequest;
import com.rko.springsecurity.repository.UserInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    //private final AuthenticationService service;
    private final UserInfoRepository userInfoRepository;

    private final PasswordEncoder passwordEncoder;
    private final AuthenticationService service;


    @PostMapping("/register")
    public String register(@Validated @RequestBody RegisterRequest request) {

        try {
            if (userInfoRepository.findByUsername(request.getUsername()).isPresent()) {

                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Username already registered");
            }
            ResponseEntity.ok(service.register(request));
            return ("User created successfully");

        } catch (ResponseStatusException ex) {
            return ex.getReason();
        }
    }
}
