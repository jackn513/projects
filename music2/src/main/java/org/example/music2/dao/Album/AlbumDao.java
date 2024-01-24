package org.example.music2.dao.Album;

import org.example.music2.model.Album;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface AlbumDao {

    Album getAlbumById(int albumId);
    List<Album> getAlbums();
    public List<Album> getAlbumByArtistId(int artistId);
    public List<Album> getAlbumsByLabelId(int labelId);
    List<Album> getAlbumsByDateReleased(LocalDate yearReleased);
    List<Album> getAlbumsByPrice(BigDecimal price);
    Album createAlbum(Album newAlbum);
    Album updatedAlbum(Album updatedAlbum);
    int deleteAlbumById(int AlbumId);
}
