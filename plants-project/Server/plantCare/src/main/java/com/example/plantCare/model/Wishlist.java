package com.example.plantCare.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;

public class Wishlist {

    @Id
    @JsonProperty("Wishlist Id")
    private int wishlistId;
    @Id
    @JsonProperty("Cusomer Id")
    private int customerId;
    @Id
    @JsonProperty("Plant Id")
    private int plantId;
    @JsonProperty("Added")
    private LocalDate added;

    public Wishlist(int wishlistId, int customerId, int plantId, LocalDate added) {
        this.wishlistId = wishlistId;
        this.customerId = customerId;
        this.plantId = plantId;
        this.added = added;
    }

    public Wishlist() {
    }

    public int getWishlistId() {
        return wishlistId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public int getPlantId() {
        return plantId;
    }

    public LocalDate getAdded() {
        return added;
    }

    public void setWishlistId(int wishlistId) {
        this.wishlistId = wishlistId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setPlantId(int plantId) {
        this.plantId = plantId;
    }

    public void setAdded(LocalDate added) {
        this.added = added;
    }
}
