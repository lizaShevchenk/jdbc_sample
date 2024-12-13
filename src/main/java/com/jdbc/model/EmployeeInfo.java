package com.jdbc.model;

public class EmployeeInfo {
    private String lastName;
    private String departmentName = "";
    private String countryName = "";
    private String phoneNumber = "";

    @Override
    public String toString() {
        return "EmployeeInfo{" +
                "lastName='" + lastName + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", countryName='" + countryName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
