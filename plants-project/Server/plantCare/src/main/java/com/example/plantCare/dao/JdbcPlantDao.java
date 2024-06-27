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
import java.util.function.ToDoubleBiFunction;

@Component
public class JdbcPlantDao implements PlantDao{
    private final JdbcTemplate jdbcTemplate;

    public JdbcPlantDao(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public List<Plant> getPlants() {
        List<Plant> plants = new ArrayList<>();
        String sql = "SELECT * FROM plants " +
                "JOIN soils s ON plants.soil_id = s.soil_id " +
                "ORDER BY plant_id";
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
        String sql = "SELECT * FROM plants " +
                "JOIN soils s ON plants.soil_id = s.soil_id " +
                "WHERE plant_id = ? " +
                "ORDER BY plant_id";
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
        Plant plantToUpdate;
        String sql = "UPDATE plants " +
                "SET name = ?, " +
                "scientific_name = ?, " +
                "plant_description = ?," +
                "price = ?, " +
                "image_name = ?, " +
                "water = ?, " +
                "light = ?, " +
                "humidity = ?, " +
                "temp = ?, " +
                "toxic = ?, " +
                "fun_fact = ?, " +
                "soil_id = ?";
        try {
            jdbcTemplate.update(sql,
                    updatedPlant.getPlantName(),
                    updatedPlant.getScientificName(),
                    updatedPlant.getPlantDescription(),
                    updatedPlant.getPrice(),
                    updatedPlant.getImage(),
                    updatedPlant.getWater(),
                    updatedPlant.getLight(),
                    updatedPlant.getHumidity(),
                    updatedPlant.getTemp(),
                    updatedPlant.getToxic(),
                    updatedPlant.getFunFact(),
                    updatedPlant.getSoilId());
            plantToUpdate = getPlantById(updatedPlant.getPlantId());
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return plantToUpdate;
    }

    @Override
    public int deletePlant(int plantId) {
        //TODO finish the second sql statement where plant_id shows in foreign table (i.e journal)
        int rowsAffected;
        String plantSql = "DELETE FROM plants WHERE plant_id = ?";
        try {
            jdbcTemplate.update(plantSql, plantId);
            rowsAffected = jdbcTemplate.update(plantSql, plantId);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        } catch (Exception e) {
            throw new DaoException("Error deleting soil with ID: " + plantId, e);
        }
        return rowsAffected;
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
        plant.setSoilId(rowSet.getInt("soil_id"));
        plant.setSoilType(rowSet.getString("type"));
        return plant;
    }
}
