package model;

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

    public Plant(int plantId, String plantName, String scientificName, BigDecimal price, String image, String water, String light, String humidity, String temp, String toxic, String funFact) {
        this.plantId = plantId;
        this.plantName = plantName;
        this.scientificName = scientificName;
        this.price = price;
        this.image = image;
        this.water = water;
        this.light = light;
        this.humidity = humidity;
        this.temp = temp;
        this.toxic = toxic;
        this.funFact = funFact;
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

    public void setPlantId(int plantId) {
        this.plantId = plantId;
    }

    public void setPlantName(String plantName) {
        this.plantName = plantName;
    }

    public void setScientificName(String scientificName) {
        this.scientificName = scientificName;
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
}
