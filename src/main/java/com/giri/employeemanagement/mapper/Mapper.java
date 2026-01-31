package com.giri.employeemanagement.mapper;

import com.giri.employeemanagement.dto.AddressDto;
import com.giri.employeemanagement.dto.EmpBasicsDetailsDto;
import com.giri.employeemanagement.dto.EmployeeDto;
import com.giri.employeemanagement.entity.Address;
import com.giri.employeemanagement.entity.Employee;

public class Mapper {

    public static Employee toEmployeeEntity(EmployeeDto employeeDto) {
        Employee employee = new Employee();
        return setEmployeeDetails(employee, employeeDto);
    }

    public static Address toAddressEntity(AddressDto addressDto) {
        Address address = new Address();
        address.setArea(addressDto.area());
        address.setCity(addressDto.city());
        address.setType(addressDto.type());
        address.setState(addressDto.state());
        address.setPinCode(addressDto.pinCode());
        return address;
    }

    public static Employee setEmployeeDetails(Employee employee, EmployeeDto employeeDto) {
        employee.setEmpFirstName(employeeDto.empFirstName());
        employee.setEmpLastName(employeeDto.empLastName());
        employee.setEmpId(employeeDto.empId());
        employee.setEmpDept(employeeDto.empDept());
        employee.setEmpAddress(employeeDto.empAddress());
        employee.setEmpDOJ(employeeDto.empDOJ());
        employee.setEmpWorkMailId(employeeDto.empWorkMailId());
        employee.setEmpPersonalMailId(employeeDto.empPersonalMailId());
        return employee;
    }

    public static Employee setEmployeeBasicsDetails(Employee employee, EmpBasicsDetailsDto basicsDetailsDto) {
        employee.setEmpFirstName(basicsDetailsDto.empFirstName());
        employee.setEmpLastName(basicsDetailsDto.empLastName());
        employee.setEmpId(basicsDetailsDto.empId());
        employee.setEmpDept(basicsDetailsDto.empDept());
        employee.setEmpDOJ(basicsDetailsDto.empDOJ());
        employee.setEmpWorkMailId(basicsDetailsDto.empWorkMailId());
        employee.setEmpPersonalMailId(basicsDetailsDto.empPersonalMailId());
        return employee;
    }
}
