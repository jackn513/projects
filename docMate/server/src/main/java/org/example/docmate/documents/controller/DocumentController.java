package org.example.docmate.documents.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.example.docmate.documents.model.Document;
import org.example.docmate.documents.service.DocumentsService;
import org.example.docmate.exceptions.UnauthorizedException;
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

    private User extractUserFromRequest(HttpServletRequest request) {
        String token = tokenService.extractTokenFromRequest(request);

        if (token == null || !jwtTokenProvider.validateToken(token)) {
            throw new UnauthorizedException("Invalid token.");
        }

        String username = jwtTokenProvider.getUsername(token);
        return userService.findByUsername(username);
    }


    @PreAuthorize("hasRole('USER')")
    @PostMapping("/create")
    public ResponseEntity<?> createDocument(@RequestBody Document document, HttpServletRequest request) {
        try {
            User user;
            try {
                user = extractUserFromRequest(request);
            } catch (UnauthorizedException e) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
            }
            document.setUser(user);
            Timestamp now = Timestamp.from(Instant.now());
            document.setCreatedAt(now);
            document.setUpdatedAt(now);
            Document newDocument = documentsService.save(document.getTitle(), document.getContent(), document.getUser());
            return ResponseEntity.ok(newDocument);
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

    @GetMapping("/{id}")
    public ResponseEntity<?> getDocumentById(@PathVariable("id") int id, HttpServletRequest request) {
        Document document = documentsService.findById(id);
        if (document == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Document not found.");
        }
        return ResponseEntity.ok(document);
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/my-documents")
    public ResponseEntity<?> getMyDocuments(HttpServletRequest request) {
        User user = extractUserFromRequest(request);
        List<Document> userDocuments = documentsService.findByUserId(user.getUserId());

        if (userDocuments.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No documents found.");
        }
        return ResponseEntity.ok(userDocuments);
    }



    @PreAuthorize("hasRole('USER')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateDocument(@PathVariable("id") int id, @RequestBody Document document, HttpServletRequest request) {
        User user;
        try {
            user = extractUserFromRequest(request);
        } catch (UnauthorizedException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }

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

    @PreAuthorize("hasRole('USER')")
    @DeleteMapping("/id/{id}")
    public ResponseEntity<?> deleteDocument(@PathVariable("id") int id, HttpServletRequest request) {
        User user;
        try {
            user = extractUserFromRequest(request);
        } catch (UnauthorizedException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }

        Document document = documentsService.findById(id);
        if (document == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Document not found.");
        }

        if (!Objects.equals(document.getUser().getUserId(), user.getUserId())) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("You are not authorized to delete this document.");
        }

        try {
            documentsService.deleteById(id);
            return ResponseEntity.ok("Document deleted successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while deleting the document.");
        }
    }


}
