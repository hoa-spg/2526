public abstract class Einheit extends Immobilie {

    private int nummer;
    private int groesse;

    public Einheit() {
        super();
        this.nummer = 1;
        this.groesse = 30;
    }

    public Einheit(String adresse, int wert, int nummer, int groesse) throws ImmobilienException {
        super(adresse, wert);
        setNummer(nummer);
        setGroesse(groesse);
    }

    public int getNummer() {
        return nummer;
    }

    public void setNummer(int nummer) throws ImmobilienException {
        if (nummer > 0) {
            this.nummer = nummer;
        } else {
            throw new ImmobilienException("Ungueltiger Parameter nummer: " + nummer);
        }
    }

    public int getGroesse() {
        return groesse;
    }

    public void setGroesse(int groesse) throws ImmobilienException {
        if (groesse > 0) {
            this.groesse = groesse;
        } else {
            throw new ImmobilienException("Ungueltiger Parameter groesse: " + groesse);
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", Nr. " + nummer + " (" + groesse + " m2)";
    }
}
