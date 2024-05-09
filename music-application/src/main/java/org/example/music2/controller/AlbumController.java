package org.example.music2.controller;

import org.example.music2.dao.Album.AlbumDao;
import org.example.music2.model.Album;
import org.example.music2.model.Artist;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.security.Principal;
import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/album")

public class AlbumController {

    private final AlbumDao albumDao;

    public AlbumController(AlbumDao albumDao) {
        this.albumDao = albumDao;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Album> getAlbums() {
        return albumDao.getAlbums();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Album getById(@PathVariable int id) {
        Album album = albumDao.getAlbumById(id);
        if (album == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Album Not Found");
        } else {
            return albumDao.getAlbumById(id);
        }
    }

    @RequestMapping(path = "/search", method = RequestMethod.GET)
    public List<Album> getByTitle(@RequestParam String title) {
        List<Album> albumsByTitle = albumDao.getAlbumByTitle(title);
        if (albumsByTitle.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No Albums Found with the given title");
        } else {
            return albumsByTitle;
        }
    }

    @RequestMapping(path = "/artist_id/{artistId}", method = RequestMethod.GET)
    public List<Album> getByArtistId(@PathVariable int artistId) {
        List<Album> albumsByArtist = albumDao.getAlbumByArtistId(artistId);
        if (albumsByArtist.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No Albums Found with the given artist id");
        } else {
            return albumsByArtist;
        }
    }

    @RequestMapping(path = "/labelId/{labelId}", method = RequestMethod.GET)
    public List<Album> getByLabelId(@PathVariable int labelId){
        List<Album> albumsByLabel = albumDao.getAlbumsByLabelId(labelId);
        if (albumsByLabel.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No Albums Found with the given label id");
        } else {
            return albumsByLabel;
        }
    }

    @RequestMapping(path = "/dateReleased/{year}", method = RequestMethod.GET)
    public List<Album> albumsByYear(@PathVariable LocalDate year){
        List<Album> albumsByYear = albumDao.getAlbumsByDateReleased(year);
        if (albumsByYear.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No Albums Found with the given year");
        } else {
            return albumsByYear;
        }
    }
    @RequestMapping(path = "/price/{price}", method = RequestMethod.GET)
    public List<Album> albumsByPrice(@PathVariable BigDecimal price){
        List<Album> albumsByPrice = albumDao.getAlbumsByPrice(price);
        if (albumsByPrice.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No Albums Found with the given price");
        } else {
            return albumsByPrice;
        }
    }

    @RequestMapping(path = "/genre/{id}", method = RequestMethod.GET)
    public List<Album> albumsByGenre(@PathVariable int id){
        List<Album> albumsByGenre = albumDao.getAlbumsByGenre(id);
        if (albumsByGenre.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No Albums Found with the given genre id");
        } else {
            return albumsByGenre;
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public Album createAlbum(@RequestBody Album album){
        return null;
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(path = "artistId/{id}", method = RequestMethod.DELETE)
    public void deleteAlbum(@PathVariable int id){
        albumDao.deleteAlbumById(id);
    }

}
