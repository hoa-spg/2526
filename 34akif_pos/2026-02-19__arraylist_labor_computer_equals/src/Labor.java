import java.util.ArrayList;

public class Labor {

    private String name;

    private ArrayList<Computer> computer;

    public Labor() {
        setName("n/a");
        computer = new ArrayList<>();
    }

    public Labor(String name, int maxAnzahlComputer) {
        setName(name);
        computer = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && !name.isBlank()) {
            this.name = name;
        } else {
            System.out.println("Fehler: ungueltiger Name.");
        }
    }

    public Computer getComputer(int platz) {
        if (platz >= 0 && platz < computer.size()) {
            return computer.get(platz);
        } else {
            System.out.println("Fehler: ungueltiger Parameter platz " + platz);
            return null;
        }
    }

    /**
     * Diese Methode prüft auf Vorhandensein des Elements
     * mittels == oder equals explizit.
     * ==> contains (von ArrayList) prüft mittels equals Methode
     * Ist keine equals Methode vorhanden, wird == herangezogen
     */
//    public boolean vorhanden(Computer comp) {
//        boolean vorhanden = false;
//        if (comp != null) {
//            for (Computer c: computer) {
//                // if (c == comp) { // Prüfung auf Referenzgleichheit
//                if (c.equals(comp)) { // Prüfung auf Inhaltsgleichheit
//                    vorhanden = true;
//                    break; // steigt aus Schleife aus
//                }
//            }
//        } else {
//            System.out.println("Fehler: Parameter ist null");
//        }
//        return vorhanden;
//    }
    public boolean vorhanden(Computer comp) {
        if (comp != null) {
            return computer.contains(comp);
        } else {
            System.out.println("Fehler: Parameter computer ist null.");
        }
        return false;
    }

    public void hinzufuegen(Computer comp) {
        if (comp != null) {
            if (!vorhanden(comp)) {
                computer.add(comp);
            }
        } else {
            System.out.println("Fehler: ungueltiger Parameter (null).");
        }
    }

    public void einfuegen(int index, Computer comp) {
        if (comp != null) {
            if (index >= 0 && index <= computer.size()) {
                computer.add(index, comp);
            } else {
                System.out.println("Fehler: ungueltiger Index " + index);
            }
        } else {
            System.out.println("Fehler: ungueltiger Parameter (null).");
        }
    }

    public Computer entfernen(String name) {
        if (name != null) {
            // foreach
            Computer remove = null;
            for (Computer c : computer) {
                if (c.getName().equals(name)) {
                    remove = c;
                }
            }
            if (remove != null) {
                computer.remove(remove);
                return remove;
            }
        } else {
            System.out.println("Fehler: parameter name ist null.");
        }
        return null;
    }

    public Computer entfernen(int platz) {
        Computer ret = null;
        if (platz >= 0 && platz < computer.size()) {
            ret = computer.remove(platz);
        } else {
            System.out.println("Fehler: ungueltiger Index: " + platz);
        }
        return ret;
    }

    public boolean entfernen(Computer comp) {
        if (comp != null) {
            int index = computer.indexOf(comp);
            if (index >= 0) {
                return computer.remove(comp);
            }
        } else {
            System.out.println("Fehler: Parameter comp ist null.");
        }
        return false;
    }

    public int anzahlComputer() {
        return computer.size();
    }

    public int anzahlSSD() {
        int anzahl = 0;
        for (Computer c: computer) {
            if (c.hasSsd()) {
                anzahl++;
            }
        }
        return anzahl;
    }

    public double durchschnittlicherSpeicher() {
        int summeSpeicher = 0;

        for (Computer c: computer) {
            summeSpeicher += c.getSpeicher();
        }
        double durchschnittlicherSpeicher = 0.0;
        if (anzahlComputer() > 0) {
            durchschnittlicherSpeicher = (double)summeSpeicher / anzahlComputer();
        } else {
            System.out.println("Fehler: keine Computer vorhanden");
        }
        return durchschnittlicherSpeicher;
    }

    public String toString() {
        String str = "";
        str += "Labor: " + name + "\n";
        str += "---------------------------------------\n";
        for (int i=0; i<computer.size(); i++) {
            Computer c = computer.get(i);
            str += "Platz " + i + ": " + c + ", hashcode: " + c.hashCode() + "\n";
        }
        return str;
    }

    public void printLabor() {
        System.out.println(this);
    }
}
