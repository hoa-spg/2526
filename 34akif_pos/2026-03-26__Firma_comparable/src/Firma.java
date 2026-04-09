import java.util.*;

/**
 * Die Klasse {@code Firma} repräsentiert ein Unternehmen mit einem Namen
 * und einer Liste von Mitarbeitern.
 * <p>
 * Sie bietet Methoden zum Hinzufügen von Mitarbeitern, zur Berechnung
 * der monatlichen Gesamtkosten sowie zur Ausgabe der Firmendaten.
 * </p>
 *
 * @author HOA
 * @version 1.0
 */
public class Firma implements Printable {

    /** Name der Firma */
    private String name;

    /** Liste aller Mitarbeiter der Firma */
    private ArrayList<Mitarbeiter> personal;

    /**
     * Standardkonstruktor.
     * Initialisiert die Firma mit dem Namen "n/a" und einer leeren Mitarbeiterliste.
     *
     * @throws FirmaException wenn der Name ungültig ist
     */
    public Firma() throws FirmaException {
        setName("n/a");
        personal = new ArrayList<>();
    }


    /**
     * Konstruktor mit Namen.
     *
     * @param name Name der Firma
     * @throws FirmaException wenn der Name null oder leer ist
     */
    public Firma(String name) throws FirmaException {
        setName(name);
        personal = new ArrayList<>();
    }

    /**
     * Gibt den Namen der Firma zurück.
     *
     * @return Name der Firma
     */
    public String getName() {
        return name;
    }

    /**
     * Setzt den Namen der Firma.
     *
     * @param name neuer Firmenname
     * @throws FirmaException wenn der Name null oder leer ist
     */
    public void setName(String name) throws FirmaException {
        if (name != null && !name.isEmpty()) {
            this.name = name;
        } else {
            throw new FirmaException("Fehler: ungueltiger Name: " + name);
        }
    }

    /**
     * Gibt die Anzahl der Mitarbeiter zurück.
     *
     * @return Anzahl der Mitarbeiter
     */
    public int anzahlMitarbeiter() {
        return personal.size();
    }

    public boolean istVorhanden(Mitarbeiter m) throws FirmaException {
        if (m != null) {
            return this.personal.contains(m);
        } else {
            throw new FirmaException("Parameter Mitarbeiter ist null.");
        }

    }
    /**
     * Fügt einen neuen Mitarbeiter zur Firma hinzu.
     *
     * @param ma der hinzuzufügende Mitarbeiter
     * @throws FirmaException wenn der Mitarbeiter null ist
     */
    public void einstellen(Mitarbeiter ma) throws FirmaException {
        if (ma != null) {
            personal.add(ma);
        } else {
            throw new FirmaException("Fehler: ungueltiger Parameter (null).");
        }
    }

    /**
     * Berechnet die gesamten monatlichen Kosten aller Mitarbeiter.
     *
     * @return Summe der monatlichen Kosten
     */
    public int getKostenProMonat() {
        int kosten = 0;
        for (Mitarbeiter m : personal) {
            kosten += m.getKostenProMonat();
        }
        return kosten;
    }

    public List<Mitarbeiter> sortierteListe() {
        List<Mitarbeiter> sortiert = new LinkedList<>(personal);
        Collections.sort(sortiert);
        return sortiert;
    }

    /**
     * Gibt eine String-Repräsentation der Firma inklusive aller Mitarbeiter zurück.
     *
     * @return formatierter String mit Firmendaten
     */
    @Override
    public String toString() {
        String str = "Firma: " + getName() + "\n-----------------------------------------\n";
        for (Mitarbeiter ma : personal) {
            str += ma + "\n";
        }
        return str;
    }

    @Override
    public void print() {
        System.out.println(this);
    }
}