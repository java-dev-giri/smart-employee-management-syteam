package com.giri.employeemanagement.serviceImpl;

import com.giri.employeemanagement.dto.EmployeeDto;
import com.giri.employeemanagement.dto.ResponseDto;
import com.giri.employeemanagement.entity.Employee;
import com.giri.employeemanagement.mapper.Mapper;
import com.giri.employeemanagement.repository.EmployeeRepository;
import com.giri.employeemanagement.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    private final static String ADD_EMPLOYEE_SUCCESS_MSG = "Employee added successful";

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public ResponseDto addEmployee(EmployeeDto employeeDto) {
        employeeRepository.save(Mapper.toEntityForCreateEmployee(employeeDto));
        return new ResponseDto(
                ADD_EMPLOYEE_SUCCESS_MSG,
                HttpStatus.CREATED.value(),
                false
        );
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> getEmployeeByEmpId(String empId) {
        return employeeRepository.getEmployeeByEmpId(empId);
    }

    @Override
    public ResponseDto updateEmployee(EmployeeDto employeeDto) {
        employeeRepository.save(Mapper.)
        return
    }

}
