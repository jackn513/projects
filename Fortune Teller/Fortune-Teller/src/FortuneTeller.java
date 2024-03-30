import java.util.Arrays;
import java.util.Scanner;

public class FortuneTeller {
    private int one;
    private int two;
    private int three;

    public FortuneTeller() {

    }
    Scanner scanner = new Scanner(System.in);
    String[] fortunes = {
            "You really need a mint, honey.",
            "What if that thought you had is true?",
            "You will be very rich in the next coming years.",
            "Lol you thought this was real. Yea right.",
            "Now is a good time to buy those pants you really want.",
            "Go buy a plant.",
            "Don't forget to eat fruit.",
            "You're gonna need an umbrella tomorrow.",
            "You will be pleasantly surprised tonight.",
            "You will be traveling and coming into a fortune.",
    };


    void getName() {
        System.out.println("What's your first name?");
        String name = scanner.next();
        one = name.length();
    }

    void getSign() {
        System.out.println("How old are you?");
        String sign = scanner.next();
        two = sign.length();
    }

    void getColor() {
        System.out.println("What's your favorite color?");
        String artist = scanner.next();
        three = artist.length();
    }

    void askQuestions() {
        getName();
        getSign();
        getColor();
    }

    void tellFortune() {
        try {
            int result = one + two + three;
            result = result % fortunes.length;
            System.out.println(fortunes[result]);
        } catch (Exception e) {
            System.out.println("lol try again");
        }
    }
}
