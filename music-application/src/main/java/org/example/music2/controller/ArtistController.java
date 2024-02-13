package org.example.music2.controller;

import org.example.music2.dao.Artist.ArtistDao;
import org.example.music2.model.Artist;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

;
import java.util.List;

@RestController
@RequestMapping("artist_info")
public class ArtistController {

    private final ArtistDao artistDao;
    public ArtistController(ArtistDao artistDao) {
        this.artistDao = artistDao;
    }

    @RequestMapping(method =RequestMethod.GET)
    public List<Artist> getArtists(){
        return artistDao.getArtists();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Artist getById(@PathVariable int id){
        Artist artist = artistDao.getArtistById(id);
        if(artist == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Artist Not Found");
        } else {
            return artist;
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    Artist createArtist(@RequestBody Artist artist){
        return artistDao.createArtist(artist);
    }
}
