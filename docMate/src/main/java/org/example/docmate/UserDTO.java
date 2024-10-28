package org.example.docmate;



import com.fasterxml.jackson.annotation.JsonProperty;

public class UserDTO {
    @JsonProperty("User Id")
    private Integer userId;

    @JsonProperty("Username")
    private String username;

    @JsonProperty("Email")
    private String email;

    @JsonProperty("Role")
    private String role;

    @JsonProperty("Created At")
    private String createdAt;

    @JsonProperty("Updated At")
    private String updatedAt;

    public UserDTO() {
    }

    public UserDTO(Integer userId, String username, String email, String role, String createdAt, String updatedAt) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.role = role;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    // Getters and setters
    // You can add constructors or use Lombok to reduce boilerplate
}

