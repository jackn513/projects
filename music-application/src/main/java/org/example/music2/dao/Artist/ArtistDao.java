package org.example.music2.dao.Artist;

import org.example.music2.model.Artist;
import java.util.List;

public interface ArtistDao {

    Artist getArtistById(int artistId);
    List<Artist> getArtists();
    Artist createArtist(Artist newArtist);
    Artist updateArtist(Artist updatedArtist);

    int deleteArtist(int artistId);
}
