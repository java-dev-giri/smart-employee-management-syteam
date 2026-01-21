package com.giri.employeemanagement.service;

import com.giri.employeemanagement.dto.EmployeeDto;
import com.giri.employeemanagement.dto.ResponseDto;
import com.giri.employeemanagement.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    ResponseDto addEmployee(EmployeeDto employee);

    List<Employee> getAllEmployees();

    Optional<Employee> getEmployeeByEmpId(String empId);

    ResponseDto updateEmployee(EmployeeDto employeeDto);
}
