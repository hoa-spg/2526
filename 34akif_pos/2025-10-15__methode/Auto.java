public class Auto {
    
    private String marke;
    private int kilometer;
    private boolean automatik;
    
    private double tankFuellstand; // l Benzin im Tank
    
    // Parameterloser Konstruktor
    public Auto() {
        setMarke("Mazda");
        setKilometer(10);
        setAutomatik(true);
        this.tankFuellstand = 10.0;
    }
    
    // Konstruktor mit Parametern
    public Auto(String marke, int kilometer, boolean automatik) {
        setMarke(marke);
        setKilometer(kilometer);
        setAutomatik(automatik);
        this.tankFuellstand = 10.0;
    }
    
    // Methoden
    public String getMarke() {
        return this.marke;
    }
    
    public void setMarke(String marke) {
        if (marke != null) { 
            this.marke = marke;
        } else {
            System.out.println("FEHLER: ungültige Marke!");
        }
    }
    
    public int getKilometer() {
        return this.kilometer;
    }
    
 
    public void setKilometer(int kilometer) {
        if (kilometer >= 0 && kilometer < 1_000_000) {
            this.kilometer = kilometer;
        } else {
            System.out.println("FEHLER: ungültige Kilometer");
        }
    }
    
    public boolean hasAutomatik() {
        return this.automatik;
    }
    
    public void setAutomatik(boolean automatik) {
        this.automatik = automatik;
    }
    
    public double getTankFuellstand() {
        return this.tankFuellstand;
    }
    
    /**
     * @parameter liter Anzahl an zu tankenden Litern
     * @returns tatsächlich getankte Liter
     */
    public double tanken(double liter) {
        if (liter > 0.0) {
            if (liter < 50.0 - this.tankFuellstand) {
                // if: weniger tanken, als noch in den Tank hinein geht
                // this.tankFuellstand = this.tankFuellstand + liter;
                this.tankFuellstand += liter;
                return liter;
            } else { 
                // else: volltanken
                double getankt = 50.0 - this.tankFuellstand;
                this.tankFuellstand = 50.0;
                return getankt;
            }
        } else {
            System.out.println("FEHLER: negativer Wert für getankte Liter");
            return -1.0; 
        }
    }
    
    public boolean fahren() {
        if (this.tankFuellstand > 1.0) {
            // this.tankFuellstand = this.tankFuellstand - 1.0;
            this.tankFuellstand -= 1.0;
            return true;
        } else {
            return false;
        }
    }
    
    public String toString() {
        String str = "Auto: ";
        if (automatik == true) { // if-Bedingung
            str += getMarke() + ", km: " + getKilometer() + " (Automatik)";
        } else {
            str += getMarke() + ", km: " + getKilometer() + " (Handschaltung)";
        }
        return str;
    }
    
    public void printAuto() {
        // System.out.println(this.toString());
        System.out.println(this);
    }
    
    
    
    
    
    
    
    
}