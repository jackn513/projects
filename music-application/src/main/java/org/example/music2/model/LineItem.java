package org.example.music2.model;

public class LineItem {
    private int lineItemId;
    private int saleId;
    private int albumId;
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
