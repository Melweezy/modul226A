import java.util.Random;

public class Kunde {
    private String name, vorname;
    private int kundenNummer;


    public Kunde(String name, String vorname, int kundenNummer) {
        this.name = name;
        this.vorname = vorname;
        Random rnd = new Random();
        this.kundenNummer = kundenNummer;
    }
    public String getFullName() {
        return name + " " + vorname;
    }
    public int getKundenNummer() {
        return kundenNummer;
    }
}
