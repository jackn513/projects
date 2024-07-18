package org.example.ticketzserver.Controller;

import org.example.ticketzserver.Events.Events;

import org.example.ticketzserver.Events.EventsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/events")
public class EventController {

    private final EventsService eventsService;

    public EventController(EventsService eventsService) {
        this.eventsService = eventsService;
    }

    @GetMapping()
    public List<Events> getAllEvents() {
        return eventsService.getAllEvents();
    }

    @GetMapping("/name/{eventName}")
    public List<Events> getEventsByEventName(@PathVariable String eventName) {
        return eventsService.getEventsByName(eventName);
    }

    @GetMapping("/{id}")
    public Events getEventById(@PathVariable int id) {
        return eventsService.getEventById(id);
    }

    @GetMapping("/test")
    public String test() {
        return "Connected successfully";
    }



}
