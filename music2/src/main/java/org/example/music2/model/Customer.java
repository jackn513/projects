package org.example.music2.model;

import java.time.LocalDate;

public class Customer {

    private int customerId;
    private String customerName;
    private String streetAddress;
    private String phoneNumber;
    private String email;
    private LocalDate dateOfBirth;

    public Customer(int customerId, String customerName, String streetAddress, String phoneNumber, String email, LocalDate dateOfBirth) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.streetAddress = streetAddress;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
    }

    public Customer() {
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
