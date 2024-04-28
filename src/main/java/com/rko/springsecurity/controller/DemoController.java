package com.rko.springsecurity.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class DemoController {
    @GetMapping("")
    @PreAuthorize("hasAuthority")
    public ResponseEntity<String> sayHello(){
        return ResponseEntity.ok("<h1>Hello<h1>");
    }

}
