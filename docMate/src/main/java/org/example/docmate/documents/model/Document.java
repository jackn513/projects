package org.example.docmate.documents.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import org.example.docmate.users.model.User;

import java.sql.Timestamp;

@Entity(name = "documents")
public class Document {

    @ManyToOne(optional = false) // Ensures the user is required (not nullable)
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "fk_documents_user_id"), updatable = false)
    @JsonProperty("User")
    private User user;

    @Id
    @SequenceGenerator(
            name = "documents_sequence",
            sequenceName = "documents_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "documents_sequence")
    @Column(name = "document_id", updatable = false, nullable = false)
    @JsonProperty("Document Id")
    private int documentId;


    @Column(name = "title", nullable = false)
    @JsonProperty("Title")
    private String title;


    @Column(name = "content", nullable = false)
    @JsonProperty("Content")
    private String content;

    @Column(name = "created_at")
    @JsonProperty("Created At")
    private Timestamp createdAt;

    @Column(name = "updated_at")
    @JsonProperty("Updated At")
    private Timestamp updatedAt;





    public Document() {
    }

    public Document(int documentId, String title, String content, Timestamp createdAt, Timestamp updatedAt, User user) {
        this.documentId = documentId;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.user = user;
    }

    public int getDocumentId() {
        return documentId;
    }

    public void setDocumentId(int documentId) {
        this.documentId = documentId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


}
