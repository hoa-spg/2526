public class Arbeiter extends Mitarbeiter {

    private boolean facharbeiter;

    public Arbeiter() throws FirmaException {
        super();
        setFacharbeiter(false);
    }

    // Arbeiter;Bob;1995;35;40;Facharbeiter
    public Arbeiter(String csv) throws FirmaException {
        super(csv);

        if (csv.startsWith("Arbeiter")) {
            // Parameter: Regular Expression (Regulärer Ausdruck)
            String[] tokens = csv.split(";");
            if (tokens.length >= 6) {

                String fach = tokens[5];
                if (fach != null && fach.equals("Facharbeiter")) {
                    setFacharbeiter(true);
                } else if (fach != null && fach.equals("Hilfsarbeiter")) {
                    setFacharbeiter(false);
                } else {
                    throw new FirmaException("Ungueltiger Wert für Facharbeiter: '" + fach + "'");
                }
            } else {
                throw new FirmaException("Ungueltige Anzahl an Tokens: " + csv);
            }
        } else {
            throw new FirmaException("Ungueltiger csv String, muss Wert 'Arbeiter' in erster Spalte haben. csv: " + csv);
        }
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

    @Override
    public String toCsvString() {
        return "Arbeiter;" + super.toCsvString() + ";" + (isFacharbeiter() ? "Facharbeiter" : "Hilfsarbeiter");
    }

    public void print() {
        System.out.println(this);
    }
}
