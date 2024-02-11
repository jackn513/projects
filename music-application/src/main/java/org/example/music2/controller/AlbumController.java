package org.example.music2.controller;

import org.example.music2.dao.Album.AlbumDao;
import org.example.music2.model.Album;
import org.example.music2.model.Artist;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/album")
public class AlbumController {

    private final AlbumDao albumDao;

//            System.out.println();
//        System.out.println("1: Search By Album id"); X
//        System.out.println("2: Search By Title"); X
//        System.out.println("3: Search By Artist id");
//        System.out.println("4: Search Albums By Label id");
//        System.out.println("5: Search Albums By Date Released");
//        System.out.println("6: Search Albums by Price");
//        System.out.println("7: Return to main Menu");
//        System.out.println();

    public AlbumController(AlbumDao albumDao) {
        this.albumDao = albumDao;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Album> getAlbums(){
        return albumDao.getAlbums();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Album getById(@PathVariable int id){
        Album album = albumDao.getAlbumById(id);
        if (album == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Album Not Found");
        } else {
            return albumDao.getAlbumById(id);
        }
    }

    @RequestMapping(path = "/search", method = RequestMethod.GET)
    public List<Album> getByTitle(@RequestParam String title) {
        List<Album> albums = albumDao.getAlbumByTitle(title);
        if (albums.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No Albums Found with the given title");
        } else {
            return albums;
        }
    }

    @RequestMapping(path = "/artistId/{artistId}", method = RequestMethod.GET)
    public List<Album> getByArtistId(@PathVariable int artistId){
        List<Album> albums = albumDao.getAlbumByArtistId(artistId);
        if (albums.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No Albums Found with the given title");
        } else {
            return albums;
        }
    }


}
