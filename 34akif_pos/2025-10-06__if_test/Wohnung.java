
public class Wohnung {

    private String adresse;
    private int groesse;
    private boolean balkon;
    private int anzahlZimmer;
    private double monatsMiete;

    public Wohnung() {
        setAdresse("Margarethenstraße 17, 1050 Wien");
        setGroesse(70);
        setBalkon(false);
        setAnzahlZimmer(3);
        setMonatsMiete(580.79);
    }

    public Wohnung(String adresse, int groesse, boolean balkon, int anzahlZimmer, double monatsMiete) {
        setAdresse(adresse);
        setGroesse(groesse);
        setBalkon(balkon);
        setAnzahlZimmer(anzahlZimmer);
        setMonatsMiete(monatsMiete);
    }

    public String getAdresse() {
        return this.adresse;
    }
    
    public void setAdresse(String adresse) {
        if (adresse != null && !adresse.equals("")) {
            this.adresse = adresse;
        } else {
            System.out.println("FEHLER: ungültige Adresse");
        }
    }

    public int getGroesse() { 
        return this.groesse;
    }
    
    public void setGroesse(int groesse) {
        if (groesse >= 30 && groesse <= 150) {
            this.groesse = groesse;
        } else {
            System.out.println("FEHLER: ungültige Größe");
        }
    }
    
    public int getAnzahlZimmer() {
        return this.anzahlZimmer;
    }
    
    public void setAnzahlZimmer(int anzahlZimmer) {
        if (anzahlZimmer >= 1 && anzahlZimmer <= 6) {
            this.anzahlZimmer = anzahlZimmer;
        } else {
            System.out.println("FEHLER: ungültige Anzahl an Zimmern");
        }
    }
    
    public double getMonatsMiete() {
        return this.monatsMiete;
    }
    
    public void setMonatsMiete(double monatsMiete) {
        if (monatsMiete >= 100 && monatsMiete <= 5000) {
            this.monatsMiete = monatsMiete;
        } else {
            System.out.println("FEHLER: ungültige Monatsmiete");
        }
    }
    
    public boolean hasBalkon() {
        return this.balkon;
    }
    
    public void setBalkon(boolean balkon) {
        this.balkon = balkon;
    }
    
    public void print() {
        if (hasBalkon()) {
            System.out.println("Wohnung: " + adresse + ", " + groesse + 
                               " m^2, " + anzahlZimmer + 
                               " Zimmer (mit Balkon), Monatsmiete: " + monatsMiete + 
                               " Euro");
        } else {
           System.out.println("Wohnung: " + adresse + ", " + groesse + 
                               " m^2, " + anzahlZimmer + 
                               " Zimmer, Monatsmiete: " + monatsMiete + 
                               " Euro");            
        }
    }
}
