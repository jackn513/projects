package org.example.music2.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Id;

import java.time.LocalDate;

public class Artist {
    @Id
    @JsonProperty("Artist Id")
    private int artistId;
    @JsonProperty("Artist Name")
    private String artistName;
    @JsonProperty("Date of Birth")
    private LocalDate dateOfBirth;
    @JsonProperty("Date of Death")
    private LocalDate dateOfDeath;

    public Artist(int artistId, String artistName, LocalDate dateOfBirth, LocalDate dateOfDeath) {
        this.artistId = artistId;
        this.artistName = artistName;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = dateOfDeath;
    }

    public Artist() {
    }

    public int getArtistId() {
        return artistId;
    }

    public String getArtistName() {
        return artistName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public LocalDate getDateOfDeath() {
        return dateOfDeath;
    }

    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setDateOfDeath(LocalDate dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
    }


    public String toString() {
        return
                "Artist id: " + getArtistId() +
                "\n" + "Artist Name: " + getArtistName() +
                "\n" + "Date of Birth: " + getDateOfBirth() +
                "\n" + "Date of Death: " + getDateOfDeath() +
                "\n" +
                "-------------------------------------------------------";
    }
}
