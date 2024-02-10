package org.example.music2.controller;

import org.example.music2.dao.Artist.ArtistDao;
import org.example.music2.dao.Artist.JdbcArtistDao;
import org.example.music2.model.Artist;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.sql.DataSource;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("artist_info")
public class ArtistController {

    private final ArtistDao artistDao;
    public ArtistController(ArtistDao artistDao) {
        this.artistDao = artistDao;
    }

    @RequestMapping(method =RequestMethod.GET)
    public List<Artist> getArtists(Principal principal){
        return artistDao.getArtists();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Artist getByid(@PathVariable int id){
        Artist artist = artistDao.getArtistById(id);
        if(artist == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Artist Not Found");
        } else {
            return artist;
        }
    }
}
