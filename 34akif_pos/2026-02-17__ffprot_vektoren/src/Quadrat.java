public class Quadrat {



    private int seitenLaenge;

    public Quadrat(int seitenLaenge) {
        // 0) fehlerhaft, da keine Parameterpruefung
        // this.seitenLaenge = seitenLaenge;

        // 1) Parameterpruefung im Konstruktor
        //      - Code duplication
        //      - muss konsistent mit Set-Methode gehalten werden
//        if (seitenLaenge >= 0) {
//            this.seitenLaenge = seitenLaenge;
//        } else {
//            System.out.println("Fehler: ungueltige Seitenlaenge " + seitenLaenge);
//        }

        // 2) Code-re-use der Parameterpruefung der Set-Methode
        setSeitenLaenge(seitenLaenge);
    }

    public int getSeitenLaenge() {
        return seitenLaenge;
    }

    public void setSeitenLaenge(int seitenLaenge) {
        if (seitenLaenge >= 0) {
            this.seitenLaenge = seitenLaenge;
        } else {
            System.out.println("Fehler: ungueltige Seitenlaenge " + seitenLaenge);
        }
    }

    @Override
    public String toString() {
        return "Quadrat{" +
                "seitenLaenge=" + seitenLaenge +
                '}';
    }

    public void print() {
        System.out.println(this);
    }
}
