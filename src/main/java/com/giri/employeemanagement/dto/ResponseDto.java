package com.giri.employeemanagement.dto;

import java.time.LocalDateTime;

public record ResponseDto(
        String msg,
        LocalDateTime timestamp,
        int statusCode,
        boolean hasError
) {

    public ResponseDto(String msg, int statusCode, boolean hasError) {
        this(msg, LocalDateTime.now(), statusCode, hasError);
    }
}
