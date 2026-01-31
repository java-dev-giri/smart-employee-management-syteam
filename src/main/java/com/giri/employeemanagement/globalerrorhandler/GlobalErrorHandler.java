package com.giri.employeemanagement.globalerrorhandler;

import com.giri.employeemanagement.dto.ErrorResponseDto;
import com.giri.employeemanagement.exception.EmployeeNotFound;
import org.hibernate.NonUniqueResultException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalErrorHandler {

    @ExceptionHandler(EmployeeNotFound.class)
    private ResponseEntity<Object> handleEmployeeNotFoundException(EmployeeNotFound ex) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ErrorResponseDto(
                        ex.getMessage(),
                        HttpStatus.NOT_FOUND.value(),
                        ex.getClass().getSimpleName()
                ));
    }

    @ExceptionHandler(NonUniqueResultException.class)
    private ResponseEntity<Object> handleEmployeeNotFoundException(NonUniqueResultException ex) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ErrorResponseDto(
                        ex.getMessage(),
                        HttpStatus.NOT_FOUND.value(),
                        ex.getClass().getSimpleName()
                ));
    }
}
