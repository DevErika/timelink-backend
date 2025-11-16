package com.timelink.timelink.dto;

import com.timelink.timelink.model.Role;
import lombok.Data;

@Data
public class UserResponseDTO {

    private Long id;
    private String name;
    private String email;
    private String address;
    private String postalCode;
    private String bio;
    private Integer credits;
    private Role role;
}
