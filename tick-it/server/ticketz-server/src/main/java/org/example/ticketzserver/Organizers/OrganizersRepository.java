package org.example.ticketzserver.Organizers;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrganizersRepository extends JpaRepository<Organizers, Integer> {

    List<Organizers> findAll();

    @Query("SELECT o FROM organizers o WHERE o.organizerName ILIKE %:organizerName%")
    List<Organizers> findByOrganizerNameContainingIgnoreCase(@Param("organizerName") String organizerName);

}
