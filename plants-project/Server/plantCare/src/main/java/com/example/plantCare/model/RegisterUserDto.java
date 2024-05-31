package com.example.plantCare.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

/**
 * RegisterUserDto is a class used to hold the registration information for a new user
 * that's sent from the client to the server for the register endpoint.
 *
 * The acronym DTO is being used for "data transfer object". It means that this type of
 * class is specifically created to transfer data between the client and the server.
 */
public class RegisterUserDto {
    //            customer.setCustomerId(rowSet.getInt("customer_id"));
//            customer.setCustomerName(rowSet.getString("customer_name"));
//            customer.setProfileBio(rowSet.getString("profile_bio"));
//            customer.setProfilePic(rowSet.getString("profile_image"));
//            customer.setEmail(rowSet.getString("email"));
//            customer.setPassword(rowSet.getString("password"));
//            if (rowSet.getDate("created_at") != null){
//                customer.setCreated(rowSet.getDate("created_at").toLocalDate());
//            }
//            if (rowSet.getDate("updated_at") != null){
//                customer.setUpdated(rowSet.getDate("updated_at").toLocalDate());
//            }
    @NotEmpty
    private String customerName;
    private String profileBio;
    private String profile_image;
    @NotEmpty
    private String email;
    @NotEmpty
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


}
