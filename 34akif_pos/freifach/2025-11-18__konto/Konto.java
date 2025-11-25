import java.util.Random;

class Konto {
    private String iban;
    private int ueberziehungsRahmen;
    private int saldo;

    public Konto() {
        setIban(generateIban());
        setUeberziehungsRahmen(1000);
        this.saldo = 0;
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
        if (ueberziehungsRahmen >= -this.saldo) {
            this.ueberziehungsRahmen = ueberziehungsRahmen;
        } else {
            System.out.println("FEHLER: ungueltiger Ueberziehungsrahmen");
        }
    }
    
    public void einzahlen(int betrag) {
        if (betrag > 0) {
            this.saldo += betrag;
        } else {
            System.out.println("FEHLER: ungueltiger Betrag: " + betrag);
        }
        
    }
    
    public boolean abbuchen(int betrag) {
        if (betrag > 0) {
            if (this.saldo - betrag >= -this.ueberziehungsRahmen) {
                this.saldo -= betrag;
                return true;
            } else {
                System.out.println("FEHLER: " + betrag + " kann nicht abgebucht werden. Rahmen ueberzogen");
                return false;
            }
        } else {
            System.out.println("FEHLER: ungueltiger Betrag: " + betrag);
            return false;
        } 
    }

    public int kontostand() {
        return saldo;
    }
    
    public static int runden(double wert) {
        int gerundet = (int)wert;
        wert -= gerundet;
        // Im Zweifel bei numerischen Ungenauigkeiten aufrunden.
        // Bei negativem Kontostand abrunden.
        if (Math.abs(wert) >= 0.48) {
            gerundet += wert > 0.0 ? 1 : -1;
        }
        return gerundet;
    }
    
    public void berechneZinsen(double zinssatz) {
        if (zinssatz >= 0.0 && zinssatz <= 0.2) {
            double tmp = (1.0+zinssatz)*this.saldo;
            // this.saldo = (int)(tmp);
            this.saldo = Konto.runden(tmp);
        } else {
            System.out.println("FEHLER: ungueltiger Zinssatz: " + zinssatz);
        }
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