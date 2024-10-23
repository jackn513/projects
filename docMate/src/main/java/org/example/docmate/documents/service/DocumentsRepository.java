package org.example.docmate.documents.service;

import org.example.docmate.documents.model.Document;
import org.example.docmate.users.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface DocumentsRepository extends JpaRepository<Document, Integer> {

    @Query("SELECT d from documents d where d.title ilike %:title%")
    List<Document> findByTitle(@Param("title") String title);

    @Query("SELECT d from documents d where d.title ilike %:title% and d.user = :user")
    Optional<Document> findByTitleAndUser(String title, User user);

    @Query("SELECT d FROM documents d ORDER BY d.documentId ASC")
    List<Document> findAll();

    @Query("SELECT d FROM documents d WHERE d.user.userId = :userId")
    List<Document> findByUserId(@Param("userId") int userId);
}
