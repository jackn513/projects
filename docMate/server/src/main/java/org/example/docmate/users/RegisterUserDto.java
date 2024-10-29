package org.example.docmate.users;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RegisterUserDto {

    @JsonProperty("Username")
    String username;
    @JsonProperty("Email")
    String email;
    @JsonProperty("Password")
    String password;

    public RegisterUserDto(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
