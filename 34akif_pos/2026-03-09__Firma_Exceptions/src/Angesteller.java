public class Angesteller extends Mitarbeiter {

    private boolean ueberstundenPauschale;

    public Angesteller() throws FirmaException {
        super();
        setUeberstundenPauschale(false);
    }

    public Angesteller(String name, int geburtsjahr, int stundenlohn,
                       int anzahlWochenStunden,
                       boolean ueberstundenPauschale) throws FirmaException {
//        setName(name);
//        setGeburtsjahr(geburtsjahr);
//        setStundenlohn(stundenlohn);
//        setAnzahlWochenStunden(anzahlWochenStunden);

        // TODO Aufruf des Konstruktors der Basisklasse mit
        // den Parametern name, geburtsjahr, stundenlohn, und anzahlWochenStunden
        super(name, geburtsjahr, stundenlohn, anzahlWochenStunden);
        this.setUeberstundenPauschale(ueberstundenPauschale);
    }

    public boolean hasUeberstundenPauschale() {
        return ueberstundenPauschale;
    }

    public void setUeberstundenPauschale(boolean ueberstundenPauschale) {
        this.ueberstundenPauschale = ueberstundenPauschale;
    }

    public int getKostenProMonat() {
        int kosten = getStundenlohn() * getAnzahlWochenStunden();
        if (!hasUeberstundenPauschale()) {
            // Ueberstunden muessen extra bezahlt werden
            kosten += 5 * getStundenlohn();
        }
        return kosten;
    }

    @Override
    public String toString() {
//        String str = getName() + " (Geb.Jahr: " + getGeburtsjahr() + ")";
//        str += " Stundenlohn: " + getStundenlohn() + ", " + getAnzahlWochenStunden() + " h/W";
        String str = super.toString();
        str += hasUeberstundenPauschale() ? " (Ueberstundenpauschale)" : " (keine Uestd.-Pauschale)";
        return str;
    }

    public void print() {
        System.out.println(this);
    }



}
