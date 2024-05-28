package org.example.music2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import java.math.BigDecimal;




public class Album {
    @Id
    @JsonProperty("Album Id")
    private int albumId;
    @JsonProperty("Album Title")
    private String albumTitle;
    @JsonProperty("Artist Id")
    private int artistId;
    @JsonProperty("Artist Name")
    private String artistName;
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

    @JsonProperty("Genre")
    private String genre;
    @JsonProperty("Genre ID")
    private int genreId;
    @JsonIgnore
    private int userId;
    @JsonIgnore
    private String userName;

    public Album(int albumId, String albumTitle, int artistId, String artistName, int labelId, LocalDate dateReleased,
                 int lengthInMin, BigDecimal price, int userId, String userName, String genre, int genreId) {
        this.albumId = albumId;
        this.albumTitle = albumTitle;
       this.artistId = artistId;
       this.artistName = artistName;
       this.labelId = labelId;
        this.dateReleased = dateReleased;
        this.lengthInMin = lengthInMin;
        this.price = price;
        this.userId = userId;
        this.userName = userName;
        this.genre = genre;
        this.genreId = genreId;
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

    public String getGenre() {
        return genre;
    }

    public int getGenreId() {
        return genreId;
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

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
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

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }
}

