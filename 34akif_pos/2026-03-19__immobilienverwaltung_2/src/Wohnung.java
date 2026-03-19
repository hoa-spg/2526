public class Wohnung extends Einheit {

    private boolean balkon;

    public Wohnung() throws ImmobilienException {
        super();
        setBalkon(true);
    }

    public Wohnung(String adresse, int wert, boolean balkon, int nummer, int groesse) throws ImmobilienException {
        super(adresse, wert, nummer, groesse);
        setBalkon(balkon);
    }

    public boolean isBalkon() {
        return balkon;
    }

    public void setBalkon(boolean balkon) {
        this.balkon = balkon;
    }

    @Override
    public String toString() {
        String str = "Wohnung " + super.toString() + ", ";
        str += balkon ? " mit Balkon" : "";
        return str;
    }

}
