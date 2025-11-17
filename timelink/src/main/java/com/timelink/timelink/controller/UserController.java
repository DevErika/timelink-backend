package com.timelink.timelink.controller;

import com.timelink.timelink.dto.UserRequestDTO;
import com.timelink.timelink.dto.UserResponseDTO;
import com.timelink.timelink.mapper.UserMapper;
import com.timelink.timelink.model.User;
import com.timelink.timelink.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    @PostMapping
    public ResponseEntity<UserResponseDTO> registerUser(
            @Valid @RequestBody UserRequestDTO userRequestDTO
    ) {
        User userToCreate = userMapper.toEntity(userRequestDTO);
        User createdUser = userService.createUser(userToCreate);
        UserResponseDTO responseDTO = userMapper.toResponseDTO(createdUser);

        URI location = URI.create("/api/users/" + createdUser.getId());

        return ResponseEntity
                .created(location)
                .body(responseDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getUserById(
            @PathVariable Long id
    ) {
        User user = userService.getUserById(id);
        UserResponseDTO responseDTO = userMapper.toResponseDTO(user);
        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        List<UserResponseDTO> responseList = userMapper.toResponseDTOList(users);
        return ResponseEntity.ok(responseList);
    }
}
