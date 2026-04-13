import java.util.ArrayList;

public class Fuhrpark {
    private ArrayList<Fahrzeug> fahrzeuge;

    public Fuhrpark() {
        fahrzeuge = new ArrayList<>();
    }

    public void aufnehmen (Fahrzeug f) throws FuhrparkException {
        if (f != null) {
            if (f.getFuhrpark() != null && f.getFuhrpark() != this) {
                throw new FuhrparkException("ERROR: Fahrzeug befindet sich bereits in einem anderen Fuhrpark");
            }
            fahrzeuge.add(f);
            f.setFuhrpark(this);
        } else {
            throw new FuhrparkException("ERROR: Fahrzeug darf nicht Null sein");
        }
    }

    public int anzahlFahrzeuge() {
        return fahrzeuge.size();
    }

    public boolean istVorhanden(Fahrzeug f) throws FuhrparkException {
//        for (Fahrzeug other : fahrzeuge) {
//            if (other.equals(f)) {
//                return true;
//            }
//        }
        if (f != null) {
            return fahrzeuge.contains(f);
        } else {
            throw new FuhrparkException("Fehler: Fahrzeug ist null");
        }
    }

    public String toString() {
        String str = "Fuhrpark:";
        str += "\n==========\n";

        for (Fahrzeug f : fahrzeuge) {
            str += f.toString();
            str += "\n----------\n";
        }

        return str;
    }
}
