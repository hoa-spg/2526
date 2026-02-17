import java.util.Random;

public class Wuerfel {

    private int augenzahl;
    private Random rnd;

    public Wuerfel() {
        this.augenzahl = 1;
        rnd = new Random();
    }

    public int wuerfeln() {
        augenzahl = 1 + rnd.nextInt(6);
        return augenzahl;
    }

    public int getAugenzahl() {
        return augenzahl;
    }


}
