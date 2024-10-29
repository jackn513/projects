package org.example.docmate.documents.service;

import jakarta.servlet.http.HttpServletRequest;
import org.example.docmate.users.JWT.JWTTokenProvider;
import org.example.docmate.users.JWT.TokenService;
import org.example.docmate.users.model.User;
import org.example.docmate.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import org.example.docmate.documents.model.Document;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DocumentsService {

    private final DocumentsRepository documentsRepository;




    public DocumentsService(DocumentsRepository documentsRepository) {
        this.documentsRepository = documentsRepository;

    }


    public Document save(String title, String content, User user) {
        // Check if the document with the same title exists for the same user
        Optional<Document> existingDocument = documentsRepository.findByTitleAndUser(title, user);

        if (existingDocument.isPresent()) {
            throw new IllegalArgumentException("Document with the same title already exists for this user.");
        }


        Document document = new Document();
        document.setTitle(title);
        document.setContent(content);

        if (content.length() > 255) {

        }
        document.setUser(user); // Set the user here
        Timestamp now = Timestamp.from(Instant.now());
        document.setCreatedAt(now);
        document.setUpdatedAt(now);


        return documentsRepository.save(document);
    }


    public List<Document> findAll() {
        return documentsRepository.findAll();
    }

    public List<Document> findByTitle(String title) {
        return documentsRepository.findByTitle(title);
    }

    public Document findById(int id) {
        return documentsRepository.findById(id).orElse(null);
    }


    public List<Document> findByUserId(int userId) {

        return documentsRepository.findByUserId(userId);
    }

    public Document update(Document document, int id) {
        Document theDocument = documentsRepository.findById(id).orElse(null);

        // Throw exception if the document is not found
        if (theDocument == null) {
            throw new IllegalArgumentException("Document not found");
        }

        // Update the fields of the existing document
        if (document.getTitle() != null && !document.getTitle().isEmpty()) {
            theDocument.setTitle(document.getTitle());
        }
        if (document.getContent() != null && !document.getContent().isEmpty()) {
            theDocument.setContent(document.getContent());
        }

        // Update the timestamp
        theDocument.setUpdatedAt(Timestamp.from(Instant.now()));

        // Save and return the updated document
        return documentsRepository.save(theDocument);
    }


    public int deleteById(int id) {
        if (documentsRepository.existsById(id)) {
            documentsRepository.deleteById(id);
            return 1;
        }
        return 0;
    }

}
