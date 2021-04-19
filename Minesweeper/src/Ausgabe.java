public class Ausgabe {

    public static void startTextausgeben() {
        System.out.print("Welcome to Minesweeper!\nPlease enter desired field size (from 5 to 10): ");
    }

    public static void schlussTextausgeben() {
        System.out.print("\nYou Win!\nRestart?\nR/r: Restart\nanyKey: Exit\n");
    }

    public static void loseTextausgeben() {
        System.out.print("\nBang bang, you're dead.\n");
    }
}

