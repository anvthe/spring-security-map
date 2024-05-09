package com.rko.springsecurity.auth;


import com.rko.springsecurity.dto.AuthenticationRequest;
import com.rko.springsecurity.dto.AuthenticationResponse;
import com.rko.springsecurity.dto.RegisterRequest;
import com.rko.springsecurity.repository.UserRepository;
import com.rko.springsecurity.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping()
@RequiredArgsConstructor
public class AuthenticationController {
    private final UserRepository userRepository;
    private final AuthenticationService service;


    @PostMapping("/register")
    public String register(@Validated @RequestBody RegisterRequest request){

        try {
            if (request.getEmail() == null || request.getEmail().isEmpty()) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email is mandatory");
            }
            if (request.getPassword() == null || request.getPassword().isEmpty()) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Password is mandatory");
            }

            if(userRepository.findByEmail(request.getEmail()).isPresent()){

                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email address already registered");
            }
            ResponseEntity.ok(service.register(request));
            return ("User created successfully");

        } catch (ResponseStatusException ex) {
            return ex.getReason();
        }
    }

/*    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request){

        return ResponseEntity.ok(service.authenticate(request));

    }*/

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
        try {
            AuthenticationResponse response = service.authenticate(request);
            return ResponseEntity.ok(response);
        } catch (UsernameNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new AuthenticationResponse("User not found"));

        }
    }
}