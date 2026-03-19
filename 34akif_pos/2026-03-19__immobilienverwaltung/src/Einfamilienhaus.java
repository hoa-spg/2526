public class Einfamilienhaus extends Immobilie {

    private boolean pool;

    public Einfamilienhaus() {
        super();
        setPool(false);
    }

    public Einfamilienhaus(String adresse, int wert, boolean pool) throws ImmobilienException {
        super(adresse, wert);
        setPool(pool);
    }

    public boolean isPool() {
        return pool;
    }

    public void setPool(boolean pool) {
        this.pool = pool;
    }

    @Override
    public String toString() {
        String str = "Einfamilienhaus " + super.toString();
        str += pool ? ", mit Pool" : "";
        return str;
    }
}
