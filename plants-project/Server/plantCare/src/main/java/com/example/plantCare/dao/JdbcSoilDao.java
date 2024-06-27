package com.example.plantCare.dao;

import com.example.plantCare.exception.DaoException;
import com.example.plantCare.model.Soil;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
@Component
public class JdbcSoilDao implements SoilDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcSoilDao(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Soil> getSoils() {
        List<Soil> soils = new ArrayList<>();
        String sql = "SELECT * FROM soils";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while (results.next()) {
                soils.add(mapRowToSoil(results));
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return soils;
    }

    @Override
    public Soil getSoilById(int soilId) {
        Soil soil = null;
        String sql = "SELECT * FROM soils WHERE soil_id = ?";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, soilId);
            if (results.next()) {
                soil = mapRowToSoil(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return soil;
    }

    @Override
    public List<Soil> getSoilByType(String type) {
        List<Soil> soil = new ArrayList<>();
        String sql = "SELECT * FROM soils WHERE type ILIKE ? ";
        type = "%" + type + "%";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, type.toLowerCase());
            while(results.next()) {
                soil.add(mapRowToSoil(results));
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return soil;
    }

    @Override
    public Soil createSoil(Soil newSoil) {
        int soilId;
        String sql = "INSERT INTO soils (type, pH_level, nutrients, description) " +
                "VALUES (?, ?, ?, ?) " +
                "RETURNING soil_id";
        try {
            soilId = jdbcTemplate.queryForObject(sql, int.class,
                    newSoil.getType(),
                    newSoil.getpHLevel(),
                    newSoil.getNutrients(),
                    newSoil.getDescription());
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return null;
    }

    @Override
    public Soil updateSoil(Soil updatedSoil) {
        Soil soilToUpdate;
        String sql = "UPDATE soils SET type = ?, pH_level = ?, nutrients = ?, description = ? WHERE soil_id = ?";
        try {
            jdbcTemplate.update(sql,
                    updatedSoil.getType(),
                    updatedSoil.getpHLevel(),
                    updatedSoil.getNutrients(),
                    updatedSoil.getDescription(),
                    updatedSoil.getSoilId());
            soilToUpdate = getSoilById(updatedSoil.getSoilId());
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return soilToUpdate; // Return null if update was not successful
    }


    @Override
    public int deleteSoil(int soilId) {
        //TODO finish the second sql statement where soil_id shows in foreign table

        int rowsAffected;
        String sql = "DELETE FROM soils WHERE soil_id = ?";
        try {
            jdbcTemplate.update(sql, soilId);
            rowsAffected = jdbcTemplate.update(sql, soilId);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        } catch (Exception e) {
            throw new DaoException("Error deleting soil with ID: " + soilId, e);
        }
        return rowsAffected;
    }


    public Soil mapRowToSoil(SqlRowSet rowSet){
        Soil soil = new Soil();
        soil.setSoilId(rowSet.getInt("soil_id"));
        soil.setType(rowSet.getString("type"));
        soil.setpHLevel(rowSet.getBigDecimal("pH_level"));
        soil.setNutrients(rowSet.getString("nutrients"));
        soil.setDescription(rowSet.getString("description"));
        return soil;
    }
}
