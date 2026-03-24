public abstract class Mitarbeiter  {

    private String name;
    private int geburtsjahr;
    private int stundenlohn;
    private int anzahlWochenStunden;

    public Mitarbeiter() throws FirmaException {
        setName("n/a");
        setGeburtsjahr(1900);
        setStundenlohn(10);
        setAnzahlWochenStunden(40);
    }

    public Mitarbeiter(String name, int geburtsjahr, int stundenlohn,
                       int anzahlWochenStunden) throws FirmaException {
        setName(name);
        setGeburtsjahr(geburtsjahr);
        setStundenlohn(stundenlohn);
        setAnzahlWochenStunden(anzahlWochenStunden);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && !name.isEmpty()) {
            this.name = name;
        } else {
            System.out.println("Fehler: ungueltiger Name: " + name);
        }
    }

    public int getGeburtsjahr() {
        return geburtsjahr;
    }

    public void setGeburtsjahr(int geburtsjahr) throws FirmaException {
        if (geburtsjahr >= 1900 && geburtsjahr <= 2050) {
            this.geburtsjahr = geburtsjahr;
        } else {
            // Bug/Fehler
            // System.out.println("Fehler: ungueltiges Geburtsjahr: " + geburtsjahr);

            // Bugfix
            throw new FirmaException("Fehler: ungueltiges Geburtsjahr: " + geburtsjahr);
        }
    }

    public int getStundenlohn() {
        return stundenlohn;
    }

    public void setStundenlohn(int stundenlohn) throws FirmaException {
        if (stundenlohn > 7 && stundenlohn < 1000) {
            this.stundenlohn = stundenlohn;
        } else {
            throw new FirmaException("Fehler: ungueltiger Stundenlohn: " + stundenlohn);
        }
    }

    public int getAnzahlWochenStunden() {
        return anzahlWochenStunden;
    }

    public void setAnzahlWochenStunden(int anzahlWochenStunden) throws FirmaException {
        if (anzahlWochenStunden > 0 && anzahlWochenStunden <= 50) {
            this.anzahlWochenStunden = anzahlWochenStunden;
        } else {
            throw new FirmaException("Fehler: ungueltige Wochenstundenanzahl: " + anzahlWochenStunden);
        }
    }

    public abstract int getKostenProMonat();

    public String toString() {
        String str = "Name: " + getName() + " (" + getGeburtsjahr() + ")";
        str += ", Stundenlohn: " + getStundenlohn() + " Euro";
        str += ", Anzahl Wochenstunden: " + getAnzahlWochenStunden();
        str += ", Typ: " + this.getClass().getName();
        return str;
    }

}
