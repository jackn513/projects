package org.example.docmate.collaborators.service;

import org.example.docmate.collaborators.model.Collaborators;
import org.example.docmate.documents.model.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CollaboratorsRepository extends JpaRepository<Collaborators, Integer> {


    @Query("SELECT c FROM Collaborators c WHERE c.user.userId = :userId AND c.document.documentId = :documentId")
    Optional<Collaborators> findByUserIdAndDocumentId(@Param("userId") int userId, @Param("documentId") int documentId);

    @Query("SELECT c FROM Collaborators c WHERE c.role = :role")
    List<Collaborators> findByRole(@Param("role") String role);
}
