public class Praktikant extends Mitarbeiter {

    public Praktikant() throws FirmaException {
        super();
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

}
