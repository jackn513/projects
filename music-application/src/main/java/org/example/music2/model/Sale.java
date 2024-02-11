package org.example.music2.model;

import java.time.LocalDate;

public class Sale {

    private int saleId;
    private int customerId;
    private String customerName;
    private int albumId;
    private String albumName;
    private Boolean isSold;
    private LocalDate saleDate;

    public Sale(int saleId, int customerId, String customerName, int albumId, String albumName, Boolean isSold, LocalDate saleDate) {
        this.saleId = saleId;
        this.customerId = customerId;
        this.customerName = customerName;
        this.albumId = albumId;
        this.albumName = albumName;
        this.isSold = isSold;
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

    public void setSaleDate(LocalDate saleDate) {
        this.saleDate = saleDate;
    }
}
