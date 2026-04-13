public class Motorrad extends Fahrzeug {
    private boolean kleinMotorrad;

    public Motorrad(String bezeichnung, int ps, int gewicht, boolean kleinMotorrad) throws FuhrparkException {
        super(bezeichnung, ps, gewicht);
        setKleinMotorrad(kleinMotorrad);
    }

    public Motorrad() throws FuhrparkException {
        super();
        setKleinMotorrad(false);
    }

    public boolean isKleinMotorrad() {
        return kleinMotorrad;
    }

    public void setKleinMotorrad(boolean kleinMotorrad) {
        this.kleinMotorrad = kleinMotorrad;
    }

    @Override
    public int berechneSteuer() {
        int steuer = 0;

        if (this.kleinMotorrad) {
            steuer = 15;
        } else {
            steuer = 30;
        }

        return steuer;
    }

    public String toString() {
        String str = super.toString();
        str += "Kleinmotorrad: " + this.kleinMotorrad;
        return str;
    }
}
