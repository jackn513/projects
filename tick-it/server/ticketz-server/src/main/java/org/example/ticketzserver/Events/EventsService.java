package org.example.ticketzserver.Events;

import jdk.jfr.Event;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EventsService {

    private final EventsRepository eventsRepository;

    public EventsService(EventsRepository eventsRepository) {
        this.eventsRepository = eventsRepository;
    }

    public List<Events> getAllEvents() {
        return eventsRepository.findAll();
    }

    public List<Events> getEventsByName(String eventName) {
        List<Events> events = eventsRepository.findEventNameContainingIgnoreCase(eventName);

        System.out.println("Found Events: " + eventName + events);

        return events;
    }

    public Events getEventById(int eventId) {
        return eventsRepository.findByEventId(eventId);
    }


}
