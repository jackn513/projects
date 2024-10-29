package org.example.docmate.collaborators.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.example.docmate.collaborators.model.Collaborators;
import org.example.docmate.collaborators.model.Role;
import org.example.docmate.collaborators.service.CollaboratorsRepository;
import org.example.docmate.collaborators.service.CollaboratorsService;
import org.example.docmate.documents.model.Document;
import org.example.docmate.documents.service.DocumentsService;
import org.example.docmate.exceptions.UnauthorizedException;
import org.example.docmate.users.JWT.JWTTokenProvider;
import org.example.docmate.users.JWT.TokenService;
import org.example.docmate.users.model.User;
import org.example.docmate.users.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.yaml.snakeyaml.comments.CommentLine;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/collaborations")
public class CollaboratorsController {

    private static final Logger logger = LoggerFactory.getLogger(CollaboratorsController.class);
    private final TokenService tokenService;
    private final DocumentsService documentsService;
    private final UserService userService;
    private final JWTTokenProvider jwtTokenProvider;
    private final CollaboratorsService collaboratorsService;
    private final CollaboratorsRepository collaboratorsRepository;

    public CollaboratorsController(CollaboratorsService collaboratorsService, TokenService tokenService,
                                   DocumentsService documentsService, UserService userService,
                                   JWTTokenProvider jwtTokenProvider, CollaboratorsRepository collaboratorsRepository) {
        this.collaboratorsService = collaboratorsService;
        this.tokenService = tokenService;
        this.documentsService = documentsService;
        this.userService = userService;
        this.jwtTokenProvider = jwtTokenProvider;
        this.collaboratorsRepository = collaboratorsRepository;
    }

    private User extractUserFromRequest(HttpServletRequest request) {
        String token = tokenService.extractTokenFromRequest(request);
        if (token == null || !jwtTokenProvider.validateToken(token)) {
            throw new UnauthorizedException("Invalid token.");
        }
        String username = jwtTokenProvider.getUsername(token);
        return userService.findByUsername(username);
    }
    private boolean hasPermissionToAddCollaborators(User currentUser, Document document) {
        // Check if the current user is the owner of the document
        return document.getUser().getUserId() == currentUser.getUserId();
    }

    @PostMapping("/create")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> createCollaborator(@RequestBody Collaborators collaborators, HttpServletRequest request) {
        // Extract user from the token
        User hasToken = extractUserFromRequest(request);

        // Check if the user is authenticated by verifying the extracted token
        if (hasToken == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid or missing authentication token.");
        }

        // Validate input
        if (collaborators == null || collaborators.getUser() == null || collaborators.getDocument() == null) {
            return ResponseEntity.badRequest().body("Collaborator, user, and document must not be null.");
        }

        // Fetch user and document from the database
        String username = collaborators.getUser().getUsername();
        String email = collaborators.getUser().getEmail();
        User user = collaboratorsService.findByUsernameOrEmail(username, email);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found.");
        }

        Document document = documentsService.findById(collaborators.getDocument().getDocumentId());
        if (document == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Document not found.");
        }

        // Check if the collaborator already exists
        if (collaboratorsRepository.existsByUserAndDocument(user, document)) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Collaborator already exists for this document.");
        }

        // Check if the current user has permission to add the collaborator
        if (!hasPermission(hasToken, document)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("You do not have permission to add collaborators to this document.");
        }

        // Validate the role
        Role role = collaborators.getRole();
        if (!isValidRole(role)) {
            return ResponseEntity.badRequest().body("Invalid role specified.");
        }

        // Set user and document in the collaborators entity
        collaborators.setUser(user);
        collaborators.setDocument(document);
        collaborators.setCreatedAt(Timestamp.from(Instant.now()));

        // Save the collaborator
        Collaborators savedCollaborator = collaboratorsRepository.save(collaborators);
        logger.info("Collaborator created: {}", savedCollaborator);
        return ResponseEntity.ok(savedCollaborator);
    }


    // Utility method to validate roles
    private boolean isValidRole(Role role) {
        // Check for null to prevent NullPointerException
        if (role == null) {
            return false;
        }
        return EnumSet.allOf(Role.class).contains(role);
    }



    // Utility method to check if the current user has permission
    private boolean hasPermission(User currentUser, Document document) {
        // Implement your logic here based on the user's role and the document's owner
        return true; // Placeholder; replace with actual permission checking logic
    }


//    private boolean isValidRole(Role role) {
//        return role != null && EnumSet.allOf(Role.class).contains(role);
//    }




    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<Collaborators>> getCollaborators() {
        List<Collaborators> collaborators = collaboratorsService.findAll();
        return ResponseEntity.ok(collaborators);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Collaborators> findByUserId(@PathVariable int id) {
        Collaborators collaborator = collaboratorsService.findById(id);
        return collaborator != null ? ResponseEntity.ok(collaborator) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("/find")
    public ResponseEntity<Collaborators> findCollaboratorByUserIdAndDocumentId(
            @RequestParam int userId,
            @RequestParam int documentId) {

        Optional<Collaborators> collaborator = collaboratorsService.findByUserIdAndDocumentId(userId, documentId);
        return collaborator.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    @GetMapping("/role/{role}")
    public ResponseEntity<List<Collaborators>> findByRole(@PathVariable String role) {
        List<Collaborators> collaboratorsByRole = collaboratorsService.findByRole(role);
        return collaboratorsByRole.isEmpty()
                ? ResponseEntity.status(HttpStatus.NOT_FOUND).body(null)
                : ResponseEntity.ok(collaboratorsByRole);
    }
}
