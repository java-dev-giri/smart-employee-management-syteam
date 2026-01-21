package com.giri.employeemanagement.globalerrorhandler;

import com.giri.employeemanagement.dto.ResponseDto;
import com.giri.employeemanagement.exception.EmployeeNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalErrorHandler {

    @ExceptionHandler(EmployeeNotFound.class)
    private ResponseEntity<Object> handleEmployeeNotFoundException(EmployeeNotFound ex) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ResponseDto(
                        ex.getMessage(),
                        HttpStatus.NOT_FOUND.value(),
                        true
                ));
    }
}
