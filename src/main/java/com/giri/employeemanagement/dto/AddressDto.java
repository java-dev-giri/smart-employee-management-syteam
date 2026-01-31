package com.giri.employeemanagement.dto;

public record AddressDto(
        int pinCode,
        String state,
        String city,
        String area,
        String type) {
}
