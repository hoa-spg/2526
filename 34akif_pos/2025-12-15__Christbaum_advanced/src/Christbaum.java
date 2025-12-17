public class Christbaum {
    private int hoehe;
    private int anzahlAeste;
    public Christbaum() {
        setHoehe(15);
        setAnzahlAeste(6);
    }

    public Christbaum(int hoehe, int anzahlAeste) {
        setHoehe(hoehe);
        setAnzahlAeste(anzahlAeste);
    }

    public int getHoehe() {
        return hoehe;
    }

    public void setHoehe(int hoehe) {
        if (hoehe > 5) {
            this.hoehe = hoehe;
        } else {
            System.out.println("Fehler: ungueltige Hoehe " + hoehe);
        }
    }

    public void setAnzahlAeste(int anzahlAeste) {
        if (anzahlAeste > 0) {
            if (6*anzahlAeste < this.hoehe) {
                this.anzahlAeste = anzahlAeste;
            } else {
                System.out.println("FEHLER: anzahlAeste " + anzahlAeste + " nicht moeglich bei Hoehe " + hoehe);
            }
        } else {
            System.out.println("FEHLER: ungueltige Anzahl an Aesten");
        }
    }

    public void zeichnen(int offset) {
        if (anzahlAeste <= 0) {
            System.out.println("Zeichnen nicht moeglich, anzahlAeste " + anzahlAeste);
            return;
        }
        System.out.println("Christbaum: ");
        zeichneAeste(offset);
        zeichneStamm(offset);
    }

    private void zeichneAeste(int offset) {
        int baumBreite = 1;
        int astHoehe = (int) Math.ceil((double)this.hoehe / this.anzahlAeste);
        for (int i = 0; i < this.hoehe; i++) {
            if (i % astHoehe == 0) {
                baumBreite -= 6;
            }
            System.out.print(ZeichenTools.erzeugeLinie(offset, ' '));
            System.out.print(ZeichenTools.erzeugeLinie(this.hoehe - (baumBreite/2) - 1, ' '));
            System.out.println(ZeichenTools.erzeugeChristbaumLinie(baumBreite, 'x', 'O', 'i'));
            baumBreite += 2;
        }
    }

    private void zeichneStamm(int offset) {

        int stammRadius = 0;
        int stammHoehe = 1;
        if (this.hoehe >= 20) {
            stammRadius = 3;
            stammHoehe = 4;
        } else if (this.hoehe >= 15) {
            stammRadius = 2;
            stammHoehe = 3;
        } else if (this.hoehe >= 10) {
            stammRadius = 1;
            stammHoehe = 2;
        }


        for (int i = 0; i < stammHoehe; i++) {
            System.out.print(ZeichenTools.erzeugeLinie(offset, ' '));
            System.out.print(ZeichenTools.erzeugeLinie(this.hoehe - 1 - stammRadius, ' '));
            System.out.println(ZeichenTools.erzeugeLinie(1 + 2*stammRadius, '#'));
        }

    }

}
