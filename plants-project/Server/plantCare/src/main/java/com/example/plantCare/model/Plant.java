package com.example.plantCare.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;

public class Plant {
    @Id
    @JsonProperty("Plant Id")
    private int plantId;
    @JsonProperty("Plant Name")
    private String plantName;
    @JsonProperty("Scientific Name")
    private String scientificName;
    @JsonProperty("Plant Description")
    private String plantDescription;
    @JsonProperty("Price")
    private BigDecimal price;
    @JsonProperty("Image")
    private String image;
    @JsonProperty("Water Requirements")
    private String water;
    @JsonProperty("Light Requirements")
    private String light;
    @JsonProperty("Humidity Requirements")
    private String humidity;
    @JsonProperty("Temperature Requirements")
    private String temp;
    @JsonProperty("Toxicity")
    private String toxic;
    @JsonProperty("Fun Fact")
    private String funFact;
    @JsonProperty("Soil Id")
    private int soilId;
    @JsonProperty("Soil Type")
    private String soilType;
    public Plant(int plantId, String plantName, String scientificName, String plantDescription, BigDecimal price, String image, String water, String light, String humidity, String temp, String toxic, String funFact, int soilId, String soilType) {
        this.plantId = plantId;
        this.plantName = plantName;
        this.scientificName = scientificName;
        this.plantDescription = plantDescription;
        this.price = price;
        this.image = image;
        this.water = water;
        this.light = light;
        this.humidity = humidity;
        this.temp = temp;
        this.toxic = toxic;
        this.funFact = funFact;
        this.soilId = soilId;
        this.soilType = soilType;
    }

    public Plant() {
    }

    public int getPlantId() {
        return plantId;
    }

    public String getPlantName() {
        return plantName;
    }

    public String getScientificName() {
        return scientificName;
    }

    public String getPlantDescription() {
        return plantDescription;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getImage() {
        return image;
    }

    public String getWater() {
        return water;
    }

    public String getLight() {
        return light;
    }

    public String getHumidity() {
        return humidity;
    }

    public String getTemp() {
        return temp;
    }

    public String getToxic() {
        return toxic;
    }

    public String getFunFact() {
        return funFact;
    }

    public int getSoilId() {
        return soilId;
    }

    public String getSoilType() {
        return soilType;
    }

    public void setPlantId(int plantId) {
        this.plantId = plantId;
    }

    public void setPlantName(String plantName) {
        this.plantName = plantName;
    }

    public void setScientificName(String scientificName) {
        this.scientificName = scientificName;
    }

    public void setPlantDescription(String plantDescription) {
        this.plantDescription = plantDescription;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setWater(String water) {
        this.water = water;
    }

    public void setLight(String light) {
        this.light = light;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public void setToxic(String toxic) {
        this.toxic = toxic;
    }

    public void setFunFact(String funFact) {
        this.funFact = funFact;
    }

    public void setSoilId(int soilId) {
        this.soilId = soilId;
    }

    public void setSoilType(String soilType) {
        this.soilType = soilType;
    }
}
