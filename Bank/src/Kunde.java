import java.util.Random;

public class Kunde {
    private final String name, vorname;
    private final int kundenNummer;


    public Kunde(String name, String vorname, int kundenNummer) {
        this.name = name;
        this.vorname = vorname;
        this.kundenNummer = kundenNummer;
    }
    public String getFullName() {
        return name + " " + vorname;
    }

    public int getKundenNummer() {
        return kundenNummer;
    }
}
