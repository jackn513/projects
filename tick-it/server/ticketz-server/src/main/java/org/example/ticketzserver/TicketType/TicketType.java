package org.example.ticketzserver.TicketType;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity(name = "ticket_type")
public class TicketType {

    @Id
    @SequenceGenerator(
            name = "ticket_type_sequence",
            sequenceName = "ticket_type_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "ticket_type_sequence"
    )
    @Column(
            name = "type_id",
            updatable = false
    )
    private int typeId;
    @Column(
            name = "event_id",
            nullable = false,
            columnDefinition = "INT"
    )
    private int eventId;
    @Column(
            name = "ticket_type",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String ticketType;
    @Column(
            name = "price",
            nullable = false,
            columnDefinition = "DECIMAL",
            updatable = true
    )
    private BigDecimal price;
    @Column(
            name = "tickets_available",
            nullable = false,
            columnDefinition = "INT",
            updatable = true
    )
    private int ticketsAvailable;

    public TicketType(int typeId, int eventId, String ticketType, BigDecimal price, int ticketsAvailable) {
        this.typeId = typeId;
        this.eventId = eventId;
        this.ticketType = ticketType;
        this.price = price;
        this.ticketsAvailable = ticketsAvailable;
    }

    public TicketType() {
    }

    public int getTypeId() {
        return typeId;
    }

    public int getEventId() {
        return eventId;
    }

    public String getTicketType() {
        return ticketType;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getTicketsAvailable() {
        return ticketsAvailable;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setTicketsAvailable(int ticketsAvailable) {
        this.ticketsAvailable = ticketsAvailable;
    }
}
