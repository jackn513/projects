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
            int mainMenuSelection = promptForMenuSelection("Please choose an option: ");
            if (mainMenuSelection == 1) {
                while (true) {
                    AppService.displayAlbumMenu();
                    int subMenuSelection = promptForMenuSelection("Please choose an option: ");
                    if (subMenuSelection == 1) {
                        AppService.displayAllAlbums();
                    } else if (subMenuSelection == 2) {
                        AppService.searchAlbumsByAlbumId();
                    } else if (subMenuSelection == 3) {
                        AppService.searchAlbumsByTitle();
                    } else if (subMenuSelection == 4) {
                        AppService.searchAlbumsByArtistId();
                    } else if (subMenuSelection == 5) {
                        AppService.searchAlbumsByLabelId();
                    } else if (subMenuSelection == 6) {
                        AppService.searchAlbumsByYear();
                    } else if (subMenuSelection == 7) {
                        AppService.searchAlbumsByPrice();
                    } else if (subMenuSelection == 9) {
                        break;
                    }
                }
            } else if (mainMenuSelection == 2) {
                while (true) {
                    AppService.displayArtistMenu();
                    int subMenuSelection = promptForMenuSelection("Please choose an option: ");
                    if (subMenuSelection == 1) {
                        AppService.displayAllArtists();
                    } if (subMenuSelection == 2) {
                        AppService.searchArtistsById();
                    } else if (subMenuSelection == 3) {
                        AppService.searchArtistsByName();
                    } else {
                        break;
                    }
                }
            } else if (mainMenuSelection == 3) {
                while (true) {
                    int subMenuSelection = promptForMenuSelection("Please choose an option: ");
                    if (subMenuSelection == 1) {
                        // menu option 1
                    } else {
                        break;
                    }
                }
            } else if (mainMenuSelection == 4) {
                int subMenuSelection = promptForMenuSelection("Please choose an option: ");
                if (subMenuSelection == 1) {
                    // menu option 1
                } else {
                    break;
                }
            } else if (mainMenuSelection == 5) {
                int subMenuSelection = promptForMenuSelection("Please choose an option: ");
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
    private int promptForMenuSelection(String prompt) {
        System.out.print(prompt);
        int menuSelection;
        try {
            menuSelection = Integer.parseInt(keyboard.nextLine());
        } catch (NumberFormatException e) {
            menuSelection = -1;
        }
        return menuSelection;
    }
}


