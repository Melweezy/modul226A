public class TestKonto {
    public static void main(String[] args) {
        /**
         * Konstruktor1 benutzen (K1 nimmt saldo, zinssatz und kunde-Objekt an)
         */
        Kunde meier = new Kunde("Hans", "Meier", 1);
        Konto kontoMeier = new Konto(100, 1, meier);

        System.out.println("Der Kunde " + kontoMeier.inhaber.getFullName() + " (" + kontoMeier.inhaber.getKundenNummer() +")" + " hat ein Konto.");
        kontoMeier.einzahlen(10);
        System.out.println("Der Saldo des Kontos ist: " + kontoMeier.getSaldo());
        kontoMeier.verzinsen(365);
        System.out.println("Der Saldo des Kontos ist: " + kontoMeier.getSaldo());

        /**
         * Konstruktor2 benutzen (K2 nimmt saldo, zinsatz, name, vorname, kundennummer an,
         * und generiert mit "this.inhaber = new Kunde(name,vorname,kundennummer) selber ein kunde-objekt)
         */
        Konto konto2 = new Konto(500000.50, "X", "Mr.",2);

        System.out.println("Der Kunde " + konto2.inhaber.getFullName() + " (" + konto2.inhaber.getKundenNummer() +")" + " hat ein Konto.");
        konto2.einzahlen(0);
        System.out.println("Der Saldo des Kontos ist: " + konto2.getSaldo());
        konto2.verzinsen(365);
        System.out.println("Der Saldo des Kontos ist: " + konto2.getSaldo());
    }
}
