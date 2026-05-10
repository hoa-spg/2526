public class Angestellter extends Mitarbeiter {

    private boolean ueberstundenPauschale;

    public Angestellter() throws FirmaException {
        super();
        setUeberstundenPauschale(false);
    }

    // Angestellter;Alice;2001;45;25;Überstundenpaschale
    public Angestellter(String csv) throws FirmaException {
        super(csv);

        if (csv.startsWith("Angestellter")) {
            // Parameter: Regular Expression (Regulärer Ausdruck)
            String[] tokens = csv.split(";");
            if (tokens.length >= 6) {

                String usp = tokens[5];
                if (usp != null && usp.equals("Überstundenpaschale")) {
                    setUeberstundenPauschale(true);
                } else if (usp != null && usp.equals("keine Überstundenpauschale")) {
                    setUeberstundenPauschale(false);
                } else {
                    throw new FirmaException("Ungueltiger Wert für Überstundenpauschale: '" + usp + "'");
                }
            } else {
                throw new FirmaException("Ungueltige Anzahl an Tokens: " + csv);
            }
        } else {
            throw new FirmaException("Ungueltiger csv String, muss Wert 'Angestellter' in erster Spalte haben. csv: " + csv);
        }

    }

    public Angestellter(String name, int geburtsjahr, int stundenlohn,
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

    @Override
    public int getKostenProMonat() {
        int kosten = 4 * getStundenlohn() * getAnzahlWochenStunden();
        if (!hasUeberstundenPauschale()) {
            // Ueberstunden muessen extra bezahlt werden
            kosten += 5 * getStundenlohn();
        }
        return kosten;
    }

    @Override
    public String toCsvString() {
        return "Angestellter;" + super.toCsvString() + ";" +
                (hasUeberstundenPauschale() ? "Überstundenpaschale" : "keine Überstundenpauschale");
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
