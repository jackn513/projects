package org.example.music2.dao.Artist;

import org.example.music2.exception.DaoException;
import org.example.music2.model.Album;
import org.example.music2.model.Artist;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class JdbcArtistDao implements ArtistDao {

    private final JdbcTemplate jdbcTemplate;
    public JdbcArtistDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    @Override
    public Artist getArtistById(int artistId) {
        Artist artist = null;
        String sql = "SELECT * FROM artist_info WHERE artist_id = ?;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, artistId);
            if (results.next()) {
                artist = mapRowToArtist(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return artist;
    }

    @Override
    public List<Artist> getArtistsByDateOfBirth(LocalDate startDate, LocalDate endDate) {
        List <Artist> artists = new ArrayList<>();
        String sql =
                "SELECT * FROM artist_info WHERE EXTRACT(YEAR FROM date_of_birth) BETWEEN ? AND ?;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, startDate.getYear(), endDate.getYear());
            while (results.next()) {
                artists.add(mapRowToArtist(results));
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return artists;
    }

    @Override
    public List<Artist> getArtistsWithAlbums(int artistId) {
        List<Artist> artists = new ArrayList<>();
        String sql = "SELECT * FROM artist_info JOIN album ON artist_info.artist_id = album.artist_id " +
                "WHERE artist_info.artist_id = ?";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, artistId);
            while(results.next()) {
                artists.add(mapRowToArtistWithAlbum(results));
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return artists;
    }


    @Override
    public List<Artist> getArtists() {
        List <Artist> artists = new ArrayList<>();
        String sql =
                "SELECT * FROM artist_info";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while (results.next()) {
                artists.add(mapRowToArtist(results));
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return artists;

    }

    @Override
    public Artist createArtist(Artist newArtist) {
        int artistId;
        String sql = "INSERT INTO artist_info (artist_name, artist_image, date_of_birth, date_of_death) " +
                "VALUES (?, ?, ?) RETURNING artist_id;";
        try {
            artistId = jdbcTemplate.queryForObject(sql, int.class,
                    newArtist.getArtistName(),
                    newArtist.getArtistImage(),
                    newArtist.getDateOfBirth(), newArtist.getDateOfDeath());
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return getArtistById(artistId);
    }

    @Override
    public Artist updateArtist(Artist updatedArtist) {
        return null;
    }

    @Override
    public int deleteArtist(int artistId) {
        return 0;
    }

    private Artist mapRowToArtist(SqlRowSet rowSet) {
        Artist artist = new Artist();
        artist.setArtistId(rowSet.getInt("artist_id"));
        artist.setArtistName(rowSet.getString("artist_name"));
        artist.setArtistImage(rowSet.getString("artist_image"));
        artist.setDateOfBirth(rowSet.getDate("date_of_birth").toLocalDate());
        if(rowSet.getDate("date_of_death") != null)  {
            artist.setDateOfDeath(rowSet.getDate("date_of_death").toLocalDate());
        }

        return artist;
    }
    private Artist mapRowToArtistWithAlbum(SqlRowSet rowSet) {
        // Check if album data is null to avoid creating unnecessary album objects
        Artist artist = new Artist();
        artist.setArtistId(rowSet.getInt("artist_id"));
        artist.setArtistName(rowSet.getString("artist_name"));
        artist.setArtistImage(rowSet.getString("artist_image"));
        artist.setDateOfBirth(rowSet.getDate("date_of_birth").toLocalDate());
        if(rowSet.getDate("date_of_death") != null)  {
            artist.setDateOfDeath(rowSet.getDate("date_of_death").toLocalDate());
        }
        Album album = new Album();
        album.setAlbumId(rowSet.getInt("album_id"));
        album.setAlbumTitle(rowSet.getString("album_title"));
        album.setLabelName(rowSet.getString("label_id"));
        album.setDateReleased(rowSet.getDate("date_released").toLocalDate());
        album.setLengthInMin(rowSet.getInt("length_in_minutes"));
        album.setPrice(rowSet.getBigDecimal("price"));
        album.setImage(rowSet.getString("album_image"));

        // Set the album for the artist
        artist.setAlbum(album);
        return artist;
    }
}
