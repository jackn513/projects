package org.example.music2.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Id;

import java.time.LocalDate;

public class Customer {
    @Id
    @JsonProperty("Customer Id")
    private int customerId;
    @JsonProperty("Customer Name")
    private String customerName;
    @JsonProperty("Address")
    private String streetAddress;
    @JsonProperty("Phone Number")
    private String phoneNumber;
    @JsonProperty("Email")
    private String email;
    @JsonProperty("Date of Birth")
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
