package org.example.docmate.users;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserLoginDto {
    @JsonProperty("username")
    private String username;

    @JsonProperty("password")
    private String password;

    public UserLoginDto() {}

    public UserLoginDto(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
