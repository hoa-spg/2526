import java.util.ArrayList;

public class ImmobilienVerwaltung {

    private ArrayList<Immobilie> immobilien;

    public ImmobilienVerwaltung() {
        immobilien = new ArrayList<>();
    }

    public int anzahl() {
        return immobilien.size();
    }

    public boolean istVorhanden(Immobilie immobilie) throws ImmobilienException {
        if (immobilie != null) {
            return immobilien.contains(immobilie);
        } else {
            throw new ImmobilienException("Parameter immobilie ist null");
        }
    }

    public void hinzufuegen(Immobilie immobilie) throws ImmobilienException {
        if (immobilie != null) {
            immobilien.add(immobilie);
        } else {
            throw new ImmobilienException("Parameter immobilie ist null");
        }
    }

    public boolean entfernen(Immobilie immobilie) throws ImmobilienException {
        if (immobilie != null) {
            return immobilien.remove(immobilie);
        } else {
            throw new ImmobilienException("Parameter immobilie ist null");
        }
    }

    public int gesamtWert() {
        int ges = 0;
        for (Immobilie i : immobilien) {
            ges += i.gesamtWert();
        }
        return ges;
    }

    @Override
    public String toString() {
        String str = "Immobilienverwaltung \n----------------------------";
        for (Immobilie i : immobilien) {
            str += i + "\n";
        }
        return str;
    }
}
