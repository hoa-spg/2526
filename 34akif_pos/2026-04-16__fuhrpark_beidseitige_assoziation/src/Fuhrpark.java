import java.util.ArrayList;

public class Fuhrpark {



    private String name;
    private ArrayList<Fahrzeug> fahrzeuge;


    public Fuhrpark(String name) throws FuhrparkException {
        setName(name);
        fahrzeuge = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws FuhrparkException {
        if (name != null && !name.isBlank()) {
            this.name = name;
        } else {
            throw new FuhrparkException("ERROR: ungueltiger Name");
        }
    }

    public void aufnehmen(Fahrzeug f) throws FuhrparkException {
        if (f != null) {
            if (f.getFuhrpark() == null) {
                fahrzeuge.add(f);
                f.setFuhrpark(this);
            } else {
                throw new FuhrparkException("ERROR: Fahrzeug befindet sich bereits in einem Fuhrpark");
            }

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
        String str = "Fuhrpark: " + getName();
        str += "\n==========\n";

        for (Fahrzeug f : fahrzeuge) {
            str += f.toString();
            str += "\n----------\n";
        }

        return str;
    }
}
