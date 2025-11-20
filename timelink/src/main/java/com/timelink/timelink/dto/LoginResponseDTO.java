package com.timelink.timelink.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class LoginResponseDTO {

    private String message;
    private Long userId;
    private String email;
}
