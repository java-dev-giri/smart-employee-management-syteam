package com.giri.employeemanagement.entity;


import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 15)
    private String empFirstName;

    @Column(length = 15)
    private String empLastName;

    @Column(unique = true)
    private String empId;

    private String empDept;

    private LocalDate empDOJ;

    private String empPersonalMailId;

    private String empWorkMailId;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime modifiedAt;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "emplAddress_id", referencedColumnName = "id")
    private Address empAddress;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmpLastName() {
        return empLastName;
    }

    public void setEmpLastName(String empLastName) {
        this.empLastName = empLastName;
    }

    public String getEmpFirstName() {
        return empFirstName;
    }

    public void setEmpFirstName(String empFirstName) {
        this.empFirstName = empFirstName;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getEmpDept() {
        return empDept;
    }

    public void setEmpDept(String empDept) {
        this.empDept = empDept;
    }

    public LocalDate getEmpDOJ() {
        return empDOJ;
    }

    public void setEmpDOJ(LocalDate empDOJ) {
        this.empDOJ = empDOJ;
    }

    public String getEmpPersonalMailId() {
        return empPersonalMailId;
    }

    public void setEmpPersonalMailId(String empPersonalMailId) {
        this.empPersonalMailId = empPersonalMailId;
    }

    public String getEmpWorkMailId() {
        return empWorkMailId;
    }

    public void setEmpWorkMailId(String empMailId) {
        this.empWorkMailId = empMailId;
    }

    public Address getEmpAddress() {
        return empAddress;
    }

    public void setEmpAddress(Address empAddress) {
        this.empAddress = empAddress;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(LocalDateTime modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    @Override
    public String toString() {
        return """
                    Employee {
                        "id" : %d
                        "empFirstName" : %s
                        "empLastName" : %s
                        "empId" : %s
                        "empDept" : %s
                        "empDOJ" : %s
                        "empPersonalMailId" : %s
                        "empMailId" : %s
                        "createdAt" : %s
                        "modifiedAt" : %s
                        "empAddress" : %s
                    }
                """.formatted(id, empFirstName, empLastName, empId,
                empDept, empDOJ, empPersonalMailId, empWorkMailId, createdAt,
                modifiedAt, empAddress);
    }
}
