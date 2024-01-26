package org.example.music2;




import org.example.music2.model.*;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    private final Scanner keyboard = new Scanner(System.in);

    private List<Album> albums = new ArrayList<>();


    public static void main(String[] args) {
        App app = new App();
        app.run();
    }
    private void printMainMenu() {
//        System.out.println("1: Display data and subsets");
        System.out.println();
        System.out.println("1: Display Album Menu");
        System.out.println("2: Display Artist Menu");
        System.out.println("3: Display Customer Menu");
        System.out.println("4: Display Label Menu");
        System.out.println("5: Display Sales Menu");
        System.out.println("6: Exit");
        System.out.println();
    }

    private void run() {
        while (true) {
            // Main menu loop
            printMainMenu();
            int mainMenuSelection = promptForMenuSelection();
            // Album menu options //
            if (mainMenuSelection == 1) {
                while (true) {
                    // Display the album menu //
                    AppService.displayMainAlbumMenu();
                    int subMenuSelection = promptForMenuSelection();

                    // Album Menu options
                    if (subMenuSelection == 1) {
                        // Display all albums //
                        AppService.searchAllAlbums();
                    } else if (subMenuSelection == 2) {
                        while (true) {
                            AppService.displaySubAlbumMenu();
                            int subAlbumMenuSelection = promptForMenuSelection();
                            if (subAlbumMenuSelection == 1) {
                                AppService.displayAlbumsByAlbumId();
                            } else if (subAlbumMenuSelection == 2) {
                                AppService.displayAlbumsByTitle();
                            } else if (subAlbumMenuSelection == 3) {
                                AppService.displayAlbumsByArtistId();
                            } else if (subAlbumMenuSelection == 4) {
                                AppService.displayAlbumsByLabelId();
                            } else if (subAlbumMenuSelection == 5) {
                                AppService.displayAlbumsByYear();
                            } else if (subAlbumMenuSelection == 6) {
                                AppService.displayAlbumsByPrice();
                            } else if (subAlbumMenuSelection == 7) {
                                break;
                            }
                        }
                    } else if (subMenuSelection == 5) {
                        break;
                    }
                }
            }
        }
    }
    private int promptForMenuSelection() {
        System.out.print("Please choose an option: ");
        int menuSelection;
        try {
            menuSelection = Integer.parseInt(keyboard.nextLine());
        } catch (NumberFormatException e) {
            menuSelection = -1;
        }
        return menuSelection;
    }
}


