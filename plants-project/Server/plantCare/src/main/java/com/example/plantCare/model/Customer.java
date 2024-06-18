package com.example.plantCare.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Customer {
    @Id
    @JsonProperty("Customer Id")
    private int customerId;

    @JsonProperty("Customer Name")
    private String customerName;

    @JsonProperty("Profile Bio")
    private String profileBio;

    @JsonProperty("Profile Image")
    private String profileImage;

    @JsonProperty("Email")
    private String email;

    @JsonProperty("Password")
    private String password;

    @JsonProperty("Created At")
    private LocalDateTime createdAt;

    @JsonProperty("Updated At")
    private LocalDateTime updatedAt;

    @JsonProperty("Role")
    private String role;

    @JsonIgnore
    private boolean activated;

    private Set<Authority> authorities = new HashSet<>();

    public Customer(int customerId, String customerName, String profileBio, String profileImage, String email, String password, LocalDateTime createdAt, LocalDateTime updatedAt, String role) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.profileBio = profileBio;
        this.profileImage = profileImage;
        this.email = email;
        this.password = password;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.role = role;
        this.activated = true;
    }

    public Customer(String customerName, String email, String password) {
        this.customerName = customerName;
        this.email = email;
        this.password = password;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        this.activated = true;
    }

    public Customer() {

    }

    public Customer(String customerName, String profileBio, String profileImage, String email, String password, String role) {
    }

    // Getters and Setters
    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
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

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }

    public Set<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<Authority> authorities) {
        this.authorities = authorities;
    }

    public void setAuthorities(String authorities) {
        String[] roles = authorities.split(",");
        for (String role : roles) {
            String authority = role.contains("ROLE_") ? role : "ROLE_" + role.toUpperCase();
            this.authorities.add(new Authority(authority));
        }
    }

    public String getAuthoritiesString() {
        StringBuilder authString = new StringBuilder();
        for (Authority auth : authorities) {
            if (authString.length() == 0) {
                authString.append(auth.getName());
            } else {
                authString.append(",").append(auth.getName());
            }
        }
        return authString.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, email, password, activated, authorities);
    }
}
