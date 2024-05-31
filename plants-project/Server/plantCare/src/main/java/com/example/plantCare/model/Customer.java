package com.example.plantCare.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;
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
    @JsonProperty("Profile Pic")
    private String profilePic;
    @JsonProperty("Email")
    private String email;
    @JsonProperty("Password")
    private String password;
    @JsonProperty("Created")
    private LocalDate created;
    @JsonProperty("Updated")
    private LocalDate updated;
    @JsonIgnore
    private boolean activated;
    private Set<Authority> authorities = new HashSet<>();
    public Customer(int customerId, String customerName, String profileBio, String profilePic, String email, String password, LocalDate created, LocalDate updated, String authorities) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.profileBio = profileBio;
        this.profilePic = profilePic;
        this.email = email;
        this.password = password;
        this.created = created;
        this.updated = updated;
        if(authorities != null) this.setAuthorities(authorities);
        this.activated = true;
    }

    public Customer() {
    }

    public Customer(String customerName, String profileBio, String email, String password) {
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getProfileBio() {
        return profileBio;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public LocalDate getCreated() {
        return created;
    }

    public Set<Authority> getAuthorities() {
        return authorities;
    }
    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }

    public String getAuthoritiesString() {
        String authString = "";
        for (Authority auth : authorities) {
            if (authString.length() == 0) {
                authString += auth.getName();
            } else {
                authString += "," + auth.getName();
            }
        }
        return authString;
    }

    public void setAuthorities(Set<Authority> authorities) {
        this.authorities = authorities;
    }

    public void setAuthorities(String authorities) {
        String[] roles = authorities.split(",");
        for(String role : roles) {
            String authority = role.contains("ROLE_") ? role : "ROLE_" + role.toUpperCase();
            this.authorities.add(new Authority(authority));
        }
    }

    public LocalDate getUpdated() {
        return updated;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setProfileBio(String profileBio) {
        this.profileBio = profileBio;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    public void setUpdated(LocalDate updated) {
        this.updated = updated;
    }
    @Override
    public int hashCode() {
        return Objects.hash(customerId, email, password, activated, authorities);
    }

}
