package com.samasouf.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.samasouf.dto.request.LoginRequest;
import com.samasouf.dto.request.RefreshTokenRequest;
import com.samasouf.dto.response.JwtResponse;
import com.samasouf.service.security.AuthenticationService;

import jakarta.validation.Valid;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        log.info("Authentication attempt for: {}", loginRequest.getUsernameOrEmail());

        JwtResponse jwtResponse = authenticationService.authenticate(loginRequest);

        return ResponseEntity.ok(jwtResponse);
    }

    @PostMapping("/refresh")
    public ResponseEntity<JwtResponse> refreshToken(@Valid @RequestBody RefreshTokenRequest request) {
        log.info("Refresh token request");

        JwtResponse jwtResponse = authenticationService.refreshToken(request);

        return ResponseEntity.ok(jwtResponse);
    }
}
