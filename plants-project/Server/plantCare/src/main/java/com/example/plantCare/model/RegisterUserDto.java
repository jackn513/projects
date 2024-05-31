package com.example.plantCare.model;

import javax.validation.constraints.NotEmpty;

/**
 * RegisterUserDto is a class used to hold the registration information for a new user
 * that's sent from the client to the server for the register endpoint.
 *
 * The acronym DTO is being used for "data transfer object". It means that this type of
 * class is specifically created to transfer data between the client and the server.
 */
public class RegisterUserDto {

    @NotEmpty(message = "Customer name must not be empty")
    private String customerName;

    private String profileBio;

    private String profile_image;

    @NotEmpty(message = "Email must not be empty")
    private String email;

    @NotEmpty(message = "Password must not be empty")
    private String password;

    public RegisterUserDto(String customerName, String profileBio, String profile_image, String email, String password) {
        this.customerName = customerName;
        this.profileBio = profileBio;
        this.profile_image = profile_image;
        this.email = email;
        this.password = password;
    }

    public RegisterUserDto() {
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getProfileBio() {
        return profileBio;
    }

    public void setProfileBio(String profileBio) {
        this.profileBio = profileBio;
    }

    public String getProfile_image() {
        return profile_image;
    }

    public void setProfile_image(String profile_image) {
        this.profile_image = profile_image;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "RegisterUserDto{" +
                "customerName='" + customerName + '\'' +
                ", profileBio='" + profileBio + '\'' +
                ", profile_image='" + profile_image + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
