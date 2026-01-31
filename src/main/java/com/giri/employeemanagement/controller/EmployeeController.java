package com.giri.employeemanagement.controller;

import com.giri.employeemanagement.dto.AddressDto;
import com.giri.employeemanagement.dto.EmpBasicsDetailsDto;
import org.slf4j.Logger;
import com.giri.employeemanagement.dto.EmployeeDto;
import com.giri.employeemanagement.entity.Employee;
import com.giri.employeemanagement.exception.EmployeeNotFound;
import com.giri.employeemanagement.service.EmployeeService;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/v1")
public class EmployeeController {

    private Logger log = LoggerFactory.getLogger(EmployeeController.class);

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public ResponseEntity<Object> getEmployees() {
        log.info("Rest request for get employees");
        return ResponseEntity.ok().body(employeeService.getAllEmployees());
    }

    @PostMapping("/employee")
    public ResponseEntity<Object> addEmployee(@RequestBody EmployeeDto employee) {
        log.info("Rest request for add employee {}", employee);
        return ResponseEntity.created(URI.create("/api/v1/employee/" + employee.empId()))
                .body(employeeService.addEmployee(employee));
    }

    @GetMapping("/employee/{empId}")
    public ResponseEntity<Object> getEmployeeById(@PathVariable String empId) {
        log.info("Rest request for get employee by id {}", empId);
        Employee employee = employeeService.getEmployeeByEmpId(empId)
                .orElseThrow(() -> new EmployeeNotFound(
                        "Employee " + empId + " is not registered with our system"));
        return ResponseEntity.ok().body(employee);
    }

    @PutMapping("/employee/{empId}")
    public ResponseEntity<Object> updateEmployeeBasicDetails(
            @PathVariable String empId,
            @RequestBody EmpBasicsDetailsDto basicsDetailsDto) {
        log.info("Rest request for update employee {}", empId);
        return ResponseEntity.ok().body(employeeService.updateEmployeeBasicDetails(basicsDetailsDto, empId));
    }

    @PatchMapping("/employee/{empId}")
    public ResponseEntity<Object> updateEmployeeAddress(
            @PathVariable String empId,
            @RequestBody AddressDto addressDto) {
        log.info("Rest request for update employee address {}", empId);
        return ResponseEntity.ok().body(employeeService.updateEmployeeAddress(addressDto, empId));
    }

    @DeleteMapping("/employee/{empId}")
    public ResponseEntity<Object> deleteEmployee(@PathVariable String empId) {
        log.info("Rest request for delete employee {}", empId);
        return ResponseEntity.ok().body(employeeService.deleteEmployee(empId));
    }
}
