import java.io.*;
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
public class Firma implements Printable, Serializable {

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

    public List<Mitarbeiter> sortierteListeKostenAbsteigend() {
        List<Mitarbeiter> sortiert = new LinkedList<>(personal);
        MitarbeiterKostenComparator mkc = new MitarbeiterKostenComparator();
        Collections.sort(sortiert, mkc);
        return sortiert.reversed();
    }

    /*
    public List<Mitarbeiter> sortierteListeMitarbeiterTypUndName() {
        List<Mitarbeiter> sortiert = new LinkedList<>(personal);

        Collections.sort(sortiert, new Comparator<Mitarbeiter>() {
            @Override
            public int compare(Mitarbeiter o1, Mitarbeiter o2) {
                if (o1 == null || o2 == null) {
                    throw new NullPointerException("Ungueltiger Mitarbeiter");
                }
                String t1 = o1.getClass().getName();
                String t2 = o2.getClass().getName();

                int comp = t1.compareTo(t2);
                if (comp == 0) {
                    comp = o1.getName().compareTo(o2.getName());
                }
                return comp;
            }
        });
        return sortiert;
    }
     */

    public List<Mitarbeiter> sortierteListeMitarbeiterTypUndName() {
        List<Mitarbeiter> sortiert = new LinkedList<>(personal);

        Collections.sort(sortiert,  (o1, o2) -> {
                if (o1 == null || o2 == null) {
                    throw new NullPointerException("Ungueltiger Mitarbeiter");
                }
                String t1 = o1.getClass().getName();
                String t2 = o2.getClass().getName();

                int comp = t1.compareTo(t2);
                if (comp == 0) {
                    comp = o1.getName().compareTo(o2.getName());
                }
                return comp;
            });
        return sortiert;
    }

    /*
    public List<Mitarbeiter> sortierteListeMitarbeiterNameAnzahlWochenstuden() {
        List<Mitarbeiter> sortiert = new LinkedList<>(personal);
        Collections.sort(sortiert, (m1, m2) -> {
            int comp = m1.getName().compareTo(m2.getName());
            if (comp == 0) {
                comp = m1.getAnzahlWochenStunden() - m2.getAnzahlWochenStunden();
            }
            return comp;
        });
        return sortiert;
    }
    */

    public List<Mitarbeiter> sortierteListeMitarbeiterNameAnzahlWochenstuden() {
        List<Mitarbeiter> sortiert = new LinkedList<>(personal);
        Collections.sort(sortiert, Comparator.comparing(Mitarbeiter::getName)
                                             .thenComparing(Mitarbeiter::getAnzahlWochenStunden));
        return sortiert;
    }

    public List<Mitarbeiter> sortierteListeAnzahlWochenstuden() {
        List<Mitarbeiter> sortiert = new LinkedList<>(personal);
        // Mit Comparator mit Methoden-Referenz
        // Collections.sort(sortiert, Comparator.comparing(Mitarbeiter::getAnzahlWochenStunden));

        // Mit Comparator und Lambda
        Collections.sort(sortiert, Comparator.comparing(m -> m.getAnzahlWochenStunden()));

        return sortiert;
    }

    public void serialize(String filename) throws FirmaException {
        if (filename != null && !filename.isBlank()) {
             try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
                 oos.writeObject(this);
                 // oos.close();
             } catch (FileNotFoundException e) {
                 throw new FirmaException("Fehler, Dateipfad ungültig. ", e);
             } catch (IOException e) {
                 throw new FirmaException("Fehler, Datei kann nicht geschrieben werden. ", e);
             }
        } else {
            throw new FirmaException("Fehler: ungueliger Dateiname");
        }
    }

    public static Firma deserialize(String filename) throws FirmaException {
        if (filename != null && !filename.isBlank()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
                Firma f = (Firma) ois.readObject();
                return f;
            } catch (FileNotFoundException e) {
                throw new FirmaException("Fehler, Datei nicht gefunden. ", e);
            } catch (IOException e) {
                throw new FirmaException("Fehler, Datei kann nicht geschrieben werden. ", e);
            } catch (ClassNotFoundException e) {
                throw new FirmaException("Fehler, Datei entspricht keiner Firma. ", e);
            } catch (Exception e) {
                throw new FirmaException("Unbekannter Fehler. ", e);
            }
        } else {
            throw new FirmaException("Fehler: ungueliger Dateiname");
        }
    }

    public void writeToFile(String filename) throws FirmaException {
        try (FileWriter fw = new FileWriter(filename);
            BufferedWriter bw = new BufferedWriter(fw))
        {
            bw.write(this.toCsvString());
        } catch (IOException e) {
            throw new FirmaException("Fehler beim Schreiben der Datei", e);
        }
    }

    public static Firma readFromFile(String filename) throws FirmaException {
        Firma f = null;
        try (FileReader fr = new FileReader(filename);
             BufferedReader br = new BufferedReader(fr))
        {

            String line = br.readLine();
            if (line != null && line.startsWith("Firma: ")) {
                f = new Firma(line.substring(7));
            }
            line = br.readLine();
            while (line != null) {
                if (line.startsWith("Angestellter")) {
                    f.einstellen(new Angestellter(line));
                } else if (line.startsWith("Arbeiter")) {
                    f.einstellen(new Arbeiter(line));
                } else if (line.startsWith("Praktikant")) {
                    f.einstellen(new Praktikant(line));
                } else {
                    throw new FirmaException("Ungueltige Zeile: " + line);
                }
                line = br.readLine();
            }
            return f;
        } catch (IOException e) {
            throw new FirmaException("Fehler beim Lesen der Datei", e);
        }
    }

    public String toCsvString() {
        String csv = "Firma: " + this.getName() + "\n";
        for (Mitarbeiter m : personal) {
            csv += m.toCsvString() + "\n";
        }
        return csv;
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