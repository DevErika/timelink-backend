package com.timelink.timelink.mapper;

import com.timelink.timelink.dto.UserRequestDTO;
import com.timelink.timelink.dto.UserResponseDTO;
import com.timelink.timelink.model.Role;
import com.timelink.timelink.model.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserMapper {

    public User toEntity(UserRequestDTO dto) {
        if (dto == null) {
            return null;
        }

        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setAddress(dto.getAddress());
        user.setPostalCode(dto.getPostalCode());
        user.setBio(dto.getBio());

        // El mapper DEBE decidir el role inicial
        user.setRole(Role.USER);

        return user;
    }

    public UserResponseDTO toResponseDTO(User user) {
        if (user == null) {
            return null;
        }

        return UserResponseDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .address(user.getAddress())
                .postalCode(user.getPostalCode())
                .bio(user.getBio())
                .credits(user.getCredits())
                .role(user.getRole())
                .build();
    }

    public List<UserResponseDTO> toResponseDTOList(List<User> users) {
        return users.stream()
                .map(this::toResponseDTO)
                .toList();
    }
}
