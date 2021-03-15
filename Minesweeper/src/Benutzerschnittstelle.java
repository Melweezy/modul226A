import java.util.Scanner;

public class Benutzerschnittstelle {
    private final Scanner scanner = new Scanner(System.in);
    public Kommando liesEingabe() {
        do {
            String eingabe = scanner.nextLine();
            Validator validator = new Validator(eingabe);
            if (validator.istGueltig())
                return validator.erzeugeKommando();
            else
                zeigeFehlermeldung();
        } while (true);
    }

    public void zeigeSpielfeld(Spielfeld spielfeld) {
        return;
    }

    public void zeigeEingabeaufforderung() {
        System.out.println("Regeln: M = Markieren, T = Treffer. Erste Zahl = Reihe, Zweite Zahl = Spalte. \n T 2 1 oder M 2 5" );
    }

    public void zeigeFehlermeldung() {
        System.out.println("Keine korrekte Eingabe: \n z.B. T 5 6 (Treffer Zeile 5 Spalte 6) \n M 2 6 (Markieren Zeile 2 Spalte 6");
    }
    public void zeigeSchlussmeldung() {
        System.out.println("Alle Bombem markiert. Good job!");;
    }


}