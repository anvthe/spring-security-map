package com.rko.springsecurity.service;

import com.rko.springsecurity.dto.AuthenticationRequest;
import com.rko.springsecurity.dto.AuthenticationResponse;
import com.rko.springsecurity.dto.RegisterRequest;
import com.rko.springsecurity.entity.User;
import com.rko.springsecurity.entity.Role;
import com.rko.springsecurity.repository.UserRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {
        var user = User.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();
        repository.save(user);
        var jwtToken = jwtService.generateToken(user);

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public String authenticate(AuthenticationRequest request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );
        var user = repository.findByEmail(request.getEmail()).orElseThrow();
        var jwtToken = jwtService.generateToken(user);

        //new added
        //String tokenWithoutPrefix = jwtService.extractTokenString(jwtToken);

//        return AuthenticationResponse.builder()
//                .token(jwtToken)
//                //.token(tokenWithoutPrefix)
//                .build();
        return jwtToken;
    }
}