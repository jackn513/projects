package org.example.ticketzserver;


import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity(name = "analytics")
public class Analytics {

    @Id
    @SequenceGenerator(
            name = "organizers_sequence",
            sequenceName = "organizers_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "organizers_sequence"
    )
    @Column(
            name = "organizer_id",
            updatable = false
    )
    private int analyticsId;
    @Column(
            name = "event_id",
            nullable = false,
            columnDefinition = "INT"
    )
    private int eventId;
    @Column(
            name = "tickets_sold",
            nullable = false,
            columnDefinition = "INT"
    )
    private int ticketsSold;
    @Column(
            name = "total_revenue",
            nullable = false,
            columnDefinition = "DECIMAL"
    )
    private BigDecimal totalRevenue;
    @Column(
            name = "date_generated",
            nullable = false,
            columnDefinition = "DATE"
    )
    private LocalDate dateGenerated;

    public Analytics(int analyticsId, int eventId, int ticketsSold, BigDecimal totalRevenue, LocalDate dateGenerated) {
        this.analyticsId = analyticsId;
        this.eventId = eventId;
        this.ticketsSold = ticketsSold;
        this.totalRevenue = totalRevenue;
        this.dateGenerated = dateGenerated;
    }

    public Analytics() {
    }

    public int getAnalyticsId() {
        return analyticsId;
    }

    public int getEventId() {
        return eventId;
    }

    public int getTicketsSold() {
        return ticketsSold;
    }

    public BigDecimal getTotalRevenue() {
        return totalRevenue;
    }

    public LocalDate getDateGenerated() {
        return dateGenerated;
    }

    public void setAnalyticsId(int analyticsId) {
        this.analyticsId = analyticsId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public void setTicketsSold(int ticketsSold) {
        this.ticketsSold = ticketsSold;
    }

    public void setTotalRevenue(BigDecimal totalRevenue) {
        this.totalRevenue = totalRevenue;
    }

    public void setDateGenerated(LocalDate dateGenerated) {
        this.dateGenerated = dateGenerated;
    }
}
