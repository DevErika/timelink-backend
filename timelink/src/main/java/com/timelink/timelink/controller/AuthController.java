package com.timelink.timelink.controller;

import com.timelink.timelink.dto.LoginRequestDTO;
import com.timelink.timelink.dto.LoginResponseDTO;
import com.timelink.timelink.dto.UserRequestDTO;
import com.timelink.timelink.dto.UserResponseDTO;
import com.timelink.timelink.mapper.UserMapper;
import com.timelink.timelink.model.User;
import com.timelink.timelink.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationConfiguration authenticationConfiguration;
    private final UserService userService;
    private final UserMapper userMapper;

    @PostMapping("/register")
    public ResponseEntity<UserResponseDTO> register(@Valid @RequestBody UserRequestDTO userRequestDTO) {

        User userToCreate = userMapper.toEntity(userRequestDTO);

        User createdUser = userService.createUser(userToCreate);

        UserResponseDTO responseDTO = userMapper.toResponseDTO(createdUser);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(responseDTO);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO body) throws Exception {

        AuthenticationManager authenticationManager =
                authenticationConfiguration.getAuthenticationManager();

        UsernamePasswordAuthenticationToken authToken =
                new UsernamePasswordAuthenticationToken(
                        body.getEmail(),
                        body.getPassword()
                );

        authenticationManager.authenticate(authToken);

        User user = userService.getUserByEmail(body.getEmail());

        LoginResponseDTO response = new LoginResponseDTO(
                "Login successful",
                user.getId(),
                user.getEmail()
        );
        return ResponseEntity.ok(response);
    }
}
