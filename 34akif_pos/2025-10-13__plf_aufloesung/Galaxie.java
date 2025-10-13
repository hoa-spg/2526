
public class Galaxie {
    private String bezeichnung;
    private char typ;
    private double helligkeit;
    private int distanz;
    private boolean aktiv; 
    
    public Galaxie() {
        setBezeichnung("M31");
        setTyp('s');
        setHelligkeit(3.4);
        setDistanz(12345);
        setAktiv(true);
    }
    
    public Galaxie(String bezeichnung, char typ, double helligkeit, int distanz, boolean aktiv) {
        setBezeichnung(bezeichnung);
        setTyp(typ);
        setHelligkeit(helligkeit);
        setDistanz(distanz);
        setAktiv(aktiv);
    }
    
    public String getBezeichnung() {
        return bezeichnung;
    }
    
    public void setBezeichnung(String bezeichnung) {
        if (bezeichnung != null && !bezeichnung.equals("")) {
            this.bezeichnung = bezeichnung;
        } else {
            System.out.println("FEHLER: ungueltige bezeichnung");
        }
    }
    
    public char getTyp() { 
        return typ;
    } 
    
    public void setTyp(char typ) {
        if (typ == 's' || typ == 'e' || typ == 'i') {
            this.typ = typ;
        } else {
            System.out.println("FEHLER: ungueltiger Typ");
        }
    }
    
    public double getHelligkeit() {
        return helligkeit;
    }
    
    public void setHelligkeit(double helligkeit) {
        if (helligkeit >= -1.0 && helligkeit <= 32.0) {
            this.helligkeit = helligkeit;
        } else {
            System.out.println("FEHLER: ungueltige Helligkeit");
        }
    }
    
    public int getDistanz() {
        return distanz;
    }
    
    public void setDistanz(int distanz) {
        if (distanz >= 10 && distanz <= 100_000) {
            this.distanz = distanz;
        } else {
            System.out.println("FEHLER: ungueltige Distanz");
        }
    }

    public boolean isAktiv() {
        return aktiv;
    }
    
    public void setAktiv(boolean aktiv) {
        this.aktiv = aktiv;
    }
    
    public void print() {
        if (isAktiv()) {
            System.out.println(bezeichnung + " (" + typ + "), Helligkeit: " + this.helligkeit + " mag, Distanz: " + distanz + " kly, aktiver Kern");
        } else {
            System.out.println(bezeichnung + " (" + typ + "), Helligkeit: " + helligkeit + " mag, Distanz: " + distanz + " kly, nicht aktiv ");
        }
    }
}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
