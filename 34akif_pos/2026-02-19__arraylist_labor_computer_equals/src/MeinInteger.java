public class MeinInteger {




    private int wert;

    public MeinInteger(int wert) {
        this.wert = wert;
    }

    public int getWert() {
        return wert;
    }

    public void setWert(int wert) {
        this.wert = wert;
    }

    @Override
    public String toString() {
        return "" + wert;
    }
}
