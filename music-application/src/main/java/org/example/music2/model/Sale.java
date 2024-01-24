package org.example.music2.model;

import java.time.LocalDate;

public class Sale {

    private int saleId;
    private int customerId;
    private int albumId;
    private Boolean isSold;
    private LocalDate saleDate;

    public Sale(int saleId, int customerId, int albumId, Boolean isSold, LocalDate saleDate) {
        this.saleId = saleId;
        this.customerId = customerId;
        this.albumId = albumId;
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

    public int getAlbumId() {
        return albumId;
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

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    public void setSold(Boolean sold) {
        isSold = sold;
    }

    public void setSaleDate(LocalDate saleDate) {
        this.saleDate = saleDate;
    }
}
