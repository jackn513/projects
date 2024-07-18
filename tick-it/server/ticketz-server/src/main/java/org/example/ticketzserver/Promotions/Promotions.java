package org.example.ticketzserver.Promotions;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity(name = "promotions")
public class Promotions {

    @Id
    @SequenceGenerator(
            name = "promotions_sequence",
            sequenceName = "promotions_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "promotions_sequence"
    )
    @Column(
            name = "promotion_id",
            nullable = false
    )
    private int promotionId;
    @Column(
            name = "event_id",
            nullable = false
    )
    private int eventId;
    @Column(
            name = "code",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String code;
    @Column(
            name = "discount",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String discount;
    @Column(
            name = "start_date",
            nullable = false,
            columnDefinition = "DATE"
    )
    private LocalDate startDate;
    @Column(
            name = "end_date",
            nullable = false,
            columnDefinition = "DATE"
    )
    private LocalDate endDate;

    public Promotions(int promotionId, int eventId, String code, String discount, LocalDate startDate, LocalDate endDate) {
        this.promotionId = promotionId;
        this.eventId = eventId;
        this.code = code;
        this.discount = discount;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Promotions() {
    }

    public int getPromotionId() {
        return promotionId;
    }

    public int getEventId() {
        return eventId;
    }

    public String getCode() {
        return code;
    }

    public String getDiscount() {
        return discount;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setPromotionId(int promotionId) {
        this.promotionId = promotionId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
