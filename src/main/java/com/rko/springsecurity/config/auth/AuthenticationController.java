package com.rko.springsecurity.config.auth;

import com.rko.springsecurity.dto.AuthenticationRequest;
import com.rko.springsecurity.dto.RegisterRequest;
import com.rko.springsecurity.repository.UserInfoRepository;
import com.rko.springsecurity.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final UserInfoRepository userInfoRepository;

    private final PasswordEncoder passwordEncoder;
    private final AuthenticationService service;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;


    @PostMapping("/register")
    public String register(@Validated @RequestBody RegisterRequest request) {

        try {
            if (userInfoRepository.findByUsername(request.getUsername()).isPresent()) {

                throw new ResponseStatusException(BAD_REQUEST, "Username already registered");
            }
            ResponseEntity.ok(service.register(request));
            return ("User created successfully");

        } catch (ResponseStatusException ex) {
            return ex.getReason();
        }

    }

    @PostMapping("/login")
    public String authenticate(@RequestBody AuthenticationRequest request) throws UsernameNotFoundException {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(request.getUsername());
        } else {
            throw new UsernameNotFoundException
                    ("User not found");
        }
    }
}