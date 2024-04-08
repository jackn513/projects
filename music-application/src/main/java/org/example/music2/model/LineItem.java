package org.example.music2.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;


public class LineItem {
    @Id
    @JsonProperty("Line Item Id")
    private int lineItemId;
    @JsonProperty("Sale Id")
    private int saleId;
    @JsonProperty("Album Id")
    private int albumId;
    @JsonProperty("Quantity")
    private int quantity;

    public LineItem(int lineItemId, int saleId, int albumId, int quantity) {
        this.lineItemId = lineItemId;
        this.saleId = saleId;
        this.albumId = albumId;
        this.quantity = quantity;
    }

    public LineItem() {
    }

    public int getLineItemId() {
        return lineItemId;
    }

    public int getSaleId() {
        return saleId;
    }

    public int getAlbumId() {
        return albumId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setLineItemId(int lineItemId) {
        this.lineItemId = lineItemId;
    }

    public void setSaleId(int saleId) {
        this.saleId = saleId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
