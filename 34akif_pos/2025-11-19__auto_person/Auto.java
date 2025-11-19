public class Auto {

    private String name = "n/a";
    private int eigengewicht = 1300;

    private Person fahrer;
    private Person beifahrer;
    private Person rueckbank;

    public Auto() {
        setName("n/a");
        setEigengewicht(1300);
    }

    public Auto(String name, int eigengewicht) {
        setName(name);
        setEigengewicht(eigengewicht);
    }

    public String getName() { 
        return name; 
    }

    public void setName(String name) {
        if (name != null && !name.isBlank()) {
            this.name = name;
        }
    }

    public int getEigengewicht() { 
        return eigengewicht; 
    }

    public void setEigengewicht(int eigengewicht) {
        if (eigengewicht >= 600 && eigengewicht <= 3000) {
            this.eigengewicht = eigengewicht;
        }
    }

    public Person getFahrer() {
        return fahrer;
    }
    
    public Person getBeifahrer() {
        return beifahrer;
    }
    
    public Person getRueckbank() {
        return rueckbank;
    }
    
    /**
     * Person steigt ein und bekommt den ersten freien Platz.
     * Fahrersitz nur für Personen mit Führerschein!
     * Wenn der erste Einsteiger keinen Führerschein hat → Beifahrersitz.
     */
    public void einsteigen(Person p) {
        if (p != null) {
            if (fahrer == null && p.hasFuehrerschein()) {
                fahrer = p;
            } else if (beifahrer == null) {
                beifahrer = p;
            } else if (rueckbank == null) {
                rueckbank = p;
            } else {
                System.out.println("FEHLER: Person kann nicht einsteigen.");
            }
        } else {
            System.out.println("FEHLER: ungueltige Person");
        }
    }

    public void aussteigen(Person p) {
        if (p != null) {
            if (fahrer == p) {
                fahrer = null;
            } else if (beifahrer == p) {
                beifahrer = null;
            } else if (rueckbank == p) {
                rueckbank = null;
            } else {
                System.out.println("Person nicht im Auto");
            }
        } else {
            System.out.println("FEHLER: ungueltige Person");
        }
    }

    public int gesamtGewicht() {
        int gesamt = eigengewicht;
        if (fahrer != null) {
            gesamt += fahrer.getGewicht();   
        }
        if (beifahrer != null) {
             gesamt += beifahrer.getGewicht();   
        }
        if (rueckbank != null) {
            gesamt += rueckbank.getGewicht();
        }
        return gesamt;
    }
    
    public boolean losfahren() {
        if (fahrer != null) {
            System.out.println("Auto fährt los! ;-) ");
            return true;
        } else {
            System.out.println("Auto kann nicht losfahren, kein Fahrer vorhanden! :(");
            return false;
        }
    }

    public void printFahrzeug() {
        System.out.printf("Auto: %s, Eigengewicht: %d kg%n", name, eigengewicht);
        System.out.println("-----------------------------------------------------------------");

        System.out.println("Fahrer: " + (fahrer == null ? "--frei--" : fahrer));
        System.out.println("Beifahrer: " + (beifahrer == null ? "--frei--" : beifahrer));
        System.out.println("Rueckbank: " + (rueckbank == null ? "--frei--" : rueckbank));

        System.out.println("-----------------------------------------------------------------");
    }

    public String toString() {
        return "Auto: " + name + ", Gesamtgewicht: " + gesamtGewicht();
    }
}
