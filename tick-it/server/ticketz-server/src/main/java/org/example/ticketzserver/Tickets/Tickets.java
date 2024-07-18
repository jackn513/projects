package org.example.ticketzserver.Tickets;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity(name = "tickets")
public class Tickets {

    @Id
    @SequenceGenerator(
            name = "tickets_sequence",
            sequenceName = "tickets_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "tickets_sequence"
    )
    @Column(
            name = "ticket_id",
            updatable = false
    )
    private int ticketId;
    @Column(
            name = "type_id",
            nullable = false,
            columnDefinition = "INT"
    )
    private int typeId;
    @Column(
            name = "user_id",
            nullable = false,
            columnDefinition = "INT"
    )
    private int userId;
    @Column(
            name = "purchase_date",
            nullable = false,
            columnDefinition = "DATE",
            updatable = true
    )
    private LocalDate purchaseDate;
    @Column(
            name = "qr_code",
            nullable = false,
            columnDefinition = "DATE",
            updatable = true
    )
    private String qrCode;

    public Tickets(int ticketId, int typeId, int userId, LocalDate purchaseDate, String qrCode) {
        this.ticketId = ticketId;
        this.typeId = typeId;
        this.userId = userId;
        this.purchaseDate = purchaseDate;
        this.qrCode = qrCode;
    }

    public Tickets() {
    }

    public int getTicketId() {
        return ticketId;
    }

    public int getTypeId() {
        return typeId;
    }

    public int getUserId() {
        return userId;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }
}
