package org.example.docmate.collaborators.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import org.example.docmate.documents.model.Document;
import org.example.docmate.users.model.User;

import java.sql.Timestamp;

@Entity
@Table(name = "collaborators")
public class Collaborators {

    @Id
    @SequenceGenerator(
            name = "collaborators_sequence",
            sequenceName = "collaborators_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "collaborators_sequence")
    @Column(name = "collaborator_id", updatable = false, nullable = false)
    @JsonProperty("Collaborator Id")
    private Integer collaboratorId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "document_id", foreignKey = @ForeignKey(name = "fk_collaborators_document_id"), updatable = false)
    @JsonProperty("Document")
    private Document document;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "fk_collaborators_user_id"), updatable = false)
    @JsonProperty("User")
    private User user;

    @Enumerated(EnumType.STRING)
    @JsonProperty("Role")
    private Role role;

    @Column(name = "created_at")
    @JsonProperty("Created At")
    private Timestamp createdAt;

    // Default constructor
    public Collaborators() {}

    // Parameterized constructor
    public Collaborators(Integer collaboratorId, Document document, User user, Role role, Timestamp createdAt) {
        this.collaboratorId = collaboratorId;
        this.document = document;
        this.user = user;
        this.role = role;
        this.createdAt = createdAt;
    }

    // Getters and setters
    public Integer getCollaboratorId() {
        return collaboratorId;
    }

    public void setCollaboratorId(Integer collaboratorId) {
        this.collaboratorId = collaboratorId;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }


}
