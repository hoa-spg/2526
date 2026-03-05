import java.time.LocalDate;

public class Motorrad extends Fahrzeug {

    private boolean kleinMotorrad;

    public Motorrad() {
        super();
        setKleinMotorrad(false);
    }

    public Motorrad(String bezeichnung, LocalDate erstZulassung,
                    int neupreis, boolean kleinMotorrad)
    {
        super(bezeichnung, erstZulassung, neupreis);
        setKleinMotorrad(kleinMotorrad);
    }

    public boolean isKleinMotorrad() {
        return kleinMotorrad;
    }

    public void setKleinMotorrad(boolean kleinMotorrad) {
        this.kleinMotorrad = kleinMotorrad;
    }

    @Override
    public String toString() {
        String str = "Motorrad: " + super.toString() + ", ";
        str += kleinMotorrad ? "Kleinmotorrad" : "Motorrad";
        return str;
    }

}
