
public class Quadrat {
    
    private int seitenLaenge;
    
    public Quadrat() {
        this.seitenLaenge = 13;
    }

    public Quadrat(int seitenLaenge) {
        setSeitenLaenge(seitenLaenge);
    }
    
    public void setSeitenLaenge(int seitenLaenge) {
        if (seitenLaenge > 0) {
            this.seitenLaenge = seitenLaenge;
        } else {
            System.out.println("FEHLER: ungueltige Laenge: " + seitenLaenge);
        }
    }
    
    public void zeichneQuadratMitRand() {
        for (int zeile = 0; zeile<seitenLaenge; zeile++) {
            for (int spalte = 0; spalte<seitenLaenge; spalte++) {
                // zeile schreiben
                if (zeile == 0 || zeile == seitenLaenge-1 || 
                    spalte == 0 || spalte == seitenLaenge-1) 
                { 
                    System.out.print(" # ");
                } else {
                    System.out.print(" . ");
                }
            }
            System.out.println();
        }
    }

    public void zeichneQuadratMitRandUndHauptDiagonale() {
        for (int zeile = 0; zeile<seitenLaenge; zeile++) {
            for (int spalte = 0; spalte<seitenLaenge; spalte++) {                
                if (zeile == 0 || zeile == seitenLaenge-1 || 
                    spalte == 0 || spalte == seitenLaenge-1) 
                { // Rand
                    System.out.print(" # ");
                } else if (zeile == spalte) { // Haupt-Diagonale 
                    System.out.print(" x ");
                } else {
                    System.out.print(" . ");
                }
            }
            System.out.println();
        }
    }
    
    public void zeichneQuadratMitRandUndNebenDiagonale() {
        for (int zeile = 0; zeile<seitenLaenge; zeile++) {
            for (int spalte = 0; spalte<seitenLaenge; spalte++) {
                if (zeile == 0 || zeile == seitenLaenge-1 || 
                    spalte == 0 || spalte == seitenLaenge-1) 
                { // Rand
                    System.out.print(" # ");
                } else if (zeile == seitenLaenge - 1 - spalte) { // Neben-Diagonale 
                    System.out.print(" x ");
                } else {
                    System.out.print(" . ");
                }
            }
            System.out.println();
        }
    }
    
    public void zeichneQuadrat(boolean hauptDiagonale, boolean nebenDiagonale,
                               char rand, char innen, char diagonale) 
    {
        for (int zeile = 0; zeile<seitenLaenge; zeile++) {
            for (int spalte = 0; spalte<seitenLaenge; spalte++) {
                if (zeile == 0 || zeile == seitenLaenge-1 || 
                    spalte == 0 || spalte == seitenLaenge-1) 
                { // Rand
                    System.out.print(" " + rand + " ");
                } else if (hauptDiagonale && zeile == spalte) {
                    System.out.print(" " + diagonale + " ");
                } else if (nebenDiagonale && zeile == seitenLaenge - 1 - spalte) {
                    System.out.print(" " + diagonale + " ");
                } else {
                    System.out.print(" " + innen + " ");
                }
            }
            System.out.println();
        }
    }
    
    public int getSeitenLaenge() {
        return this.seitenLaenge;
    }
    
    public String toString() {
        return "Quadrat mit Seitenlaenge: " + seitenLaenge;
    }
    
    public void print() {
        System.out.println(this);
    }
}
