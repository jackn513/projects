package org.example.ticketzserver.Organizers;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity(name = "organizers")
public class Organizers {

    @Id
    @JsonProperty("Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "organizer_id", updatable = false)
    private int organizerId;

    @JsonProperty("Organizer Name")
    @Column(name = "organizer_name", nullable = false, columnDefinition = "TEXT")
    private String organizerName;

    @JsonProperty("Organizer Bio")
    @Column(name = "organizer_bio", nullable = false, columnDefinition = "TEXT")
    private String organizerBio;

    public Organizers() {
    }

    public int getOrganizerId() {
        return organizerId;
    }

    public void setOrganizerId(int organizerId) {
        this.organizerId = organizerId;
    }

    public String getOrganizerName() {
        return organizerName;
    }

    public void setOrganizerName(String organizerName) {
        this.organizerName = organizerName;
    }

    public String getOrganizerBio() {
        return organizerBio;
    }

    public void setOrganizerBio(String organizerBio) {
        this.organizerBio = organizerBio;
    }


}
