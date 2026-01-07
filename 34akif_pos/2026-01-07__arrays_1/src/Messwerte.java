import java.util.Arrays;

public class Messwerte {

    private double[] werte = {3.3, 1.3, -3.2, -2.1, 0.1, -5.0, -6.2};

    public Messwerte() {
        System.out.println("Konstruktor Messwerte");
//        this.werte = new double[10];
//        werte[0] = 3.3;
//        werte[1] = 1.3;

    }

    public double durschnittsWert() {
        double sum = 0.0;
        if (werte.length > 0) {
            for (int i=0; i<werte.length; i++) {
                sum += werte[i];
            }
            return sum/werte.length;
        } else {
            System.out.println("Fehler: Durschnitt kann bei leerem Array nicht berechnet werden.");
            return 0.0;
        }
    }

    @Override
    public String toString() {
        String str = "Werte: ";
        for (int i=0; i<werte.length; i++) {
            str += werte[i] + ", ";
        }
        str += "\nDurschnitt: " + durschnittsWert();
        return str;
    }
}
