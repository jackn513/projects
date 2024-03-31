package org.example.music2.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Id;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Artist {
    @Id
    @JsonProperty("Artist Id")
    private int artistId;
    @JsonProperty("Artist Name")
    private String artistName;

    @JsonProperty("Artist Image")
    private String artistImage;
    @JsonProperty("Date of Birth")
    private LocalDate dateOfBirth;
    @JsonProperty("Date of Death")
    private LocalDate dateOfDeath;
    @JsonProperty("Album")
    private Album album;

    public Artist(int artistId, String artistName, String artistImage, LocalDate dateOfBirth, LocalDate dateOfDeath, Album album) {
        this.artistId = artistId;
        this.artistName = artistName;
        this.artistImage = artistImage;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = dateOfDeath;
        this.album = album;
    }

    public Artist() {
    }

    public int getArtistId() {
        return artistId;
    }

    public String getArtistName() {
        return artistName;
    }

    public String getArtistImage() {
        return artistImage;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public LocalDate getDateOfDeath() {
        return dateOfDeath;
    }

    public Album getAlbum() {
        return album;
    }

    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public void setArtistImage(String artistImage) {
        this.artistImage = artistImage;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setDateOfDeath(LocalDate dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }


}
