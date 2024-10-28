package org.example.docmate;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import org.example.docmate.documents.model.Document;

import java.time.LocalDateTime;

public class DocumentVersion {

    @Id
    @SequenceGenerator(
            name = "version_sequence",
            sequenceName = "version_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "version_sequence")
    @Column(name = "version_id", updatable = false, nullable = false)
    @JsonProperty("Version Id")
    private Integer versionId;

    @ManyToOne
    @JoinColumn(name = "document_id", nullable = false)
    private Document document;

    @Column(nullable = false)
    private Integer versionNumber;

    @Column(nullable = false)
    private String content;

    private LocalDateTime createdAt;

    public DocumentVersion() {
    }

    public DocumentVersion(Integer versionId, Document document, Integer versionNumber, String content, LocalDateTime createdAt) {
        this.versionId = versionId;
        this.document = document;
        this.versionNumber = versionNumber;
        this.content = content;
        this.createdAt = createdAt;
    }

    public Integer getVersionId() {
        return versionId;
    }

    public void setVersionId(Integer versionId) {
        this.versionId = versionId;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public Integer getVersionNumber() {
        return versionNumber;
    }

    public void setVersionNumber(Integer versionNumber) {
        this.versionNumber = versionNumber;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
