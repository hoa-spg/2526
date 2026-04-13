public class Auto extends Fahrzeug {
    private boolean automatik;

    public Auto(String bezeichnung, int ps, int gewicht, boolean automatik) throws FuhrparkException {
        super(bezeichnung, ps, gewicht);
        this.automatik = automatik;
    }

    public Auto() throws FuhrparkException {
        super();
        setAutomatik(false);
    }

    public boolean isAutomatik() {
        return automatik;
    }

    public void setAutomatik(boolean automatik) {
        this.automatik = automatik;
    }

    @Override
    public int berechneSteuer() {
        int steuer = 0;

        if (this.getPs() <= 50) {
            steuer = 50;
        } else {
            steuer = this.getPs();
        }

        return steuer;
    }

    @Override
    public double berechneVerbrauch() {
        double verbrauch = super.berechneVerbrauch();
        if (this.automatik) {
            verbrauch += 0.7;
        }
        return verbrauch;
    }

    public  String toString() {
        String str = super.toString();
        str += "Automatik: " + this.automatik;
        return str;
    }
}
