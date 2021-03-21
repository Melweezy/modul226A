import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Minesweeper {

    public static void main(String[] args) {
        int x;
        int y = -1;
        int xy;
        boolean move = false;
        BufferedReader input = null;

        Ausgabe.startTextausgeben();

        try {
            input = new BufferedReader(new InputStreamReader(System.in));
        } catch (Throwable e) {
            System.out.println("Input from console not possible. Program terminated.");
            System.exit(-1);
        }

        x = readInt(input);
        if(x<5) x=5; //deal with invalid entries
        if(x>10) x=10;

        System.out.print("Generating mine field...\n");
        Spielfeld minefield = new Spielfeld(x);
        x = -1;
        System.out.println("Done.\n");
        minefield.showField();

        while(!minefield.playerHasWon()) {
            //Enter move:
//            String moveCNN = "T41";
//            while (!move) {
//                boolean isCorrect = readMove(input);
//                if (isCorrect) {
//                    char action = move.charAt(0);
//                    xy = readInt(input);
//                    move = true;
//                } else {
//                    System.out.print("Please do a valid move.");
//                }
//            }

            while (x < 0 || x >= minefield.getSize()) {
                System.out.print("Please enter a valid column-number. (from 1 to " + minefield.getSize() + "): ");
                x = readInt(input) - 1;
            }
            while(y < 0 || y >= minefield.getSize()) {
                System.out.print("Please enter a valid row-number. (from 1 to " + minefield.getSize() + "): ");
                y = readInt(input) - 1;
            }
            if(!minefield.move(x, y)) {
                System.out.println("Bang bang, you're dead.");
                System.exit(0);
            }
            minefield.showField();
            x = -1;
            y = -1;
        }
        Ausgabe.schlussTextausgeben();
        System.exit(0);
    }

    public static int readInt(BufferedReader in) {
        try {
            return Integer.parseInt(in.readLine());
        } catch (Throwable e) {
            return -1;
        }
    }
//    public static boolean readMove(BufferedReader in){
//        try {
//            return true;
//        } catch (Throwable e) {
//            return false;
//        }
//    }
}
