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
    public Auto(String neueMarke, int neueKilometer, boolean neuAutomatik) {
        setMarke(neueMarke);
        setKilometer(neueKilometer);
        setAutomatik(neuAutomatik);
    }
    
    // Methoden
    public String getMarke() {
        return marke;
    }
    
    public void setMarke(String neueMarke) {
        marke = neueMarke;
    }
    
    public int getKilometer() {
        return kilometer;
    }
    
    public void setKilometer(int neueKilometer) {
        kilometer = neueKilometer;
    }
    
    public boolean getAutomatik() {
        return automatik;
    }
    
    public void setAutomatik(boolean neuAutomatik) {
        automatik = neuAutomatik;
    }
    
    public void printAuto() {
        // System.out.println("Auto: " + getMarke() + ", km: " + getKilometer());
        
        // Beispiele: Auto: Skoda, km: 23000 (Automatik)"
        //            Auto: Ferrari, km: 90000 (Handschaltung)"
        
        // Ideenskizze
        
        // Wenn Eigenschafte automatik true ist
        //    System.out.println(...."(Automatik)");
        // Sonst (automatik ist false)
        //    System.out.println(..."(Handschaltung)");
        
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