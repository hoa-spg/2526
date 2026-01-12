public class Messwerte {

    private int[] werte;
    private int anzahl;

    public Messwerte() {
        werte = new int[10];
        anzahl = 0;
    }

    public int getAnzahl() {
        return anzahl;
    }

    public int messwert(int index) {
        if (index >= 0 && index < werte.length) {
            return werte[index];
        } else {
            System.out.println("Fehler: ungueltiger Index!");
            return -1;
        }
    }

    public void messwertHinzufuegen(int wert) {
        if (anzahl < werte.length) {
            werte[anzahl++] = wert;
        } else {
            System.out.println("Fehler: Array schon voll!");
        }
    }

    public void wertLoeschen(int index) {
        if (index >= 0 && index < anzahl) {
            for (int i = index; i < anzahl - 1; i++) {
                werte[i] = werte[i + 1];
            }
            anzahl--;
        } else {
            System.out.println("Fehler, ungueltiger index " + index);
        }
    }

    public void wertEinfuegen(int index, int wert) {
        if (anzahl < werte.length) {
            if (index >= 0 && index <= anzahl) {
                for (int i=anzahl; i>index; i--) {
                    werte[i] = werte[i-1];
                }
                werte[index] = wert;
                anzahl++;
            } else {
                System.out.println("Fehler, ungueltiger index " + index);
            }
        } else {
            System.out.println("Fehler, kein Platz im Array vorhanden!");
        }
    }

    public String toString() {
        String str = "Messwerte: ";
        for (int i=0; i<anzahl; i++) {
            if (i != 0) {
                str += ", ";
            }
            str += werte[i];
        }
        return str;
    }
}
