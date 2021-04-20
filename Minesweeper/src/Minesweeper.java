import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Minesweeper {

    public static void main(String[] args) {
        int x = -1;
        int y = -1;
        int size;
        char action = 'x';
        boolean restart = false;
        BufferedReader consoleInput;

        while (!restart) {
            Ausgabe.startTextausgeben();
            consoleInput = new BufferedReader(new InputStreamReader(System.in));

            size = Eingabe.readInt(consoleInput);
            if (size < 5) size = 5; //deal with invalid entries
            if (size > 10) size = 10;

            System.out.print("Generating mine field...\nDone\n");

            Spielfeld minefield = new Spielfeld(size);
            minefield.showField();

            while (!minefield.playerHasWon()) {
                while (action != 'f' && action != 'r') {
                    System.out.print("Please enter a valid action. 'f': Flag // 'r': Reveal ");
                    action = Eingabe.readChar(consoleInput);
                }
                while (x < 0 || x >= minefield.getSize()) {
                    System.out.print("Please enter a valid column-number. (from 1 to " + minefield.getSize() + "): ");
                    x = Eingabe.readInt(consoleInput) - 1;
                }
                while (y < 0 || y >= minefield.getSize()) {
                    System.out.print("Please enter a valid row-number. (from 1 to " + minefield.getSize() + "): ");
                    y = Eingabe.readInt(consoleInput) - 1;
                }
                if (!minefield.move(action, x, y)) {
                    Ausgabe.loseTextausgeben();
                    System.exit(0);
                }
                minefield.showField();
                x = -1;
                y = -1;
                action = 'x';
            }
            Ausgabe.schlussTextausgeben();
            if (Eingabe.readChar(consoleInput) != 'r') {
                restart = true;
            }
        }
        System.exit(0);
    }
}
