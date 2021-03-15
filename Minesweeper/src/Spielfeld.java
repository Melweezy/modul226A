import java.lang.reflect.Array;

public class Spielfeld {
    private int breiteSpielfeld = 8;
    private int laengeSpielfeld = 8;

    public void aufdecken(int spalte, int zeile) {

    }

    public void markieren(int spalte, int zeile) {
    }

    public void erstelleSpielfeld() {
        int[][] spielfeldArray = new int[breiteSpielfeld][laengeSpielfeld];
        System.out.print("  ");
        for (int col = 0; col < spielfeldArray.length; col++) {
            System.out.print(col + "  ");
        }
        System.out.println();
        for (int row = 0; row < spielfeldArray.length; row++) {
            System.out.println(row + " ");
        }
//        for (int row = 0; row < spielfeldArray.length; row++) {
//            System.out.print(row + 1 + " ");
//
//            for (int column = 0; column < spielfeldArray.length; column++) {
//                spielfeldArray[row][column] = 0;
//                System.out.print(spielfeldArray[row][column] + " ");
//            }
//            System.out.println();
//        }
//        System.out.print(" ");
    }
}
