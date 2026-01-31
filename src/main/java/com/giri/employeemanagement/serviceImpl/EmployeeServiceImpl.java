package com.giri.employeemanagement.serviceImpl;

import com.giri.employeemanagement.dto.*;
import com.giri.employeemanagement.entity.Employee;
import com.giri.employeemanagement.exception.EmployeeNotFound;
import com.giri.employeemanagement.mapper.Mapper;
import com.giri.employeemanagement.repository.AddressRepository;
import com.giri.employeemanagement.repository.EmployeeRepository;
import com.giri.employeemanagement.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    private final AddressRepository addressRepository;

    private final static String ADD_EMPLOYEE_SUCCESS_MSG = "Employee added successful";

    private final static String UPDATE_EMPLOYEE_BASIC_SUCCESS_MSG = "Employee basic details updated successful";

    private final static String UPDATE_EMPLOYEE_ADDRESS_SUCCESS_MSG = "Employee address updated successful";

    private final static String DELETE_EMPLOYEE_SUCCESS_MSG = "Employee deleted successful";

    public EmployeeServiceImpl(EmployeeRepository employeeRepository,
                               AddressRepository addressRepository) {
        this.employeeRepository = employeeRepository;
        this.addressRepository = addressRepository;
    }

    @Override
    public SuccessResponseDto addEmployee(EmployeeDto employeeDto) {
        employeeRepository.save(Mapper.toEmployeeEntity(employeeDto));
        return new SuccessResponseDto(
                ADD_EMPLOYEE_SUCCESS_MSG,
                HttpStatus.CREATED.value()
        );
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> getEmployeeByEmpId(String empId) {
        return employeeRepository.findEmployeeByEmpId(empId);
    }

    @Override
    public SuccessResponseDto updateEmployeeBasicDetails(EmpBasicsDetailsDto basicsDetailsDto, String empId) {
        Employee employee = employeeRepository.findEmployeeByEmpId(empId)
                .orElseThrow(() -> new EmployeeNotFound(
                        "Employee " + empId + " is not registered with our system"));
        employeeRepository.save(Mapper.setEmployeeBasicsDetails(employee, basicsDetailsDto));
        return new SuccessResponseDto(
                UPDATE_EMPLOYEE_BASIC_SUCCESS_MSG,
                HttpStatus.OK.value()
        );
    }

    @Override
    public SuccessResponseDto updateEmployeeAddress(AddressDto addressDto, String empId) {
        var employee = employeeRepository.findEmployeeByEmpId(empId)
                .orElseThrow(() -> new EmployeeNotFound("Employee " + empId + "not found in our system"));
        employee.setEmpAddress(Mapper.toAddressEntity(addressDto));
        employeeRepository.save(employee);
        return new SuccessResponseDto(
                UPDATE_EMPLOYEE_ADDRESS_SUCCESS_MSG,
                HttpStatus.OK.value()
        );
    }

    @Transactional
    @Override
    public SuccessResponseDto deleteEmployee(String empId) {
        var employee = employeeRepository.findEmployeeByEmpId(empId)
                .orElseThrow(() -> new EmployeeNotFound("Employee " + empId + "not found in our system"));
        var addressId = employee.getEmpAddress().getId();
        if (addressRepository.findById(addressId).isPresent()) {
            addressRepository.deleteById(addressId);
        }
        employeeRepository.deleteByEmpId(empId);
        return new SuccessResponseDto(
                DELETE_EMPLOYEE_SUCCESS_MSG,
                HttpStatus.OK.value());
    }
}
