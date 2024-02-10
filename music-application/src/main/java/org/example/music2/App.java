package org.example.music2;




import org.example.music2.model.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
@SpringBootApplication
public class App {

    public static void main(String[] args){
        SpringApplication.run(App.class, args);
    }
//    private final Scanner keyboard = new Scanner(System.in);
//    public static void main(String[] args) {
//        App app = new App();
//        app.run();
//    }
//    private void printMainMenu() {
////        System.out.println("1: Display data and subsets");
//        System.out.println();
//        System.out.println("1: Display Album Menu");
//        System.out.println("2: Display Artist Menu");
//        System.out.println("3: Display Customer Menu");
//        System.out.println("4: Display Label Menu");
//        System.out.println("5: Display Sales Menu");
//        System.out.println("6: Exit");
//        System.out.println();
//    }
//
//    private void run() {
//        while (true) {
//            printMainMenu();
//            int mainMenuSelection = promptForMenuSelection();
//            if (mainMenuSelection == 1) {
//                handleAlbumMenu();
//            } else if (mainMenuSelection == 2) {
//                handleArtistMenu();
//            } else if (mainMenuSelection == 3) {
//                // handleCustomerMenu();
//            }
//        }
//    }
//
//    private void handleAlbumMenu() {
//        while (true) {
//            AppService.displayMainAlbumMenu();
//            int subMenuSelection = promptForMenuSelection();
//            if (subMenuSelection == 1) {
//                AppService.searchAllAlbums();
//            } else if (subMenuSelection == 2) {
//                handleSubAlbumMenu();
//            } else if (subMenuSelection == 3) {
//                handleDeleteAlbumMenu();
//            } else {
//                break;
//            }
//        }
//    }
//
//    private void handleSubAlbumMenu() {
//        while (true) {
//            AppService.displaySubAlbumMenu();
//            int subAlbumMenuSelection = promptForMenuSelection();
//
//            switch (subAlbumMenuSelection) {
//                case 1:
//                    AppService.displayAlbumsByAlbumId();
//                    break;
//                case 2:
//                    AppService.displayAlbumsByTitle();
//                    break;
//                case 3:
//                    AppService.displayAlbumsByArtistId();
//                    break;
//                case 4:
//                    AppService.displayAlbumsByLabelId();
//                    break;
//                case 5:
//                    AppService.displayAlbumsByYear();
//                    break;
//                case 6:
//                    AppService.displayAlbumsByPrice();
//                    break;
//                case 7:
//                    return;
//            }
//        }
//    }
//
//    private void handleDeleteAlbumMenu(){
//        AppService.displayDeleteAlbumById();
//    }
//
//    private void handleArtistMenu() {
//        while (true) {
//            AppService.displayArtistMenu();
//            int artistMenuSelection = promptForMenuSelection();
//
//            if (artistMenuSelection == 1) {
//                AppService.displayAllArtists();
//            } else if (artistMenuSelection == 2) {
//                handleSubArtistMenu();
//            } else if (artistMenuSelection == 3) {
//                break;
//            }
//        }
//    }
//
//    private void handleSubArtistMenu() {
//            while (true) {
//                AppService.displaySubArtistMenu();
//                int subArtistMenuSelection = promptForMenuSelection();
//
//                switch (subArtistMenuSelection) {
//                    case 1:
//                        AppService.displayArtistsById();
//                        break;
//                    case 2:
//                        AppService.displayArtistsByName();
//                        break;
//                    case 3:
//                        AppService.displayArtistsByDateOfBirth();
//                        break;
//                    case 4:
//                        /* handle date of death */
//                        break;
//                    case 5:
//                        return;
//                }
//            }
//    }
//    private int promptForMenuSelection() {
//        System.out.print("Please choose an option: ");
//        int menuSelection;
//        try {
//            menuSelection = Integer.parseInt(keyboard.nextLine());
//        } catch (NumberFormatException e) {
//            menuSelection = -1;
//        }
//        return menuSelection;
//    }
}


