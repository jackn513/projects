package com.example.plantCare.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;

public class Soil {

    @Id
    @JsonProperty("Soil Id")
    private int soilId;
    @JsonProperty("Type")
    private String type;
    @JsonProperty("pH Level")
    private BigDecimal pHLevel;
    @JsonProperty("Nutrients")
    private String nutrients;
    @JsonProperty("Description")
    private String description;

    public Soil(int soilId, String type, BigDecimal pHLevel, String nutrients, String description) {
        this.soilId = soilId;
        this.type = type;
        this.pHLevel = pHLevel;
        this.nutrients = nutrients;
        this.description = description;
    }

    public Soil() {
    }

    public int getSoilId() {
        return soilId;
    }

    public String getType() {
        return type;
    }

    public BigDecimal getpHLevel() {
        return pHLevel;
    }

    public String getNutrients() {
        return nutrients;
    }

    public String getDescription() {
        return description;
    }

    public void setSoilId(int soilId) {
        this.soilId = soilId;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setpHLevel(BigDecimal pHLevel) {
        this.pHLevel = pHLevel;
    }

    public void setNutrients(String nutrients) {
        this.nutrients = nutrients;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
