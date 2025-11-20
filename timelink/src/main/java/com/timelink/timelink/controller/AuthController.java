package com.timelink.timelink.controller;

import com.timelink.timelink.dto.LoginRequestDTO;
import com.timelink.timelink.dto.LoginResponseDTO;
import com.timelink.timelink.model.User;
import com.timelink.timelink.service.UserService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO loginRequest) {

        UsernamePasswordAuthenticationToken authToken =
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getEmail(),
                        loginRequest.getPassword()
                );

        authenticationManager.authenticate(authToken);

        User user = userService.getUserByEmail(loginRequest.getEmail());

        LoginResponseDTO response = new LoginResponseDTO(
                "Login successful",
                user.getId(),
                user.getEmail()
        );

        return ResponseEntity.ok(response);
    }
}
