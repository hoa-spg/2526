
public class Beamer {
    private boolean eingeschaltet;
    private String raum;
    private int restzeit; // wenn 0 -> kaputt
    
    public Beamer() {
        setRaum("C2.14");
        this.eingeschaltet = false;
        setRestzeit(50);
    }
    
    public Beamer(String raum, int restzeit) {
        setRaum(raum);
        setRestzeit(restzeit);
        this.eingeschaltet = false;
    }
    
    public boolean isEingeschaltet() { 
        return this.eingeschaltet;
    }
    
    public String getRaum() {
        return this.raum;
    }
    
    public void setRaum(String raum) {
        if (raum != null && !raum.isBlank()) {
            this.raum = raum;
        } else {
            System.out.println("FEHLER: ungueltiger Raum");
        }
    }
    
    public int getRestzeit() {
        return restzeit;
    }
    
    public void setRestzeit(int restzeit) {
        if (restzeit >= 0) {
            this.restzeit = restzeit;
        } else {
            System.out.println("FEHLER: ungueltige Restzeit: " + restzeit);
        }
    }
    
    public void einschalten() {
        if (!this.eingeschaltet) {
            if (this.restzeit > 0) {
                this.eingeschaltet = true;
                this.restzeit--;
                // this.restzeit = this.restzeit - 1;
                // this.restzeit -= 1;
            } else {
                System.out.println("Beamer ist kaputt, kann nicht eingeschaltet werden.");  
            }
        } else {
            System.out.println("Beamer ist schon eingeschaltet.");
        }
    }
    
    public void ausschalten() {
        if (this.eingeschaltet) {
            this.eingeschaltet = false;
        } else {
            System.out.println("Beamer ist nicht eingschaltet.");
        }
    }
    
    public void runterwerfen() {
        this.eingeschaltet = false;
        this.restzeit = 0;
        
    }
    
    public void reparieren() {
        if (!this.eingeschaltet && this.restzeit <= 5) {
            this.restzeit += 50;
        } else {
            System.out.println("Reparieren nicht moeglich");
        }
    }
    
    
    public String toString() {
        String str = "Beamer in Raum " + raum;
        if (this.eingeschaltet) {
            str += " (eingeschaltet)";
        } else {
            str += " (ausgeschaltet)";
        }
        str += ", Restzeit: " + this.restzeit + " h";
        if (this.restzeit == 0) {
            if (this.eingeschaltet) {
                str += ", Ende der Lebensdauer erreicht";
            } else {
                str += ", KAPUTT";
            }
        }
        return str;
    }
    
    public void print() {
        System.out.println(this);
    }
    
    
    
    
    
    
    
    
    
}

