package org.example.docmate.users.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.sql.Timestamp;
import java.time.Instant;

@Entity(name = "_users")
public class User {

    @Id
    @SequenceGenerator(
            name = "users_sequence",
            sequenceName = "users_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_sequence")
    @Column(name = "user_id", updatable = false, nullable = false)
    @JsonProperty("User Id")
    private int userId;

    @Column(name = "username", nullable = false)
    @JsonProperty("Username")
    private String username;

    @Column(name = "email", nullable = false)
    @JsonProperty("Email")
    private String email;

    @Column(name = "password", nullable = false)
    @JsonProperty("Password")
    private String password;

    @Column(name = "role", nullable = false)
    @JsonProperty("Role")
    private String role;

    @Column(name = "created_at")
    @JsonProperty("Created At")
    private Timestamp createdAt;

    @Column(name = "updated_at")
    @JsonProperty("Updated At")
    private Timestamp updatedAt;
@Transient
    private PasswordEncoder passwordEncoder;




    public User(String username, String email, String encodedPassword) {
        this.username = username;
        this.email = email;
        this.password = encodedPassword;  // Assume this is already hashed
        this.role = "USER";  // Set default role if needed
        this.createdAt = Timestamp.from(Instant.now());
        this.updatedAt = Timestamp.from(Instant.now());
    }

    public User() {

    }

    public User(int userId) {
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;  // Store the raw password, handle encoding elsewhere
    }

    public String hashPassword(String password) {
        return passwordEncoder.encode(password);
    }


    public void setRole(String role) {
        this.role = role;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }
}
