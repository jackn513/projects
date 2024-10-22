package org.example.docmate.documentsTests;

import jakarta.transaction.Transactional;
import org.example.docmate.documents.model.Document;
import org.example.docmate.documents.service.DocumentsRepository;
import org.example.docmate.documents.service.DocumentsService;
import org.example.docmate.users.UserRepository;
import org.example.docmate.users.model.User;
import org.example.docmate.users.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Transactional
public class DocMateDocumentsServiceTests {

    @Autowired
    private DocumentsRepository documentsRepository;
    @Autowired
    private DocumentsService documentsService;

    private User testUser;

    private User testUser2;
    private Document testDocument;
    private Document testDocument2;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserService userService;


//    @BeforeEach
//    void setUp() {
//
//        userRepository.deleteAll();
//
//
//        testUser = new User();
//        testUser.setUsername("test" + System.currentTimeMillis());
//        testUser.setEmail("test@example.com");
//        testUser.setPassword(passwordEncoder.encode("test"));
//        testUser.setRole("USER");
//        userRepository.save(testUser);
//    }

    @BeforeEach
    void setUp() {
        // Clean up the database
        documentsRepository.deleteAll();
        userRepository.deleteAll(); // Clear users if necessary

        // Create and save a user
        testUser = new User();
        testUser.setUsername("test" + System.currentTimeMillis());
        testUser.setEmail("test@example.com");
        testUser.setPassword(passwordEncoder.encode("test"));
        testUser.setRole("USER");
        userRepository.save(testUser);

        // Create and save a second user
        testUser2 = new User();
        testUser2.setUsername("test2" + System.currentTimeMillis());
        testUser2.setEmail("test2@example.com");
        testUser2.setPassword(passwordEncoder.encode("test2"));
        testUser2.setRole("USER");
        userRepository.save(testUser2);

        // Create and save a document
        testDocument = new Document();
        testDocument.setTitle("test");
        testDocument.setContent("test");
        testDocument.setCreatedAt(Timestamp.from(Instant.now()));
        testDocument.setUpdatedAt(Timestamp.from(Instant.now()));
        testDocument.setUser(testUser);
        documentsRepository.save(testDocument);

        // Create a second Document
        testDocument2 = new Document();
        testDocument2.setTitle("test2");
        testDocument2.setContent("test2");
        testDocument2.setCreatedAt(Timestamp.from(Instant.now()));
        testDocument2.setUpdatedAt(Timestamp.from(Instant.now()));
        testDocument2.setUser(testUser2);
        documentsRepository.save(testDocument2);
    }


    @Test
    void testCreateDocument() {
        // Create a new document
        Document createdDoc = documentsService.save("New Document",
                "This is the content of the new document.",
                testUser); // Pass the user ID

        // Assertions
        assertNotNull(createdDoc);
        assertEquals("New Document", createdDoc.getTitle());
        assertEquals("This is the content of the new document.", createdDoc.getContent());
        assertEquals(testUser.getUserId(), createdDoc.getUser().getUserId());

        // Verify the document was saved by checking with the repository
        List<Document> foundDocs = documentsRepository.findByTitle("New Document");
        assertNotNull(foundDocs);
        assertEquals(1, foundDocs.size()); // Ensure only one document with that title exists
        Document foundDoc = foundDocs.get(0);

        // Additional assertions
        assertEquals("New Document", foundDoc.getTitle());
        assertEquals("This is the content of the new document.", foundDoc.getContent());
        assertEquals(testUser.getUserId(), foundDoc.getUser().getUserId());
    }



    @Test
    void findDocuments(){
        List<Document> documents = new ArrayList<>();
        documents.add(testDocument);
        documents.add(testDocument2);

        assertNotNull(documents);
        assertEquals(2, documents.size());
        // test user [0]
        assertEquals(testUser.getUserId(), documents.get(0).getUser().getUserId());
        assertEquals(testUser.getUsername(), documents.get(0).getUser().getUsername());
        assertEquals(testUser.getEmail(), documents.get(0).getUser().getEmail());
        assertEquals(testUser.getPassword(), documents.get(0).getUser().getPassword());
        assertEquals(testUser.getRole(), documents.get(0).getUser().getRole());

        // test user [1]
        assertEquals(testUser2.getUserId(), documents.get(1).getUser().getUserId());
        assertEquals(testUser2.getUsername(), documents.get(1).getUser().getUsername());
        assertEquals(testUser2.getEmail(), documents.get(1).getUser().getEmail());
        assertEquals(testUser2.getPassword(), documents.get(1).getUser().getPassword());
        assertEquals(testUser2.getRole(), documents.get(1).getUser().getRole());

        // test document [0]
        assertEquals(testDocument.getTitle(), documents.get(0).getTitle());
        assertEquals(testDocument.getContent(), documents.get(0).getContent());
        assertEquals(testDocument.getCreatedAt(), documents.get(0).getCreatedAt());
        assertEquals(testDocument.getUpdatedAt(), documents.get(0).getUpdatedAt());
        assertEquals(testDocument.getUser(), documents.get(0).getUser());

        // test document [1]
        assertEquals(testDocument2.getTitle(), documents.get(1).getTitle());
        assertEquals(testDocument2.getContent(), documents.get(1).getContent());
        assertEquals(testDocument2.getCreatedAt(), documents.get(1).getCreatedAt());
        assertEquals(testDocument2.getUpdatedAt(), documents.get(1).getUpdatedAt());
        assertEquals(testDocument2.getUser(), documents.get(1).getUser());

    }


    @Test
    void testFindByTitle() {
        // Retrieve documents with the title of testDocument
        List<Document> documents = documentsService.findByTitle(testDocument.getTitle());

        documents.add(testDocument);
        documents.add(testDocument2);

        assertNotNull(documents);
        assertEquals(4, documents.size());

        // Assert properties of the first document
        Document firstDoc = documents.get(0);
        assertEquals(testDocument.getTitle(), firstDoc.getTitle());

        Document secondDoc = documents.get(1);
        assertEquals(testDocument2.getTitle(), secondDoc.getTitle());



    }

}
