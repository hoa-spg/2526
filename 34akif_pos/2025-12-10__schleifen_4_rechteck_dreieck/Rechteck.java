
public class Rechteck {
    

    private int hoehe;
    private int breite;
    private int offset;
    
    private char rand;
    private char innen;
    
    public Rechteck() {
        setHoehe(7);
        setBreite(11);
        setOffset(5);
        setRand('#');
        setInnen('.');
    }
    
    public Rechteck(int hoehe, int breite, int offset) {
        setHoehe(hoehe);
        setBreite(breite);
        setOffset(offset);
    }
    
    public void setHoehe(int hoehe) {
        if (hoehe > 0) { 
            this.hoehe = hoehe;
        } else {
            System.out.println("FEHLER: ungueltige Hoehe!");
        }
    }
    
    public void setBreite(int breite) {
        if (breite > 0) { 
            this.breite = breite;
        } else {
            System.out.println("FEHLER: ungueltige Breite!");
        }
    } 
    
    public void setOffset(int offset) {
        if (offset > 0) { 
            this.offset = offset;
        } else {
            System.out.println("FEHLER: ungueltiger Offset!");
        }
    }      
    
    public void setRand(char rand) {
        this.rand = rand;
    }
    
    public void setInnen(char innen) {
        this.innen = innen;
    }
    
    
    public void zeichnen() {
        for (int h=0; h<this.hoehe; h++) {
            System.out.print(Rechteck.erzeugeLinie(this.offset, ' '));
            if (h == 0 || h == this.hoehe-1) {
                System.out.println(Rechteck.erzeugeLinie(this.breite, this.rand));
            } else {
                System.out.println(Rechteck.erzeugeLinie(this.breite, this.innen, this.rand));
            }
        }
    }
    
    private static String erzeugeLinie(int laenge, char zeichen) {
        return Rechteck.erzeugeLinie(laenge, zeichen, zeichen);
    }
    
    private static String erzeugeLinie(int laenge, char zeichen, char rand) {
        String str = "";
        for (int i=0; i<laenge; i++) {
            if (i == 0 || i == laenge-1) {
                str += " " + rand + " ";
            } else {
                str += " " + zeichen + " ";
            }
        }
        return str;
    }
    
    
    
    
    
    
}
