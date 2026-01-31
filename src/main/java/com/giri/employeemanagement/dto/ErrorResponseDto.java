package com.giri.employeemanagement.dto;

import java.time.LocalDateTime;

public record ErrorResponseDto(
        String errorMsg,
        LocalDateTime timestamp,
        int statusCode,
        String errorType
) {

    public ErrorResponseDto(String msg, int statusCode, String errorType) {
        this(msg, LocalDateTime.now(), statusCode, errorType);
    }
}
