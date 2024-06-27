package com.example.plantCare.dao;

import java.util.List;
import com.example.plantCare.model.Soil;

public interface SoilDao {

    List<Soil> getSoils();
    Soil getSoilById(int soilId);
    List<Soil> getSoilByType(String type);
    Soil createSoil(Soil newSoil);
    Soil updateSoil(Soil updatedSoil);
    int deleteSoil(int soilId);
}
