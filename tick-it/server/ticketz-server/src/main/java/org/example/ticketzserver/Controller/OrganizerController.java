package org.example.ticketzserver.Controller;


import org.example.ticketzserver.Organizers.Organizers;
import org.example.ticketzserver.Organizers.OrganizersService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/organizers")

public class OrganizerController {

    private final OrganizersService organizersService;

    public OrganizerController(OrganizersService organizersService) {
        this.organizersService = organizersService;
    }

    @GetMapping()
    public List<Organizers> getAllOrganizers() {
        return organizersService.getAllOrganizers();
    }

    @GetMapping("/{organizerName}")
    public List<Organizers> getOrganizerByName(@PathVariable String organizerName) {
        return organizersService.getOrganizersByName(organizerName);
    }

    @GetMapping("/test")
    public String test() {
        return "Connected successfully";
    }




}
