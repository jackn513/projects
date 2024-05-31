package com.example.plantCare.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * LoginResponseDto is a class used to hold both the authentication token and the user
 * information that's returned from the server to the client from a login endpoint.
 *
 * The acronym DTO is being used for "data transfer object". It means that this type of
 * class is specifically created to transfer data between the client and the server.
 */
public class LoginResponseDto {

    private String token;

    private Customer customer;
    public LoginResponseDto(String token, Customer customer) {
        this.token = token;
        this.customer = customer;
    }

    @JsonProperty("token")
    String getToken() {
        return token;
    }

    void setToken(String token) {
        this.token = token;
    }
    @JsonProperty("user")
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
