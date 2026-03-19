public class Buero extends Einheit {
    private boolean geteilt;

    public Buero() {
        super();
        geteilt = false;
    }

    public Buero(String adresse, int wert, boolean geteilt, int nummer, int groesse) throws ImmobilienException {
        super(adresse, wert, nummer, groesse);
        this.geteilt = geteilt;
    }

    public boolean isGeteilt() {
        return geteilt;
    }

    public void setGeteilt(boolean geteilt) {
        this.geteilt = geteilt;
    }

    @Override
    public String toString() {
        return "Buero " + super.toString() + (geteilt ? " geteilt": "");
    }

}
