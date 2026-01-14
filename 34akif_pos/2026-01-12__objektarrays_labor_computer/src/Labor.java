public class Labor {

    private String name;

    private Computer[] computer;
    private int anzahl;

    public Labor() {
        setName("n/a");
        computer = new Computer[10];
        anzahl = 0;
    }

    public Labor(String name, int maxAnzahlComputer) {
        setName(name);
        computer = new Computer[maxAnzahlComputer];
        anzahl = 0;
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
        if (platz >= 0 && platz < anzahl) {
            return computer[platz];
        } else {
            System.out.println("Fehler: ungueltiger Parameter platz " + platz);
            return null;
        }
    }

    public void hinzufuegen(Computer comp) {
        if (comp != null) {
            if (anzahl < computer.length) {
                computer[anzahl++] = comp;
            } else {
                System.out.println("Fehler: kein Platz vorhanden!");
            }
        } else {
            System.out.println("Fehler: ungueltiger Parameter (null).");
        }
    }

    public void einfuegen(int platz, Computer comp) {
        if (comp != null) {
            if (anzahl < computer.length) {
                if (platz >= 0 && platz <= anzahl) {
                    for (int i=anzahl; i>platz; i--) {
                        computer[i] = computer[i-1];
                    }
                    computer[platz] = comp;
                    anzahl++;
                } else {
                    System.out.println("Fehler: ungueltiger Index " + anzahl);
                }
            } else {
                System.out.println("Fehler: kein Platz im Array vorhanden.");
            }
        } else {
            System.out.println("Fehler: ungueltiger Parameter (null).");
        }
    }

    public boolean vorhanden(Computer comp) {

        if (comp != null) {
            for (int i=0; i<anzahl; i++) {
                if (computer[i] == comp) {
                    return true;
                }
            }
        } else {
            System.out.println("Fehler: Parameter computer ist null.");
        }
        return false;
    }

    public Computer entfernen(String name) {
        if (name != null) {
            for (int i=0; i<anzahl; i++) {
                if (computer[i].getName().equals(name)) {
                    return entfernen(i);
                }
            }
        } else {
            System.out.println("Fehler: parameter name ist null.");
        }
        return null;
    }

    public Computer entfernen(int platz) {
        Computer ret = null;
        if (platz >= 0 && platz < anzahl) {
            ret = computer[platz];
            for (int i=platz; i<anzahl; i++) {
                computer[i] = computer[i+1];
            }
            anzahl--;
        }
        return ret;
    }

    public boolean entfernen(Computer comp) {
        return false; // TODO
    }

    public int anzahlComputer() {
        return anzahl;
    }

    public int anzahlSSD() {
        int anzahl = 0;
        // Vorsicht, potentieller Namenskonflikt mit this.anzahl!
        for (int i=0; i<this.anzahl; i++) {
            if (computer[i].hasSsd()) {
                anzahl++;
            }
        }
        return anzahl;
    }

    public double durchschnittlicherSpeicher() {
        int summeSpeicher = 0;
        for (int i=0; i<anzahl; i++) {
            summeSpeicher += computer[i].getSpeicher();
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
        for (int i=0; i<anzahl; i++) {
            str += "Platz " + i + ": " + computer[i] + "\n";
        }
        return str;
    }

    public void printLabor() {
        System.out.println(this);
    }
}
