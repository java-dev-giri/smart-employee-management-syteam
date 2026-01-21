package com.giri.employeemanagement.exception;

public class EmployeeNotFound extends RuntimeException {

    public EmployeeNotFound(String msg) {
        super(msg);
    }
}
