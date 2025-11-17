package com.timelink.timelink.exceptions;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;
import java.util.List;

@Getter
@Builder
public class ApiError {

    private LocalDateTime timestamp;
    private int status;
    private String error;
    private String message;
    private String path;
    private List<String> validationErrors;
    
}
