public class Auto {
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
    
}