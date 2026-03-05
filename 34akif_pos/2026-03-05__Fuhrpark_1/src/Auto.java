import java.time.LocalDate;

public class Auto extends Fahrzeug {

    private boolean diesel;
    private boolean automatik;

    public Auto() {
        super();
        setDiesel(false);
        setAutomatik(true);
    }

    public Auto(String bezeichnung, LocalDate erstZulassung,
                int neupreis, boolean diesel, boolean automatik)
    {
        super(bezeichnung, erstZulassung, neupreis);
        setDiesel(diesel);
        setAutomatik(automatik);
    }

    public boolean isDiesel() {
        return diesel;
    }

    public void setDiesel(boolean diesel) {
        this.diesel = diesel;
    }

    public boolean isAutomatik() {
        return automatik;
    }

    public void setAutomatik(boolean automatik) {
        this.automatik = automatik;
    }

    @Override
    public String toString() {
        String str = "Auto: " + super.toString() + ", ";
        str += diesel ? "Diesel, " : "Benzin, ";
        str += automatik ? "Automatik" : "Handschaltung";
        return str;
    }
}
