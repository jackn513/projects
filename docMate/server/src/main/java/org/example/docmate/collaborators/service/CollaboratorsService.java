package org.example.docmate.collaborators.service;

import org.example.docmate.collaborators.model.Collaborators;
import org.example.docmate.collaborators.model.Role;
import org.example.docmate.documents.model.Document;
import org.example.docmate.documents.service.DocumentsService;
import org.example.docmate.users.model.User;
import org.example.docmate.users.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class CollaboratorsService {

    private final CollaboratorsRepository collaboratorsRepository;

    private final UserService userService;
    private final DocumentsService documentsService;

    public CollaboratorsService(CollaboratorsRepository collaboratorsRepository, UserService userService, DocumentsService documentsService) {
        this.collaboratorsRepository = collaboratorsRepository;

        this.userService = userService;
        this.documentsService = documentsService;
    }

    public Collaborators create(int documentId, int userId, String role) {
        // Check if the document exists
        Document document = documentsService.findById(documentId);
        if (document == null) {
            throw new IllegalArgumentException("Document not found.");
        }

        // Check if the collaborator already exists
        Optional<Collaborators> existingCollaboration = collaboratorsRepository.findByUserIdAndDocumentId(userId, documentId);
        if (existingCollaboration.isPresent()) {
            throw new IllegalArgumentException("This collaborator already exists for this document.");
        }




        // Create the collaborator
        Collaborators collaborator = new Collaborators();
        collaborator.setDocument(document);



        User user = userService.findByUserId(userId);
        collaborator.setUser(user);
        collaborator.setRole(Role.valueOf(role));
        collaborator.setCreatedAt(Timestamp.from(Instant.now()));

        return collaboratorsRepository.save(collaborator);
    }


    // Example validation method
    private boolean isValidRole(String role) {
        return List.of("Viewer", "Commenter", "Editor", "Owner").contains(role);
    }


    public List<Collaborators> findAll() {
        return collaboratorsRepository.findAll();
    }

    public Collaborators findById(int id) {
        return collaboratorsRepository.findById(id).orElse(null);
    }

    public Optional<Collaborators> findByUserIdAndDocumentId(int userId, int documentId) {
        return collaboratorsRepository.findByUserIdAndDocumentId(userId, documentId);
    }

    public List<Collaborators> findByRole(String role) {
        return collaboratorsRepository.findByRole(role);
    }

    public Collaborators update(Collaborators collaborators, int documentId, int userId) {

        Optional<Collaborators> existingCollaboration = collaboratorsRepository.findByUserIdAndDocumentId(userId, documentId);

        if (existingCollaboration.isEmpty()) {
            throw new IllegalArgumentException("No existing collaboration found for this user and document.");
        }

        Collaborators collaboratorToUpdate = existingCollaboration.get();

        if (collaborators.getRole() != null) {
            collaboratorToUpdate.setRole(collaborators.getRole());
        }

        collaboratorToUpdate.setCreatedAt(collaborators.getCreatedAt());

        return collaboratorsRepository.save(collaboratorToUpdate);
    }

    public int delete(int documentId, int userId) {
        if (collaboratorsRepository.existsById(userId)) {
            collaboratorsRepository.deleteById(documentId);
        }
        return 1;
    }


}
