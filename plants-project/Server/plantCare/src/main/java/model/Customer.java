package model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;

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

    public Customer(int customerId, String customerName, String profileBio, String profilePic, String email, String password, LocalDate created, LocalDate updated) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.profileBio = profileBio;
        this.profilePic = profilePic;
        this.email = email;
        this.password = password;
        this.created = created;
        this.updated = updated;
    }

    public Customer() {
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
}
