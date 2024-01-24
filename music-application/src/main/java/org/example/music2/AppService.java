package org.example.music2;

import org.apache.commons.dbcp2.BasicDataSource;
import org.example.music2.dao.Album.AlbumDao;
import org.example.music2.dao.Album.JdbcAlbumDao;
import org.example.music2.dao.Artist.ArtistDao;
import org.example.music2.dao.Artist.JdbcArtistDao;
import org.example.music2.model.Album;
import org.example.music2.model.Artist;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

@Component
public class AppService {

    private static final Scanner keyboard = new Scanner(System.in);

    // Album menu stuff //

    static void displayAlbumMenu(){
        System.out.println();
        System.out.println("1: Display All Albums");
        System.out.println("2: Search Albums By id ");
        System.out.println("3: Search Albums By Title");
        System.out.println("4: Search Albums By Artist id");
        System.out.println("5: Search Albums By Label id");
        System.out.println("6: Search Albums By Date Released");
        System.out.println("7: Search Albums by Price");
        System.out.println("9: Return to main Menu");
    }
    public static void displayAllAlbums() {
        AlbumDao albumDao = new JdbcAlbumDao(dataSource());
        List<Album> albums = albumDao.getAlbums();
        for (Album album : albums) {
            System.out.println(album + "\n");
        }
    }

    public static void displayAlbumById(int albumId){
        AlbumDao albumDao = new JdbcAlbumDao(dataSource());
        Album album = albumDao.getAlbumById(albumId);
        if (album != null && album.getAlbumId() != 0) {
            System.out.println(album + "\n");
        } else {
            System.out.println("No album found for the specified ID");
        }
    }
    public static void searchAlbumsByAlbumId(){
        AppService appService = new AppService();
        int albumId = Integer.parseInt(appService.promptForId());
        displayAlbumById(albumId);
    }
    public static void displayAlbumsByTitle(String stringSearch) {
        AlbumDao albumDao = new JdbcAlbumDao(dataSource());
        List<Album> albums = albumDao.getAlbums();
        if (!albums.isEmpty()) {
            for (Album album : albums) {
                if (album.getAlbumTitle().toLowerCase().contains(stringSearch.toLowerCase())) {
                    System.out.println(album);
                }
            }
        } else {
            System.out.println("No albums found");
        }
    }
    public static void searchAlbumsByTitle() {
        AppService appService = new AppService();
        String stringSearch = appService.promptForTitleString();
        displayAlbumsByTitle(stringSearch);
    }

    public static void displayAlbumsByArtistId(int artistId){
        AlbumDao albumDao = new JdbcAlbumDao(dataSource());
        List<Album> albums = albumDao.getAlbumByArtistId(artistId); // Correct method name
        if (!albums.isEmpty()) {
            for (Album album : albums) {
                System.out.println(album + "\n");
            }
        } else {
            System.out.println("No albums found for the specified artist ID");
        }
    }
    public static void searchAlbumsByArtistId(){
        AppService appService = new AppService();
        int artistId = Integer.parseInt(appService.promptForId());
        displayAlbumsByArtistId(artistId);
    }

    public static void displayAlbumsByLabelId(int labelId){
        AlbumDao albumDao = new JdbcAlbumDao(dataSource());
        List<Album> albums = albumDao.getAlbumsByLabelId(labelId);
        if (!albums.isEmpty()) {
            for (Album album : albums) {
                System.out.println(album + "\n");
            }
        } else {
            System.out.println("No albums found for the specified label ID");
        }
    }
    public static void searchAlbumsByLabelId(){
        AppService appService = new AppService();
        displayAlbumsByLabelId(Integer.parseInt(appService.promptForId()));
    }

    public static void displayAlbumsByYearReleased(LocalDate yearReleased){
        AlbumDao albumDao = new JdbcAlbumDao(dataSource());
        List<Album> albums = albumDao.getAlbumsByDateReleased(yearReleased);
        if (!albums.isEmpty()) {
            for(Album album: albums) {
                System.out.println(album + "\n");

            }
        } else {
            System.out.println("No albums found in this year");
        }
    }
    public static void searchAlbumsByYear(){
        AppService appService = new AppService();
        int year = Integer.parseInt(appService.promptForYear());
        displayAlbumsByYearReleased(LocalDate.of(year, 1, 1));
    }

    public static void displayAlbumsByPrice(BigDecimal price){
        AlbumDao albumDao = new JdbcAlbumDao(dataSource());
        List<Album> albums = albumDao.getAlbumsByPrice(price);
        if (!albums.isEmpty()) {
            for (Album album: albums) {
                System.out.println(album);
            }
        } else {
            System.out.println("No albums found in this price");
        }
    }
    public static void searchAlbumsByPrice(){
        AppService appService = new AppService();
        BigDecimal price = new BigDecimal(appService.promptForPrice());
        displayAlbumsByPrice(price);
    }

    static void displayArtistMenu(){
        System.out.println("1: Display All Artists");
        System.out.println("2: Search Artist By Artist id ");
        System.out.println("3: Search Artist By Name");
        System.out.println("4: Search Album By Date of Birth");
        System.out.println("5: Search By Date of Death");
        System.out.println("6: Exit");
    }

    public static void displayAllArtists(){
        ArtistDao artistDao = new JdbcArtistDao(dataSource());
        List<Artist> artists = artistDao.getArtists();
        for (Artist artist: artists) {
            System.out.println(artist + "\n");
        }
    }
    public static void displayArtistsByName(String stringSearch){
        ArtistDao artistDao = new JdbcArtistDao(dataSource());
        List<Artist> artists = artistDao.getArtists();
        if (!artists.isEmpty()) {
            for( Artist artist: artists) {
                if (artist.getArtistName().toLowerCase().contains(stringSearch.toLowerCase())) {
                    System.out.println(artist);
                }
            }
        } else {
            System.out.println("No artists found");
        }
    }
    public static void searchArtistsByName(){
        AppService appService = new AppService();
        String stringSearch = appService.promptForNameString();
        displayArtistsByName(stringSearch);
    }
    public static void displayArtistsById(int artistId){
        ArtistDao artistDao = new JdbcArtistDao(dataSource());
        Artist artist = artistDao.getArtistById(artistId);
        if (artist != null && artist.getArtistId()!= 0) {
            System.out.println(artist + "\n");
        } else {
            System.out.println("No album found for the specified ID");
        }
    }

    public static void searchArtistsById(){
        AppService appService = new AppService();
        int artistId = Integer.parseInt(appService.promptForId());
        displayArtistsById(artistId);
    }
    private static void promptForReturn() {
        System.out.println("Press RETURN to continue.");
        keyboard.nextLine();
    }
    private String promptForTitleString() {
        System.out.print("Enter Title: ");
        return keyboard.nextLine();
    }
    private String promptForNameString(){
        System.out.println("Enter Name: ");
        return keyboard.nextLine();
    }

    private String promptForId(){
        System.out.println("Enter id: ");
        return keyboard.nextLine();
    }

    private String promptForYear(){
        System.out.println("Enter Year (YYYY): ");
        return keyboard.nextLine();
    }
    private String promptForPrice() {
        System.out.println("Enter Price (PP.PP)");
        return keyboard.nextLine();
    }
    private static DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/musicDB");
        dataSource.setUsername("postgres");
        dataSource.setPassword("postgres1");
        return dataSource;
    }
}
