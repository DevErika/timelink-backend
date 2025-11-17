package com.timelink.timelink.dto;

import com.timelink.timelink.model.Role;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Builder
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
