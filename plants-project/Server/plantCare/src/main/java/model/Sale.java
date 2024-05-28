package model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;

public class Sale {

    @Id
    @JsonProperty("Sale Id")
    private int saleId;
    @Id
    @JsonProperty("Customer Id")
    private int customerId;
    @JsonProperty("Sale Date")
    private LocalDate saleDate;
    @JsonProperty("Ship Date")
    private LocalDate shipDate;

    public Sale(int saleId, int customerId, LocalDate saleDate, LocalDate shipDate) {
        this.saleId = saleId;
        this.customerId = customerId;
        this.saleDate = saleDate;
        this.shipDate = shipDate;
    }

    public Sale() {
    }

    public int getSaleId() {
        return saleId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public LocalDate getSaleDate() {
        return saleDate;
    }

    public LocalDate getShipDate() {
        return shipDate;
    }

    public void setSaleId(int saleId) {
        this.saleId = saleId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setSaleDate(LocalDate saleDate) {
        this.saleDate = saleDate;
    }

    public void setShipDate(LocalDate shipDate) {
        this.shipDate = shipDate;
    }
}
