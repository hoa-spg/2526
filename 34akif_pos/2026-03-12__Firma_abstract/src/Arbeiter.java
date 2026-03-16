public class Arbeiter extends Mitarbeiter {

    private boolean facharbeiter;

    public Arbeiter() throws FirmaException {
        super();
        setFacharbeiter(false);
    }

    public Arbeiter(String name, int geburtsjahr, int stundenlohn,
                    int anzahlWochenStunden, boolean facharbeiter) throws FirmaException {
        super(name, geburtsjahr, stundenlohn, anzahlWochenStunden);
        setFacharbeiter(facharbeiter);
    }

    public boolean isFacharbeiter() {
        return facharbeiter;
    }

    public void setFacharbeiter(boolean facharbeiter) {
        this.facharbeiter = facharbeiter;
    }

    @Override
    public int getKostenProMonat() {
        int kosten = 4 * getStundenlohn() * getAnzahlWochenStunden();
        if (isFacharbeiter()) {
            kosten += 200; // Facharbeiterzuschlag
        }
        return kosten;
    }

    @Override
    public String toString() {
//        String str = getName() + " (Geb.Jahr: " + getGeburtsjahr() + ")";
//        str += " Stundenlohn: " + getStundenlohn() + ", " + getAnzahlWochenStunden() + " h/W";
        String str = super.toString();
        str += isFacharbeiter() ? " (Facharbeiter)" : " (Hilfsarbeiter)";
        return str;
    }

    public void print() {
        System.out.println(this);
    }
}
