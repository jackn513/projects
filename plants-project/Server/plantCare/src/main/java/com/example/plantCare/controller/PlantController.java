package com.example.plantCare.controller;

import com.example.plantCare.dao.PlantDao;
import com.example.plantCare.model.Plant;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("plants")
@PreAuthorize("permitAll")
public class PlantController {
    private final PlantDao plantDao;

    public PlantController(PlantDao plantDao){
        this.plantDao = plantDao;
    }
    @RequestMapping( method = RequestMethod.GET)

    public List<Plant> getPlants(){
        return plantDao.getPlants();
    }
    @RequestMapping(path = "/{id}",  method = RequestMethod.GET)
    public Plant getByPlantId(@PathVariable int id){
        Plant plant = plantDao.getPlantById(id);
        if (plant == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Plant Not Found");
        } else {
            return plant;
        }
    }

    @RequestMapping(path = "/title", method = RequestMethod.GET)
    public List<Plant> plantsByTitle(@RequestParam(defaultValue = "") String name){
        if (!name.isEmpty()){
            return plantDao.getPlantByName(name);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Plant Not Found");
        }
    }
    @RequestMapping(path = "/test", method = RequestMethod.GET)
    public String testEndpoint() {
        return "Endpoint is working";
    }
}
