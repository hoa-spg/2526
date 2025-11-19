import java.util.Random;

class Konto {
    private String iban;
    private int ueberziehungsRahmen;
    private int saldo;

    public Konto() {
        setIban(generateIban());
        setUeberziehungsRahmen(1000);
        this.saldo = saldo;
    }

    public Konto(String iban, int ueberziehungsRahmen, int saldo) {
        setIban(iban);
        setUeberziehungsRahmen(ueberziehungsRahmen);
        this.saldo = saldo;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        if (iban != null) {
            if (iban.length() == 20) {
                // Wie kann man pruefen ob die ersten beiden Zeichen Buchstaben sind,
                // und der Rest Ziffern
                this.iban = iban;
            } else {
                System.out.println("FEHLER: iban hat ungueltige Laenge");
            }
        } else {
            System.out.println("FEHLER: ungueltiger IBAN");
        }
    }

    public int getUeberziehungsRahmen() {
        return ueberziehungsRahmen;
    }

    public void setUeberziehungsRahmen(int ueberziehungsRahmen) {
        if (ueberziehungsRahmen >= 0) {
            this.ueberziehungsRahmen = ueberziehungsRahmen;
        } else {
            System.out.println("FEHLER: ungueltiger Ueberziehungsrahmen");
        }
    }

    public int getSaldo() {
        return saldo;
    }
    
    private String generateIban() {
        String iban = "";
        Random rnd = new Random();
        long ibanLong = 1000_0000_0000_0000L + Math.abs(rnd.nextLong());
        String ibanStr = "" + ibanLong;
        ibanStr = ibanStr.substring(0, 18);
        
        char c1 = (char)(65 + rnd.nextInt(25));
        char c2 = (char)(65 + rnd.nextInt(25));
        ibanStr = "" + c1 + c2 + ibanStr;
        return ibanStr;
    }

    public String toString() {
        return "Konto " + iban + " Saldo: " + saldo + " (UZ-Rahmen: " + ueberziehungsRahmen + ")";
    }

    public void print() {
        System.out.println(this);
    }
}