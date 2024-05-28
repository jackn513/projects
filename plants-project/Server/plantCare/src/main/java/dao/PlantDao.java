package dao;

import model.Plant;

import java.util.List;

public interface PlantDao {

    Plant getPlantById(int plantId);

    List<Plant> getPlants();
    Plant createPlant(Plant newPlant);
    Plant updatePlant(Plant updatedPlant);

    Plant deletePlant(int plantId);

}
