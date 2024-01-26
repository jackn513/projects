package org.example.music2.dao.Album;

import org.example.music2.exception.DaoException;
import org.example.music2.model.Album;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JdbcAlbumDao implements AlbumDao {

    private final JdbcTemplate jdbcTemplate;
    public JdbcAlbumDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Album getAlbumById(int albumId) {
        Album album = null;
        String sql = "SELECT * FROM album " +
                "JOIN public.artist_info ON album.artist_id = artist_info.artist_id " +
                "JOIN label ON album.label_id = label.label_id  " +
                "WHERE album_id = ?";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, albumId);
            if (results.next()) {
                album = mapRowToAlbum(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return album;
    }

    @Override
    public List<Album> getAlbumByArtistId(int artistId) {
        List <Album> albums = new ArrayList<>();
        String sql = "SELECT * FROM album " +
                "JOIN public.artist_info ON album.artist_id = artist_info.artist_id " +
                "JOIN label ON album.label_id = label.label_id  " +
                "WHERE album.artist_id = ?";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, artistId);
            while (results.next()) {
                albums.add(mapRowToAlbum(results));
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return albums;
    }


    @Override
    public List<Album> getAlbumsByLabelId(int labelId) {
        List <Album> albums = new ArrayList<>();
        String sql = "SELECT * FROM album " +
                "JOIN public.artist_info ON album.artist_id = artist_info.artist_id " +
                "JOIN label ON album.label_id = label.label_id  " +
                "WHERE album.label_id = ?";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, labelId);
            while (results.next()) {
                albums.add(mapRowToAlbum(results));
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return albums;
    }

    @Override
    public List<Album> getAlbums() {
        List <Album> albums = new ArrayList<>();
        String sql =
                "SELECT * FROM album " +
                        "JOIN public.artist_info ON album.artist_id = artist_info.artist_id " +
                        "JOIN label ON album.label_id = label.label_id ;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while (results.next()) {
                albums.add(mapRowToAlbum(results));
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return albums;
    }

    @Override
    public List<Album> getAlbumsByDateReleased(LocalDate yearReleased) {
        List<Album> albums = new ArrayList<>();
        String sql = "SELECT * FROM album JOIN artist_info ON album.artist_id = artist_info.artist_id " +
                "JOIN label ON album.label_id = label.label_id " +
                "WHERE EXTRACT(YEAR FROM date_released) = ?;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, yearReleased.getYear());
            while (results.next()) {
                albums.add(mapRowToAlbum(results));
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return albums;
    }

    @Override
    public List<Album> getAlbumsByPrice(BigDecimal price) {
        List<Album> albums = new ArrayList<>();
        String sql = "SELECT * FROM album JOIN artist_info ON album.artist_id = artist_info.artist_id " +
                "JOIN label ON album.label_id = label.label_id " +
                "WHERE price = ?;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, price);
            while (results.next()) {
                albums.add(mapRowToAlbum(results));
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return albums;
    }





    @Override
    public Album updatedAlbum(Album updatedAlbum) {
        return null;
    }

    @Override
    public int deleteAlbumById(int AlbumId) {
        return 0;
    }

    private Album mapRowToAlbum(SqlRowSet rowSet){
        Album album = new Album();
        album.setAlbumId(rowSet.getInt("album_id"));
        album.setAlbumTitle(rowSet.getString("album_title"));
        album.setArtistId(rowSet.getInt("artist_id"));
        album.setArtistName(rowSet.getString("artist_name"));
        album.setLabelId(rowSet.getInt("label_id"));
        album.setLabelName(rowSet.getString("label_name"));
        album.setDateReleased(rowSet.getDate("date_released").toLocalDate());
        album.setLengthInMin(rowSet.getInt("length_in_minutes"));
        album.setPrice(rowSet.getBigDecimal("price"));
        return album;
    }

}
