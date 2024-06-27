package com.example.plantCare.controller;

import com.example.plantCare.dao.SoilDao;
import com.example.plantCare.model.Soil;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("soils")
@PreAuthorize("permitAll()")
public class SoilController {

    private final SoilDao soilDao;

    public SoilController(SoilDao soilDao){
        this.soilDao = soilDao;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Soil> getSoils(){
        return soilDao.getSoils();
    }
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Soil getSoilById(@PathVariable int id){
        Soil soil = soilDao.getSoilById(id);
        if (soil == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Soil Not Found");
        } else {
            return soil;
        }
    }
    @RequestMapping(path = "/type", method = RequestMethod.GET)
    public List<Soil> getPlantsByType(@RequestParam(defaultValue = "") String type){
        if (!type.isEmpty()){
            return soilDao.getSoilByType(type);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Soil Not Found");
        }
    }
    @RequestMapping(path = "/test", method = RequestMethod.GET)
    public String testEndpoint() {
        return "Endpoint is working";
    }
}
