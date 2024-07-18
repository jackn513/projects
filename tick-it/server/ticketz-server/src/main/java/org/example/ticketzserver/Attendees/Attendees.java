package org.example.ticketzserver.Attendees;

import jakarta.persistence.*;

import java.time.LocalDate;

public class Attendees {

    @Id
    @SequenceGenerator(
            name = "attendees_sequence",
            sequenceName = "attendees_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "attendees_sequence"
    )
    @Column(
            name = "user_id",
            updatable = false
    )
    private int attendeeId;
    @Column(
            name = "ticket_id",
            updatable = false,
            nullable = false
    )
    private int ticketId;
    @Column(
            name = "user_id",
            updatable = false,
            nullable = false
    )
    private int userId;
    @Column(
            name = "check_in_date",
            updatable = false,
            nullable = false,
            columnDefinition = "DATE"
    )
    private LocalDate checkInDate;

    public Attendees(int attendeeId, int ticketId, int userId, LocalDate checkInDate) {
        this.attendeeId = attendeeId;
        this.ticketId = ticketId;
        this.userId = userId;
        this.checkInDate = checkInDate;
    }

    public Attendees() {
    }

    public int getAttendeeId() {
        return attendeeId;
    }

    public int getTicketId() {
        return ticketId;
    }

    public int getUserId() {
        return userId;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public void setAttendeeId(int attendeeId) {
        this.attendeeId = attendeeId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setCheckInDate(LocalDate checkInDate) {
        this.checkInDate = checkInDate;
    }
}
