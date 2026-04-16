import java.util.Objects;

public abstract class Fahrzeug {

    private String bezeichnung;
    private int ps;
    private int gewicht;
    private Fuhrpark fuhrpark;

    public Fahrzeug(String bezeichnung, int ps, int gewicht) throws FuhrparkException {
        setBezeichnung(bezeichnung);
        setPs(ps);
        setGewicht(gewicht);
    }

    public Fahrzeug() throws FuhrparkException {
        setBezeichnung("n/a");
        setPs(100);
        setGewicht(1000);
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) throws FuhrparkException {
        if (bezeichnung != null && !bezeichnung.isBlank()) {
            this.bezeichnung = bezeichnung;
        } else {
            throw new FuhrparkException("ERROR: Bezeichnung darf nicht Null oder leer sein");
        }
    }

    public int getPs() {
        return ps;
    }

    public void setPs(int ps) throws FuhrparkException {
        if (ps > 0) {
            this.ps = ps;
        } else {
            throw new FuhrparkException("ERROR: Jedes Fahrzeug muss mehr als 0 PS haben");
        }
    }

    public int getGewicht() {
        return gewicht;
    }

    public void setGewicht(int gewicht) throws FuhrparkException {
        if (gewicht > 0) {
            this.gewicht = gewicht;
        } else {
            throw new FuhrparkException("ERROR: Gewicht muss größer als 0 sein");
        }
    }

    public abstract int berechneSteuer();

    public Fuhrpark getFuhrpark() {
        return fuhrpark;
    }

    public void setFuhrpark(Fuhrpark fuhrpark) throws FuhrparkException {
        if (fuhrpark == null || (fuhrpark != null && fuhrpark.istVorhanden(this))) {
            this.fuhrpark = fuhrpark;
        } else {
            throw new FuhrparkException("Fehler: Fahrzeug ist nicht in diesem Fuhrpark vorhanden.");
        }
    }

    public double berechneVerbrauch() {
        double verbrauch = 3 * ((this.gewicht/1000.0)+(this.ps/100.0));
        return verbrauch;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Fahrzeug fahrzeug = (Fahrzeug) o;
        return ps == fahrzeug.ps && gewicht == fahrzeug.gewicht && Objects.equals(bezeichnung, fahrzeug.bezeichnung);
    }


    public String toString() {
        String str = "";
        str += "Bezeichnung: " + this.bezeichnung + "\n";
        str += "PS: " + this.ps + "\n";
        str += "Gewicht: " + this.gewicht + "\n";
        str += " (in Fuhrpark " + getFuhrpark().getName() + ") ";
        return str;
    }
}
