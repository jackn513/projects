package org.example.ticketzserver.Events;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import org.example.ticketzserver.Organizers.Organizers;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Entity(name = "events")
public class Events {

    @Id
    @JsonProperty("Event Id")
    @SequenceGenerator(
            name = "events_sequence",
            sequenceName = "events_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "events_sequence")
    @Column(name = "event_id", updatable = false, nullable = false)
    private int eventId;

    @ManyToOne
    @JsonProperty("Organizer")
    @JoinColumn(name = "organizer_id", referencedColumnName = "organizer_id", nullable = false)
    private Organizers organizers;

    @Column(name = "event_name", nullable = false)
    @JsonProperty("Event Name")
    private String eventName;

    @Column(name = "description", nullable = false)
    @JsonProperty("Event Description")
    private String description;

    @Column(name = "date", nullable = false)
    @JsonProperty("Date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy")
    private LocalDate date;

    @Column(name = "time", nullable = false)
    @JsonProperty("Time of Event")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "hh:mm a") // 12-hour format with AM/PM
    private LocalTime time;
    @Column(name = "location", nullable = false)
    @JsonProperty("Location")
    private String location;

    @Column(name = "status", nullable = false)
    @JsonProperty("Status")
    private String status;

    // Constructors
    public Events() {
    }

    public Events(Organizers organizers, String eventName, String description, LocalDate date, LocalTime time, String location, String status) {
        this.organizers = organizers;
        this.eventName = eventName;
        this.description = description;
        this.date = date;
        this.time = time;
        this.location = location;
        this.status = status;
    }

    // Getters and setters
    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public Organizers getOrganizers() {
        return organizers;
    }

    public void setOrganizers(Organizers organizers) {
        this.organizers = organizers;
    }


    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }


    public void setDate(LocalDate date) {
        this.date = date;
    }
    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String dateToString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); // Adjust pattern as needed
        return date.format(formatter);
    }
}

