public class Labor {

    private String name;

    private Computer[] computer;
    private int anzahl;

    public Labor() {
        setName("n/a");
        computer = new Computer[10];
        anzahl = 0;
    }

    public Labor(String name) {
        setName(name);
        computer = new Computer[10];
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
        // TODO
    }

    public boolean vorhanden(Computer comp) {
        // TODO
        return false;
    }

    public Computer entfernen(String name) {
        return null; // TODO
    }

    public Computer entfernen(int platz) {
        return null; // TODO
    }

    public boolean entfernen(Computer comp) {
        return false; // TODO
    }

    public int anzahlComputer() {
        return anzahl;
    }

    public int anzahlSSD() {
        return 0; // TODO
    }

    public double durchschnittlicherSpeicher() {
        return 0.0; // TODO
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
