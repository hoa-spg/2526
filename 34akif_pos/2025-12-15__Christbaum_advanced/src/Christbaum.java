public class Christbaum {
    private int hoehe;

    public Christbaum() {
        setHoehe(15);
    }

    public Christbaum(int hoehe) {
        setHoehe(hoehe);
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

    public void zeichnen(int offset) {
        System.out.println("Christbaum: ");
        zeichneAeste(offset);
        zeichneStamm(offset);
    }

    private void zeichneAeste(int offset) {
        int baumBreite = 1;
        for (int i = 0; i < this.hoehe; i++) {
            System.out.print(ZeichenTools.erzeugeLinie(offset, ' '));
            System.out.print(ZeichenTools.erzeugeLinie(this.hoehe - i - 1, ' '));
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
