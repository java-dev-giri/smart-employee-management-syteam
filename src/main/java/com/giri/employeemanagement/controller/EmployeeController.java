package com.giri.employeemanagement.controller;

import com.giri.employeemanagement.dto.EmployeeDto;
import com.giri.employeemanagement.entity.Employee;
import com.giri.employeemanagement.exception.EmployeeNotFound;
import com.giri.employeemanagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/v1")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public ResponseEntity<Object> getEmployees() {
        System.out.println("Rest request for get employees");
        return ResponseEntity.ok().body(employeeService.getAllEmployees());
    }

    @PostMapping("/employee")
    public ResponseEntity<Object> addEmployee(@RequestBody EmployeeDto employee) {
        System.out.println("Rest request for add employee " + employee);
        return ResponseEntity.ok().body(employeeService.addEmployee(employee));
    }

    @GetMapping("/employee/{empId}")
    public ResponseEntity<Object> getEmployeeByName(@PathVariable String empId) {
        System.out.println("Rest request for get employee by empId " + empId);
        Employee employee = employeeService.getEmployeeByEmpId(empId)
                .orElseThrow(() -> new EmployeeNotFound("Employee " + empId + " is not registered with our system"));
        return ResponseEntity.ok().body(employee);
    }

    @PatchMapping("/employee/{empId}")
    public ResponseEntity<Object> updateEmployee(
            @PathVariable String empId,
            @RequestBody EmployeeDto employeeDto) {
        System.out.println("Rest request for update employees" + empId);
        Employee employee = employeeService.getEmployeeByEmpId(empId)
                .orElseThrow(() -> new EmployeeNotFound("Employee " + empId + " is not registered with our system"));
        return ResponseEntity
                .ok()
                .body(em)
    }
}
