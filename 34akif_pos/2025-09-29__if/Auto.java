public class Auto {
    
    // (Objekt-)Eigenschaften
    // Attribute
    // Instanzvariablen
    private String marke;
    private int kilometer;
    private boolean automatik;
    
    // Parameterloser Konstruktor
    public Auto() {
        setMarke("Mazda");
        setKilometer(10);
        setAutomatik(true);
    }
    
    // Konstruktor mit Parametern
    public Auto(String marke, int kilometer, boolean automatik) {
        setMarke(marke);
        setKilometer(kilometer);
        setAutomatik(automatik);
    }
    
    // Methoden
    public String getMarke() {
        return this.marke;
    }
    
    public void setMarke(String marke) {
        // if (marke != "") { // FALSCH !!!!
        if (marke != null) { 
            this.marke = marke;
        } else {
            System.out.println("FEHLER: ungültige Marke!");
        }
    }
    
    public int getKilometer() {
        return this.kilometer;
    }
    
    /*
     * Vergleichsoperatoren
     * ==       Gleichheit
     * !=       Ungleichheit
     * <        Kleiner
     * <=       Kleiner/Gleich
     * >        Größer
     * >=       Größer/Gleich
     * Anmerkung: ! entspricht der Negation
     * !true == false
     * !false == true
     */
    public void setKilometer(int kilometer) {
        if (kilometer >= 0) {
            this.kilometer = kilometer;
        } else {
            System.out.println("FEHLER: ungültige Kilometer");
        }
    }
    
    public boolean getAutomatik() {
        return this.automatik;
    }
    
    public void setAutomatik(boolean automatik) {
        this.automatik = automatik;
    }
    
    public void printAuto() {
        if (automatik == true) { // if-Bedingung
            System.out.println("Auto: " + getMarke() + ", km: " + getKilometer() + " (Automatik)");
        } else {
            System.out.println("Auto: " + getMarke() + ", km: " + getKilometer() + " (Handschaltung)");
        }
        
        // Achtung !!!!!!!!!!!!!!!!
        // =  ... Zuweisung
        // == ... Vergleich
    }
    
    
    
    
    
    
    
    
}