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

public class AppService {

    private static final Scanner keyboard = new Scanner(System.in);

    // Album menu stuff //
    static void displayMainAlbumMenu(){
        System.out.println();
        System.out.println("1: Display All Albums");
        System.out.println("2: Search Albums");
        System.out.println("3: Delete Album");
        System.out.println("4: Return to Main Menu");
        System.out.println();
    }
    static void displaySubAlbumMenu(){
        System.out.println();
        System.out.println("1: Search By Album id");
        System.out.println("2: Search By Title");
        System.out.println("3: Search By Artist id");
        System.out.println("4: Search Albums By Label id");
        System.out.println("5: Search Albums By Date Released");
        System.out.println("6: Search Albums by Price");
        System.out.println("7: Return to main Menu");
        System.out.println();

    }
    // the "display" and search for the albums //
    public static void searchAllAlbums() {
        // calls to the jdbcAlbum Dao that connects to the datasource
        AlbumDao albumDao = new JdbcAlbumDao(dataSource());
        // creates a list of albums with the .getAlbums() method //
        List<Album> albums = albumDao.getAlbums();

        // loops through the list and prints the albums followed by a line break //
        for (Album album : albums) {
            System.out.println(album + "\n");
        }
    }
        // method for searching database by album id //
    public static void searchAlbumById(int albumId){
        // calls to the jdbcAlbum Dao that connects to the datasource //
        AlbumDao albumDao = new JdbcAlbumDao(dataSource());
        // creates a single album (bc the id is unique to the album) //
        Album album = albumDao.getAlbumById(albumId);

        // checks if the album isn't null and the id isn't zero and prints the album with a line break //
        if (album != null && album.getAlbumId() != 0) {
            System.out.println(album + "\n");

            // if the album is not found, this message is printed //
        } else {
            System.out.println("No album found for the specified ID");
        }
    }

    // the "display" and search for the albums by the album id //
    public static void displayAlbumsByAlbumId(){
        AppService appService = new AppService();
        int albumId = Integer.parseInt(appService.promptForId());
        searchAlbumById(albumId);
    }

    // method for searching database by album title //
    public static void searchAlbumsByTitle(String stringSearch) {
        // calls to the jdbcAlbum Dao that connects to the datasource //
        AlbumDao albumDao = new JdbcAlbumDao(dataSource());
        // creates an empty list of albums //
        List<Album> albums = albumDao.getAlbums();

        // checks to see if the list is empty //
        if (!albums.isEmpty()) {
            // again, a loop //
            for (Album album : albums) {
                // if the string search (what the user puts in //
                if (album.getAlbumTitle().toLowerCase().contains(stringSearch.toLowerCase())) {
                    System.out.println(album);
                }
            }
        } else {
            System.out.println("No albums found");
        }
    }
    public static void displayAlbumsByTitle() {
        AppService appService = new AppService();
        String stringSearch = appService.promptForTitleString();
        searchAlbumsByTitle(stringSearch);
    }

    public static void searchAlbumsByArtistId(int artistId){
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
    public static void displayAlbumsByArtistId(){
        AppService appService = new AppService();
        int artistId = Integer.parseInt(appService.promptForId());
        searchAlbumsByArtistId(artistId);
    }

    public static void searchAlbumsByLabelId(int labelId){
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
    public static void displayAlbumsByLabelId(){
        AppService appService = new AppService();
        searchAlbumsByLabelId(Integer.parseInt(appService.promptForId()));
    }

    public static void searchAlbumsByYearReleased(LocalDate yearReleased){
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
    public static void displayAlbumsByYear(){
        AppService appService = new AppService();
        int year = Integer.parseInt(appService.promptForYear());
        searchAlbumsByYearReleased(LocalDate.of(year, 1, 1));
    }

    public static void searchAlbumsByPrice(BigDecimal price){
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
    public static void displayAlbumsByPrice(){
        AppService appService = new AppService();
        BigDecimal price = new BigDecimal(appService.promptForPrice());
        searchAlbumsByPrice(price);
    }

    public static void displayArtistMenu(){
        System.out.println("1: Display All Artists");
        System.out.println("2: Search Artist");
        System.out.println("3: return to Main Menu");
        System.out.println();
    }

    public static void displaySubArtistMenu() {
        System.out.println();
        System.out.println("1: Search By id");
        System.out.println("2: Search By Name");
        System.out.println("3: Search By Date of Birth");
        System.out.println("4: Search by Date of Death");
        System.out.println();
    }

    public static void displayAllArtists(){
        ArtistDao artistDao = new JdbcArtistDao(dataSource());
        List<Artist> artists = artistDao.getArtists();
        for (Artist artist: artists) {
            System.out.println(artist + "\n");
        }
    }
    public static void searchArtistsByName(String stringSearch){
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
    public static void displayArtistsByName(){
        AppService appService = new AppService();
        String stringSearch = appService.promptForNameString();
        searchArtistsByName(stringSearch);
    }
    public static void searchArtistsById(int artistId){
        ArtistDao artistDao = new JdbcArtistDao(dataSource());
        Artist artist = artistDao.getArtistById(artistId);
        if (artist != null && artist.getArtistId()!= 0) {
            System.out.println(artist + "\n");
        } else {
            System.out.println("No album found for the specified ID");
        }
    }

    public static void displayArtistsByDateOfBirth(){
        AppService appService = new AppService();
        int startYear = Integer.parseInt(appService.promptForYear());
        int endYear = Integer.parseInt(appService.promptForYear());
        searchArtistsByDateOfBirth(LocalDate.of(startYear, 1, 1), LocalDate.of(endYear, 1, 1));
    }

    public static void searchArtistsByDateOfBirth(LocalDate startDate, LocalDate endDate){
        ArtistDao artistDao = new JdbcArtistDao(dataSource());
        List<Artist> artists = artistDao.getArtistsByDateOfBirth(startDate, endDate);
        if (!artists.isEmpty()) {
            for (Artist artist: artists) {
                System.out.println(artist + "\n");
            }
        } else {
            System.out.println("No artists born this year");
        }

    }

    public static void displayArtistsById(){
        AppService appService = new AppService();
        int artistId = Integer.parseInt(appService.promptForId());
        searchArtistsById(artistId);
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
