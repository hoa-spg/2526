import java.util.ArrayList;

public class Fuhrpark {
    private String name;
    private ArrayList<Fahrzeug> fahrzeuge;

    public Fuhrpark() {
        setName("n/a");
    }

    public Fuhrpark(String name) {
        setName(name);
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

    public void aufnehmen(Fahrzeug fahrzeug) {
        if (fahrzeug != null) {
            if (!fahrzeuge.contains(fahrzeug)) {
                fahrzeuge.add(fahrzeug);
            } else {
                System.out.println("Fehler: derartiges Fahrzeug ist schon vorhanden.");
            }
        } else {
            System.out.println("Fehler: ungueltiges Fahrzeug (null)");
        }
    }
    @Override
    public String toString() {
        String str = name + "\n-----------------------\n";
        for (Fahrzeug f: fahrzeuge) {
            str += f + "\n";
        }
        str += "Fuhrpark enthält " + fahrzeuge.size() + " Fahrzeuge";
        return str;
    }

}
