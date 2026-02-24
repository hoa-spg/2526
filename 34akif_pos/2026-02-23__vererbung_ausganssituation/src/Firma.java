import java.util.ArrayList;

public class Firma {

    private String name;

    private ArrayList<Arbeiter> personal;
    private ArrayList<Angesteller> personal2; /// .......???????????????????????

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

    public String toString() {
        String str = "Firma: " + getName() + "\n-----------------------------------------";
        // TODO
        return str;
    }

    public void einstellen(Arbeiter a) {
        // ...
    }

    public void einstellen(Angesteller a) {
        // ...
    }
}
