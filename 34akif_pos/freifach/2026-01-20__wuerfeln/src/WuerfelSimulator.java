public class WuerfelSimulator {

    private int anzahlIterationen;

    public WuerfelSimulator(int anzahlIterationen) {
        if (anzahlIterationen > 0) {
            this.anzahlIterationen = anzahlIterationen;
        } else {
            System.out.println("Fehler: ungueltige Anzahl an Iterationen.");
        }
    }

    public void startSimulation() {
        Wurf w = new Wurf();
        int anzahlDreierPasch = 0;
        for (int i=0; i<this.anzahlIterationen; i++) {
            w.wuerfeln();
            if (w.isDreierPasch()) {
                anzahlDreierPasch++;
            }
        }
        double relHaeufigkeit = (double)anzahlDreierPasch/anzahlIterationen;
        System.out.println("Ergebnis der Simulation: ");
        System.out.println("Anzahl 3er-Pasch: " + anzahlDreierPasch);
        System.out.println("Berechnete Wahrscheinlichkeit: " + (100*relHaeufigkeit) + "%");
    }
}
