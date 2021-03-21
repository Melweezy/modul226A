public class Konto {
    private double saldo, zinssatz;
    public Kunde inhaber;

public Konto(double saldo, double zinssatz, Kunde inhaber) {
        this.saldo = saldo;
        this.zinssatz = zinssatz;
        this.inhaber = inhaber;
    }

    public Konto (double saldo, String name, String vorname, int kundenNummer) {

        this.saldo = saldo;
        this.zinssatz = 0.5;
        this.inhaber = new Kunde(name, vorname, kundenNummer);
    }

    public double getSaldo(){
        return this.saldo;
    }

    public void einzahlen(double amount){
        if(amount > 0){
            this.saldo += amount;
        }

    }

    public void abheben(double amount){
        if(amount > 0 && this.saldo  >= amount + 2) {
            this.saldo -= amount;
            // Geld abheben kostet 2
            this.saldo -= 2;
        }
    }

    public void verzinsen(int tage){
        double zins = this.saldo * this.zinssatz / 365 * tage;
        if(this.saldo < 500000 && this.saldo > 50000) {
            this.saldo += zins / 2;
        }
        if (this.saldo < 50000){
            this.saldo += zins;
        }
    }
}
