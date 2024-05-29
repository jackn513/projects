package com.example.plantCare.dao;

import com.example.plantCare.exception.DaoException;
import com.example.plantCare.model.Plant;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
@Component
public class JdbcPlantDao implements PlantDao{
    private final JdbcTemplate jdbcTemplate;

    public JdbcPlantDao(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public List<Plant> getPlants() {
        List<Plant> plants = new ArrayList<>();
        String sql = "SELECT * FROM plants";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while (results.next()){
                plants.add(mapRowToPlant(results));
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return plants;
    }
    @Override
    public Plant getPlantById(int plantId) {
        Plant plant = null;
        String sql = "SELECT * FROM plants WHERE plant_id = ?";
        try{
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, plantId);
            if (results.next()) {
                plant = mapRowToPlant(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return plant;
    }

    @Override
    public List<Plant> getPlantByName(String name) {
        List<Plant> plants = new ArrayList<>();
        String sql = "SELECT * FROM plants WHERE name ILIKE ?";
        name = "%" + name + "%";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, name.toLowerCase());
            while (results.next()) {
                plants.add(mapRowToPlant(results));
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return plants;
    }

    @Override
    public Plant createPlant(Plant newPlant) {
        int plantId;
        String sql = "INSERT INTO plants (name, " +
                "scientific_name, " +
                "plant_description, " +
                "price, " +
                "image_name, " +
                "water, " +
                "light, " +
                "humidity, " +
                "temp, " +
                "toxic, " +
                "fun_fact) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) " +
                "RETURNING plant_id";
        try {
            plantId = jdbcTemplate.queryForObject(sql,
                    int.class,
                    newPlant.getPlantName(),
                    newPlant.getScientificName(),
                    newPlant.getPlantDescription(),
                    newPlant.getPrice(),
                    newPlant.getImage(),
                    newPlant.getWater(),
                    newPlant.getLight(),
                    newPlant.getHumidity(),
                    newPlant.getTemp(),
                    newPlant.getToxic(),
                    newPlant.getFunFact());
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return getPlantById(plantId);
    }

    @Override
    public Plant updatePlant(Plant updatedPlant) {
        return null;
    }

    @Override
    public Plant deletePlant(int plantId) {
        return null;
    }

    public Plant mapRowToPlant(SqlRowSet rowSet){
        Plant plant = new Plant();
        plant.setPlantId(rowSet.getInt("plant_id"));
        plant.setPlantName(rowSet.getString("name"));
        plant.setScientificName(rowSet.getString("scientific_name"));
        plant.setPlantDescription(rowSet.getString("plant_description"));
        plant.setPrice(BigDecimal.valueOf(rowSet.getDouble("price")));
        plant.setImage(rowSet.getString("image_name"));
        plant.setWater(rowSet.getString("water"));
        plant.setLight(rowSet.getString("light"));
        plant.setHumidity(rowSet.getString("humidity"));
        plant.setTemp(rowSet.getString("temp"));
        plant.setToxic(rowSet.getString("toxic"));
        plant.setFunFact(rowSet.getString("fun_fact"));
        return plant;
    }
}
