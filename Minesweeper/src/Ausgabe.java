public class Ausgabe {

    public static void startTextausgeben() {
        System.out.print("Welcome to Minesweeper!\nPlease enter desired field size (from 5 to 10): ");
    }

    public static void schlussTextausgeben() {
        System.out.println("You Win!");
    }

    public static void loseTextausgeben() {
        System.out.println("Bang bang, you're dead.");
    }

    public static void restartTextausgeben() {
        System.out.println("Restart?! - R: Restart anyKey: Exit");
    }
}

