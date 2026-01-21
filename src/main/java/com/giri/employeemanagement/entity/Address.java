package com.giri.employeemanagement.entity;

import jakarta.persistence.*;


@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int pinCode;

    private String state;

    private String city;

    private String area;

    private String type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPinCode() {
        return pinCode;
    }

    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", pinCode=" + pinCode +
                ", state='" + state + '\'' +
                ", city='" + city + '\'' +
                ", area='" + area + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
