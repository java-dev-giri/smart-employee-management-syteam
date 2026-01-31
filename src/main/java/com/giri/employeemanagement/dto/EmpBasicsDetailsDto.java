package com.giri.employeemanagement.dto;

import java.time.LocalDate;

public record EmpBasicsDetailsDto(
        String empFirstName,
        String empLastName,
        String empId,
        String empDept,
        LocalDate empDOJ,
        String empPersonalMailId,
        String empWorkMailId
) { }
