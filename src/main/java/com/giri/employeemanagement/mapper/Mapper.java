package com.giri.employeemanagement.mapper;

import com.giri.employeemanagement.dto.EmployeeDto;
import com.giri.employeemanagement.entity.Employee;

import java.time.LocalDateTime;

public class Mapper {

    public static Employee toEntityForCreateEmployee(EmployeeDto employeeDto) {
        Employee employee = new Employee();
        employee.setEmpFirstName(employeeDto.empFirstName());
        employee.setEmpLastName(employeeDto.empLastName());
        employee.setEmpId(employeeDto.empId());
        employee.setEmpDept(employeeDto.empDept());
        employee.setEmpAddress(employeeDto.empAddress());
        employee.setEmpDOJ(employeeDto.empDOJ());
        employee.setEmpMailId(employeeDto.empMailId());
        employee.setEmpPersonalMailId(employeeDto.empPersonalMailId());
        employee.setCreatedAt(LocalDateTime.now());
        employee.setModifiedAt(LocalDateTime.now());
        return employee;
    }

    public static Employee toEntityForUpdateEmployee(EmployeeDto employeeDto) {
        Employee employee = new Employee();
        employee.setEmpFirstName(employeeDto.empFirstName());
        employee.setEmpLastName(employeeDto.empLastName());
        employee.setEmpId(employeeDto.empId());
        employee.setEmpDept(employeeDto.empDept());
        employee.setEmpAddress(employeeDto.empAddress());
        employee.setEmpDOJ(employeeDto.empDOJ());
        employee.setEmpMailId(employeeDto.empMailId());
        employee.setEmpPersonalMailId(employeeDto.empPersonalMailId());
        employee.setModifiedAt(LocalDateTime.now());
        return employee;
    }
}
