package org.example.music2.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;


import java.math.BigDecimal;
import java.time.LocalDate;

public class Album {
    @Id
    @JsonProperty("Album Id")
    private int albumId;
    @JsonProperty("Album Title")
    private String albumTitle;
    @JsonProperty("Artist Name")
    private String artistName;
    @JsonProperty("Label Name")
    private String labelName;
    @JsonProperty("Date Released")
    private LocalDate dateReleased;
    @JsonProperty("Length")
    private int lengthInMin;
    @JsonProperty("Price")
    private BigDecimal price;

    @JsonProperty("Album Image")
    private String image;

    public Album(int albumId, String albumTitle, String artistName, String labelName, LocalDate dateReleased,
                 int lengthInMin, BigDecimal price) {
        this.albumId = albumId;
        this.albumTitle = albumTitle;
        this.artistName = artistName;
        this.labelName = labelName;
        this.dateReleased = dateReleased;
        this.lengthInMin = lengthInMin;
        this.price = price;
    }

    public Album() {
    }

    public int getAlbumId() {
        return albumId;
    }

    public String getAlbumTitle() {
        return albumTitle;
    }



    public String getArtistName() {
        return artistName;
    }



    public String getLabelName() {
        return labelName;
    }

    public LocalDate getDateReleased() {
        return dateReleased;
    }

    public int getLengthInMin() {
        return lengthInMin;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getImage() {
        return image;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    public void setAlbumTitle(String albumTitle) {
        this.albumTitle = albumTitle;
    }



    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }



    public void setLabelName(String labelName) {
        this.labelName = labelName;
    }

    public void setDateReleased(LocalDate dateReleased) {
        this.dateReleased = dateReleased;
    }

    public void setLengthInMin(int lengthInMin) {
        this.lengthInMin = lengthInMin;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
