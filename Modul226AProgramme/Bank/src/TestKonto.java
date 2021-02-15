public class TestKonto {
    public static void main(String[] args) {
        Konto Konto1 = new Konto(100, "Meier", "Hans",1);

        System.out.println("Der Kunde " + Konto1.inhaber.getFullName() + " (" + Konto1.inhaber.getKundenNummer() +")" + " hat ein Konto.");
        Konto1.einzahlen(0);
        System.out.println("Der Saldo des Kontos ist: " + Konto1.getSaldo());
        Konto1.verzinsen(365);
        System.out.println("Der Saldo des Kontos ist: " + Konto1.getSaldo());

        Konto Konto2 = new Konto(500000.50, "Mister", "Sister",2);

        System.out.println("Der Kunde " + Konto2.inhaber.getFullName() + " (" + Konto2.inhaber.getKundenNummer() +")" + " hat ein Konto.");
        Konto2.einzahlen(0);
        System.out.println("Der Saldo des Kontos ist: " + Konto2.getSaldo());
        Konto2.verzinsen(365);
        System.out.println("Der Saldo des Kontos ist: " + Konto2.getSaldo());
    }
}
