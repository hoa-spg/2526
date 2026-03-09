import java.util.ArrayList;

public class Firma {

    private String name;

    private ArrayList<Mitarbeiter> personal;

    public Firma() throws FirmaException {
        setName("n/a");
        personal = new ArrayList<>();
    }

    public Firma(String name) throws FirmaException {
        setName(name);
        personal = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws FirmaException {
        if (name != null && !name.isEmpty()) {
            this.name = name;
        } else {
            throw new FirmaException("Fehler: ungueltiger Name: " + name);
        }
    }

    public int anzahlMitarbeiter() {
        return personal.size();
    }
    public void einstellen(Mitarbeiter ma) throws FirmaException {
        if (ma != null) {
            personal.add(ma);
        } else {
            throw new FirmaException("Fehler: ungueltiger Parameter (null).");
        }
    }

    public String toString() {
        String str = "Firma: " + getName() + "\n-----------------------------------------\n";
        for (Mitarbeiter ma : personal) {
            str += ma + "\n";
        }
        return str;
    }



}
