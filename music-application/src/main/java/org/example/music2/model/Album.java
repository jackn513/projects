package org.example.music2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonProperty("Artist Id")
    private int artistId;
    @JsonProperty("Label id")
    private int labelId;
    @JsonProperty("Date Released")
    private LocalDate dateReleased;
    @JsonProperty("Length")
    private int lengthInMin;
    @JsonProperty("Price")
    private BigDecimal price;

    @JsonProperty("Album Image")
    private String image;
    @JsonIgnore
    private int userId;
    @JsonIgnore
    private String userName;

    public Album(int albumId, String albumTitle, int artistId, int labelId, LocalDate dateReleased,
                 int lengthInMin, BigDecimal price, int userId, String userName) {
        this.albumId = albumId;
        this.albumTitle = albumTitle;
       this.artistId = artistId;
       this.labelId = labelId;
        this.dateReleased = dateReleased;
        this.lengthInMin = lengthInMin;
        this.price = price;
        this.userId = userId;
        this.userName = userName;
    }

    public Album() {
    }

    public int getAlbumId() {
        return albumId;
    }

    public String getAlbumTitle() {
        return albumTitle;
    }


    public int getArtistId() {
        return artistId;
    }

    public int getLabelId() {
        return labelId;
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


    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }

    public void setLabelId(int labelId) {
        this.labelId = labelId;
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
