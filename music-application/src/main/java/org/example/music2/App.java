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
                    if (subMenuSelection == 1) {
                        // Display all albums //
                        AppService.searchAllAlbums();
                    } else if (subMenuSelection == 2) {
                        // Search albums by the album id //
                        while (true) {
                            AppService.displaySubAlbumMenu();
                            int subAlbumMenuSelection = promptForMenuSelection();
                            if (subAlbumMenuSelection == 1) {
                                AppService.searchAllAlbums();
                            } else if (subMenuSelection == 2) {

                            }
                        }
//                        AppService.displayAlbumsByAlbumId();
//                    } else if (subMenuSelection == 3) {
//                        // Search albums by the title //
//                        AppService.displayAlbumsByTitle();
//                    } else if (subMenuSelection == 4) {
//                        // Search albums by the artist id //
//                        AppService.displayAlbumsByArtistId();
//                    } else if (subMenuSelection == 5) {
//                        // Search albums by the label id //
//                        AppService.displayAlbumsByLabelId();
//                    } else if (subMenuSelection == 6) {
//                        // Search albums by year released //
//                        AppService.displayAlbumsByYear();
//                    } else if (subMenuSelection == 7) {
//                        // search albums by price //
//                        AppService.displayAlbumsByPrice();
//                    } else if (subMenuSelection == 9) {
//                        break;
                    }
                }
                // Artist Menu options //
            } else if (mainMenuSelection == 2) {
                while (true) {
                    // display the Artist menu //
                    AppService.displayArtistMenu();
                    int subMenuSelection = promptForMenuSelection();
                    if (subMenuSelection == 1) {
                        // Display all Artists //
                        AppService.displayAllArtists();
                    } if (subMenuSelection == 2) {
                        // Search artists by the Artist id //
                        AppService.displayArtistsById();
                    } else if (subMenuSelection == 3) {
                        // Search artists by the Artists name //
                        AppService.displayArtistsByName();
                    } else if(subMenuSelection == 4){
                        // search by date of birth //
                    } else if (subMenuSelection == 5) {
                        // search by date of death ?? //
                    } else if (subMenuSelection == 6) {
                        break;
                    }
                }
            } else if (mainMenuSelection == 3) {
                while (true) {
                    int subMenuSelection = promptForMenuSelection();
                    if (subMenuSelection == 1) {
                        // menu option 1
                    } else {
                        break;
                    }
                }
            } else if (mainMenuSelection == 4) {
                int subMenuSelection = promptForMenuSelection();
                if (subMenuSelection == 1) {
                    // menu option 1
                } else {
                    break;
                }
            } else if (mainMenuSelection == 5) {
                int subMenuSelection = promptForMenuSelection();
                if (subMenuSelection == 1) {
                    // menu option 1
                } else {
                    break;
                }
            } else if (mainMenuSelection == 6) {
                System.out.println("Goodbye :)");
                break;
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


