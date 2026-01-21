package com.giri.employeemanagement.dto;

import com.giri.employeemanagement.entity.Address;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record EmployeeDto (
        String empFirstName,
        String empLastName,
        String empId,
        String empDept,
        LocalDate empDOJ,
        Address empAddress,
        String empPersonalMailId,
        String empMailId,
        LocalDateTime modifiedAt
){ }
