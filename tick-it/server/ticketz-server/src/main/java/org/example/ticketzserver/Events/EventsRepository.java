package org.example.ticketzserver.Events;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EventsRepository extends JpaRepository<Events, Long> {

//
    List<Events> findAll();

    @Query("SELECT e FROM events e  WHERE e.eventName ILIKE %:eventName%")
    List<Events> findEventNameContainingIgnoreCase(@Param("eventName") String eventName);

    Events findByEventId(int id);
}
