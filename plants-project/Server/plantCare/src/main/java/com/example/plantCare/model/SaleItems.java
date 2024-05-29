package com.example.plantCare.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;

public class SaleItems {

    @Id
    @JsonProperty("Sale Id")
    private int saleId;
    @Id
    @JsonProperty("Plant Id")
    private int plantId;
    @JsonProperty("Quantity")
    private int quantity;

    public SaleItems(int saleId, int plantId, int quantity) {
        this.saleId = saleId;
        this.plantId = plantId;
        this.quantity = quantity;
    }

    public SaleItems() {
    }

    public int getSaleId() {
        return saleId;
    }

    public int getPlantId() {
        return plantId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setSaleId(int saleId) {
        this.saleId = saleId;
    }

    public void setPlantId(int plantId) {
        this.plantId = plantId;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
