package model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;

public class CustomerPlants {

    @Id
    @JsonProperty("Customer Id")
    private int customerId;
    @Id
    @JsonProperty("Plant Id")
    private int plantId;

    public CustomerPlants(int customerId, int plantId) {
        this.customerId = customerId;
        this.plantId = plantId;
    }

    public CustomerPlants() {
    }

    public int getCustomerId() {
        return customerId;
    }

    public int getPlantId() {
        return plantId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setPlantId(int plantId) {
        this.plantId = plantId;
    }
}
