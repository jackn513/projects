package org.example.docmate;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import org.example.docmate.users.model.User;

import java.time.LocalDateTime;

@Entity
@Table(name = "user_session")
public class UserSession {

    @Id
    @SequenceGenerator(
            name = "user_session_sequence",
            sequenceName = "user_session_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_session_sequence")
    @Column(name = "session_id", updatable = false, nullable = false)
    @JsonProperty("Session Id")
    private Integer sessionId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private String sessionToken;

    private LocalDateTime createdAt;
    private LocalDateTime expiresAt;

    public UserSession() {
    }

    public UserSession(Integer sessionId, User user, String sessionToken, LocalDateTime createdAt, LocalDateTime expiresAt) {
        this.sessionId = sessionId;
        this.user = user;
        this.sessionToken = sessionToken;
        this.createdAt = createdAt;
        this.expiresAt = expiresAt;
    }

    public Integer getSessionId() {
        return sessionId;
    }

    public void setSessionId(Integer sessionId) {
        this.sessionId = sessionId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getSessionToken() {
        return sessionToken;
    }

    public void setSessionToken(String sessionToken) {
        this.sessionToken = sessionToken;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(LocalDateTime expiresAt) {
        this.expiresAt = expiresAt;
    }
}
