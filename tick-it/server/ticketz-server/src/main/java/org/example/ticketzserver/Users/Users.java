package org.example.ticketzserver.Users;

import jakarta.persistence.*;

@Entity(name = "users")
@Table(
        name = "users",
        uniqueConstraints = {
                @UniqueConstraint(name = "user_email_unique", columnNames = "email")
        }
)
public class Users {

    @Id
    @SequenceGenerator(
            name = "users_sequence",
            sequenceName = "users_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "users_sequence"
    )
    @Column(
            name = "user_id",
            updatable = false
    )
    private int userId;
    @Column(
            name = "full_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String fullName;
    @Column(
            name = "username",
            nullable = false,
            columnDefinition = "TEXT",
            updatable = true
    )
    private String username;
    @Column(
            name = "password",
            nullable = false,
            columnDefinition = "TEXT",
            updatable = true
    )
    private String password;
    @Column(
            name = "email",
            nullable = false,
            columnDefinition = "TEXT",
            updatable = true,
            unique = true
    )
    private String email;
    @Column(
            name = "role",
            nullable = false,
            columnDefinition = "TEXT",
            updatable = false
    )
    private String role;


    public Users(int userId, String fullName, String username, String password, String email, String role) {
        this.userId = userId;
        this.fullName = fullName;
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
    }

    public Users() {
    }

    public int getUserId() {
        return userId;
    }

    public String getFullName() {
        return fullName;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
