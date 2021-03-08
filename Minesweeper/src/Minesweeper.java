public class Minesweeper {
    private final Board spielfeld = new Board();
    private final Benutzerschnittstelle benutzerschnittstelle = new Benutzerschnittstelle();

    public static void main(String[] args) {
        Minesweeper minesweeper = new Minesweeper();
        minesweeper.spielen();
    }
    private void spielen() {
        spielfeld.erstelleSpielfeld();
        do {
            benutzerschnittstelle.zeigeSpielfeld(spielfeld);
            benutzerschnittstelle.zeigeEingabeaufforderung();
            Kommando kommando = benutzerschnittstelle.liesEingabe();
            kommando.ausfuehren(spielfeld);
        } while (spielLaeuft());
        benutzerschnittstelle.zeigeSpielfeld(spielfeld);
        benutzerschnittstelle.zeigeSchlussmeldung();
    }
    private boolean spielLaeuft() {
        return true;
    }
}