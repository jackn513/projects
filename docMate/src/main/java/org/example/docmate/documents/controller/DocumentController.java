package org.example.docmate.documents.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.example.docmate.documents.model.Document;
import org.example.docmate.documents.service.DocumentsService;
import org.example.docmate.users.JWT.JWTTokenProvider;
import org.example.docmate.users.JWT.TokenService;
import org.example.docmate.users.model.User;
import org.example.docmate.users.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.Objects;

@CrossOrigin
@RestController
@RequestMapping("/documents")
public class DocumentController {

    private final DocumentsService documentsService;
    private final TokenService tokenService;
    private final JWTTokenProvider jwtTokenProvider;
    private final UserService userService;

    private static final Logger logger = LoggerFactory.getLogger(DocumentController.class);

    @Autowired
    public DocumentController(DocumentsService documentsService, TokenService tokenService, JWTTokenProvider jwtTokenProvider, UserService userService) {
        this.documentsService = documentsService;
        this.tokenService = tokenService;
        this.jwtTokenProvider = jwtTokenProvider;
        this.userService = userService;
    }

    @PreAuthorize("hasRole('USER')")
    @PostMapping("/create")
    public ResponseEntity<String> createDocument(@RequestBody Document document, HttpServletRequest request) {
        try {
            String token = tokenService.extractTokenFromRequest(request);

            if (token == null || !jwtTokenProvider.validateToken(token)) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid token.");
            }

            String username = jwtTokenProvider.getUsername(token);
            User user = userService.findByUsername(username);
            document.setUser(user);
            Timestamp now = Timestamp.from(Instant.now());
            document.setCreatedAt(now);
            document.setUpdatedAt(now);
            Document newDocument = documentsService.save(document.getTitle(), document.getContent(), document.getUser());
            return ResponseEntity.ok("Document created successfully with ID: " + newDocument.getDocumentId());
        } catch (IllegalArgumentException e) {
            logger.warn("Document creation failed: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Document already exists.");
        } catch (Exception e) {
            logger.error("An unexpected error occurred: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while creating the document.");
        }
    }


    @GetMapping
    public ResponseEntity<List<Document>> getAllDocuments(HttpServletRequest request) {
        return ResponseEntity.ok(documentsService.findAll());
    }

    @PreAuthorize("hasRole('USER')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateDocument(@PathVariable("id") int id, @RequestBody Document document, HttpServletRequest request) {
        String token = tokenService.extractTokenFromRequest(request);

        if (token == null || !jwtTokenProvider.validateToken(token)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid token.");
        }

        String username = jwtTokenProvider.getUsername(token);
        User user = userService.findByUsername(username);

        Document existingDocument = documentsService.findById(id);
        if (existingDocument == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Document not found.");
        }

        if (!Objects.equals(existingDocument.getUser().getUserId(), user.getUserId())) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("You are not authorized to update this document.");
        }

        try{
            Document updatedDoc = documentsService.update(document, id);
            return ResponseEntity.ok(updatedDoc);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

    }
}
