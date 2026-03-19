public class Wohnung extends Immobilie {

    private boolean balkon;
    private int nummer;
    private int groesse;

    public Wohnung() throws ImmobilienException {
        super();
        setBalkon(true);
        setNummer(1);
        setGroesse(30);
    }

    public Wohnung(String adresse, int wert, boolean balkon, int nummer, int groesse) throws ImmobilienException {
        super(adresse, wert);
        setBalkon(balkon);
        setNummer(nummer);
        setGroesse(groesse);
    }

    public boolean isBalkon() {
        return balkon;
    }

    public void setBalkon(boolean balkon) {
        this.balkon = balkon;
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
        String str = "Wohnung " + super.toString() + ", ";
        str += balkon ? " mit Balkon" : "";
        str += " Nummer: " + nummer + ", Größe: " + groesse;
        return str;
    }

}
