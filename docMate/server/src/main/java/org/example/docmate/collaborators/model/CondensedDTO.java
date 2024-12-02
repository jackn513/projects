package org.example.docmate.collaborators.model;

public class CondensedDTO {

    private int userId;
    private String username;
    private String documentTitle;
    private String role;

    // Constructor that matches the query's selected fields
    public CondensedDTO(int userId, String username, String documentTitle, String role) {
        this.userId = userId;
        this.username = username;
        this.documentTitle = documentTitle;
        this.role = role;
    }

    // Getters and setters
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDocumentTitle() {
        return documentTitle;
    }

    public void setDocumentTitle(String documentTitle) {
        this.documentTitle = documentTitle;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}