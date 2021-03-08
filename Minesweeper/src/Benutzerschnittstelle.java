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

    public void zeigeSpielfeld(Board spielfeld) {
        return;
    }
    public void zeigeEingabeaufforderung() {
        return;
    }
    public void zeigeFehlermeldung() {
        return;
    }
    public void zeigeSchlussmeldung() {
        return;
    }


}