import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Minesweeper {

    public static void main(String[] args) throws IOException {
        int x;
        int y = -1;
        boolean action = false;
        boolean restart = false;
        BufferedReader input = null;

        while (!restart) {
            Ausgabe.startTextausgeben();

            try {
                input = new BufferedReader(new InputStreamReader(System.in));
            } catch (Throwable e) {
                System.out.println("Input from console not possible. Program terminated.");
                System.exit(-1);
            }

            x = readInt(input);
            if (x < 5) x = 5; //deal with invalid entries
            if (x > 10) x = 10;

            System.out.print("Generating mine field...\n");
            Spielfeld minefield = new Spielfeld(x);
            x = -1;
            System.out.println("Done.\n");
            minefield.showField();

            char actionChar = 'M';
            while (!minefield.playerHasWon()) {

                while (!action) {
                    System.out.print("Please enter a valid action. (M / H): ");
                    actionChar  = readChar(input) - 1;
                }

                while (x < 0 || x >= minefield.getSize()) {
                    System.out.print("Please enter a valid column-number. (from 1 to " + minefield.getSize() + "): ");
                    x = readInt(input) - 1;
                }
                while (y < 0 || y >= minefield.getSize()) {
                    System.out.print("Please enter a valid row-number. (from 1 to " + minefield.getSize() + "): ");
                    y = readInt(input) - 1;
                }
                if (!minefield.move(x, y)) {
                    System.out.println("Bang bang, you're dead.");
                    System.exit(0);
                }
                minefield.showField();
                x = -1;
                y = -1;
            }
            Ausgabe.schlussTextausgeben();

            System.out.println("Restart?! - R: Restart anyKey: Exit");

            if (!input.readLine().equals("R")) {
                restart = true;
            }
        }
        System.exit(0);
    }

    public static int readInt(BufferedReader in) {
        try {
            return Integer.parseInt(in.readLine());
        } catch (Throwable e) {
            return -1;
        }
    }

    public static char readChar(BufferedReader in) {
        try {
            return 'C';
        } catch (Throwable e) {
            return 'X';
        }
    }
}
