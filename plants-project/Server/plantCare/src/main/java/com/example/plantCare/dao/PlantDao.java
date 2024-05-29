package com.example.plantCare.dao;

import com.example.plantCare.model.Plant;

import java.util.List;

public interface PlantDao {


    List<Plant> getPlants();
    Plant getPlantById(int plantId);
    List<Plant> getPlantByName(String name);
    Plant createPlant(Plant newPlant);
    Plant updatePlant(Plant updatedPlant);

    Plant deletePlant(int plantId);

}
