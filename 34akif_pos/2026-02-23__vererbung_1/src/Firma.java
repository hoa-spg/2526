import java.util.ArrayList;

public class Firma {

    private String name;

    private ArrayList<Mitarbeiter> personal;

    public Firma() {
        setName("n/a");
        personal = new ArrayList<>();
    }

    public Firma(String name) {
        setName(name);
        personal = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && !name.isEmpty()) {
            this.name = name;
        } else {
            System.out.println("Fehler: ungueltiger Name: " + name);
        }
    }

    public int anzahlMitarbeiter() {
        return personal.size();
    }
    public void einstellen(Mitarbeiter ma) {
        if (ma != null) {
            personal.add(ma);
        } else {
            System.out.println("Fehler: ungueltiger Parameter (null).");
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
