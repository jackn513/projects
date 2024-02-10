package org.example.music2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.time.LocalDate;
@Entity
@Table(name = "album")
public class Album {

    private int albumId;
    private String albumTitle;
    private int artistId;
    private String artistName;
    private int labelId;
    private String labelName;
    private LocalDate dateReleased;
    private int lengthInMin;
    private BigDecimal price;
    @Id
    private Long id;

    public Album(int albumId, String albumTitle, int artistId, String artistName,
                 int labelId, String labelName, LocalDate dateReleased, int lengthInMin, BigDecimal price) {
        this.albumId = albumId;
        this.albumTitle = albumTitle;
        this.artistId = artistId;
        this.artistName = artistName;
        this.labelId = labelId;
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

    public int getArtistId() {
        return artistId;
    }

    public String getArtistName() {
        return artistName;
    }

    public int getLabelId() {
        return labelId;
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

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    public void setAlbumTitle(String albumTitle) {
        this.albumTitle = albumTitle;
    }

    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public void setLabelId(int labelId) {
        this.labelId = labelId;
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

    @Override
    public String toString() {
        return
                "Album id: " + getAlbumId() + "\n" +
                "Album Title: " + "'" + getAlbumTitle() + "'"  + "\n" +
                "Artist id: " + getArtistId() + "\n" +
                "Artist Name: " + getArtistName() + "\n" +
                "Label id: " + getLabelId() + "\n" +
                "Label Name: " + getLabelName() + "\n" +
                "Date Released: " + getDateReleased() +"\n" +
                "Length: " + getLengthInMin() + " min " + "\n" +
                "Price: " + getPrice() + "\n" +
                "-------------------------------------------------------"
        ;
    }

}
