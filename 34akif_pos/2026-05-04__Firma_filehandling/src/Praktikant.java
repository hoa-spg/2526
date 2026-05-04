public class Praktikant extends Mitarbeiter {

    public Praktikant() throws FirmaException {
        super();
    }

    // Praktikant;Charlie;2000;20;30
    public Praktikant(String csv) throws FirmaException {
        super(csv);

        if (csv.startsWith("Praktikant")) {
            // Parameter: Regular Expression (Regulärer Ausdruck)
            String[] tokens = csv.split(";");
            if (tokens.length < 5) {
                throw new FirmaException("Ungueltige Anzahl an Tokens: " + csv);
            }
        } else {
            throw new FirmaException("Ungueltiger csv String, muss Wert 'Praktikant' in erster Spalte haben. csv: " + csv);
        }
    }

    public Praktikant(String name, int geburtsjahr, int stundenlohn, int anzahlWochenStunden) throws FirmaException {
        super(name, geburtsjahr, stundenlohn, anzahlWochenStunden);
    }

    @Override
    public int getKostenProMonat() {
        return Math.min(getStundenlohn() * getAnzahlWochenStunden() * 4, 1000);
    }

    @Override
    public String toString() {
        return super.toString() + " (Praktikant)";
    }

    @Override
    public void print() {
        System.out.println(this);
    }

    @Override
    public String toCsvString() {
        return "Praktikant;" + super.toCsvString();
    }

}
