package com.giri.employeemanagement.service;

import com.giri.employeemanagement.dto.*;
import com.giri.employeemanagement.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    SuccessResponseDto addEmployee(EmployeeDto employee);

    List<Employee> getAllEmployees();

    Optional<Employee> getEmployeeByEmpId(String empId);

    SuccessResponseDto updateEmployeeBasicDetails(EmpBasicsDetailsDto basicsDetailsDto, String empId);

    SuccessResponseDto updateEmployeeAddress(AddressDto addressDto, String empId);

    SuccessResponseDto deleteEmployee(String empId);
}
