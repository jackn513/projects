package org.example.music2.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Id;

import java.time.LocalDate;

public class Sale {
    @Id
    @JsonProperty("Sale Id")
    private int saleId;
    @JsonProperty("Customer Id")
    private int customerId;
    @JsonProperty("Customer Name")
    private String customerName;
    @JsonProperty("Album Id")
    private int albumId;
    @JsonProperty("Album Name")
    private String albumName;
    @JsonProperty("Sold")
    private Boolean isSold;

    @JsonProperty("Quantity")
    private int quantity;
    @JsonProperty("Sale Date")
    private LocalDate saleDate;

    public Sale(int saleId, int customerId, String customerName, int albumId, String albumName, Boolean isSold, int quantity, LocalDate saleDate) {
        this.saleId = saleId;
        this.customerId = customerId;
        this.customerName = customerName;
        this.albumId = albumId;
        this.albumName = albumName;
        this.isSold = isSold;
        this.quantity = quantity;
        this.saleDate = saleDate;
    }

    public Sale() {
    }

    public int getSaleId() {
        return saleId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public int getAlbumId() {
        return albumId;
    }

    public String getAlbumName() {
        return albumName;
    }

    public Boolean getSold() {
        return isSold;
    }

    public int getQuantity() {
        return quantity;
    }

    public LocalDate getSaleDate() {
        return saleDate;
    }

    public void setSaleId(int saleId) {
        this.saleId = saleId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public void setSold(Boolean sold) {
        isSold = sold;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setSaleDate(LocalDate saleDate) {
        this.saleDate = saleDate;
    }
}
