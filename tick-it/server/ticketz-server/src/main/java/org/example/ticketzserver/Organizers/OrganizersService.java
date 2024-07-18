package org.example.ticketzserver.Organizers;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OrganizersService {

    private final OrganizersRepository organizersRepository;

    public OrganizersService(OrganizersRepository organizersRepository) {
        this.organizersRepository = organizersRepository;
    }

    public List<Organizers> getAllOrganizers() {
        return organizersRepository.findAll();
    }

    public List<Organizers> getOrganizersByName(String organizerName) {
        // Call the custom repository method
        List<Organizers> organizers = organizersRepository.findByOrganizerNameContainingIgnoreCase(organizerName);

        // Optional: Logging output to verify
        System.out.println("Found organizers by name segment '" + organizerName + "': " + organizers);

        return organizers;
    }
}
