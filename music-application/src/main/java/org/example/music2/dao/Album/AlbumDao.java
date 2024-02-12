package org.example.music2.dao.Album;

import org.example.music2.model.Album;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
@Repository
public interface AlbumDao {

    Album getAlbumById(int albumId);
    List<Album> getAlbums();
    public List<Album> getAlbumByArtistId(int artistId);
    public List<Album> getAlbumByTitle(String title);
    public List<Album> getAlbumsByLabelId(int labelId);
    List<Album> getAlbumsByDateReleased(LocalDate yearReleased);
    List<Album> getAlbumsByPrice(BigDecimal price);

    int deleteAlbumById(int AlbumId);
}
