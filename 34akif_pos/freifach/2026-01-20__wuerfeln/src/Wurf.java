/**
 * asdfasdf
 */
public class Wurf {

    private Wuerfel w1;
    private Wuerfel w2;
    private Wuerfel w3;

    public Wurf() {
        w1 = new Wuerfel();
        w2 = new Wuerfel();
        w3 = new Wuerfel();
    }

    public void wuerfeln() {
        w1.wuerfeln();
        w2.wuerfeln();
        w3.wuerfeln();
    }

    public boolean isDreierPasch() {
        return w1.getAugenzahl() == w2.getAugenzahl() && w2.getAugenzahl() == w3.getAugenzahl();
    }
}
