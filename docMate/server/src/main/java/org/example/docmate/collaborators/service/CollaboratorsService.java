package org.example.docmate.collaborators.service;

import org.example.docmate.collaborators.model.Collaborators;
import org.example.docmate.collaborators.model.CondensedDTO;
import org.example.docmate.collaborators.model.Role;
import org.example.docmate.documents.model.Document;
import org.example.docmate.documents.service.DocumentsService;
import org.example.docmate.users.model.User;
import org.example.docmate.users.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.EnumSet; // Add this line

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

    public Collaborators create(String title, int userId, String role) {

        Document document = documentsService.findByTitle(title);
        if (document == null) {
            throw new IllegalArgumentException("Document not found.");
        }

        User user = userService.findByUserId(userId);
        if (user == null) {
            throw new IllegalArgumentException("User not found.");
        }

        if (collaboratorsRepository.existsByUserAndDocument(user, document)) {
            throw new IllegalArgumentException("This collaborator already exists for this document.");
        }

        Collaborators collaborator = new Collaborators();
        collaborator.setDocument(document);
        collaborator.setUser(user);
        collaborator.setRole(Role.valueOf(role));
        collaborator.setCreatedAt(Timestamp.from(Instant.now()));

        return collaboratorsRepository.save(collaborator);
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

    public User findByUsernameOrEmail(String username, String email) {
        return collaboratorsRepository.findByUsernameOrEmail(username, email);
    }

    public Document findByTitle(String title) {
        return collaboratorsRepository.findByTitle(title);
    }
    public List<Collaborators> findByRole(String role) {
        return collaboratorsRepository.findByRole(role);
    }


    public Collaborators update(int collaboratorId, int userId, String newRole) {
        Optional<Collaborators> optionalCollaborator = collaboratorsRepository.findById(collaboratorId);

        if (optionalCollaborator.isEmpty()) {
            throw new IllegalArgumentException("Collaborator not found.");
        }

        Collaborators collaborator = optionalCollaborator.get();

        // Check if the user is the owner
        if (collaborator.getUser().getUserId() != userId) {
            throw new SecurityException("User is not authorized to update this collaborator.");
        }

        // Update the role if it is valid
        if (isValidRole(Role.valueOf(newRole))) {
            collaborator.setRole(Role.valueOf(newRole));
        } else {
            throw new IllegalArgumentException("Invalid role specified.");
        }

        return collaboratorsRepository.save(collaborator);
    }

    private boolean isValidRole(Role role) {
        return role != null && EnumSet.allOf(Role.class).contains(role);
    }


    public int delete(int documentId, int userId) {
        if (collaboratorsRepository.existsById(userId)) {
            collaboratorsRepository.deleteById(documentId);
            return 1; // Success
        }
        return 0; // No such collaborator found
    }


    public List<CondensedDTO> findCondensedCollaborators() {
        return collaboratorsRepository.findCollaboratorsCondensed();
    }


}
