package org.example.music2.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.Positive;

public class CartItem {
    @Id
    @JsonProperty("Cart Item Id")
    private int cartItemId;
    @Id
    @JsonProperty("Customer Id")
    private int customerId;
    @Id
    @JsonProperty("Album Id")
    @Positive
    private int albumId;

    @JsonProperty("Album")
    private Album album;
    @JsonProperty("Quantity")
    @Positive
    private int quantity;

    public CartItem() {
    }

    public CartItem(int cartItemId, int customerId, int albumId, Album album, int quantity) {
        this.cartItemId = cartItemId;
        this.customerId = customerId;
        this.albumId = albumId;
        this.album = album;
        this.quantity = quantity;
    }

    public int getCartItemId() {
        return cartItemId;
    }

    public int getCustomerId(){
        return customerId;
    }

    public int getAlbumId() {
        return albumId;
    }

    public Album getAlbum() {
        return album;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setCartItemId(int cartItemId) {
        this.cartItemId = cartItemId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
