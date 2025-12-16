public class Sigma {

    private int groesse;
  
    public Sigma() {
        this.groesse = 9;
    }
    
    public Sigma(int groesse) {
        if (groesse > 0) {
            this.groesse = groesse;
        } else {
            System.out.println("FEHLER: ungueltige Groesse");
        }
    }

    public void zeichnen() {
        for (int i=0; i<groesse; i++) {
            System.out.print("x");
        }
        System.out.println();
        for (int i=1; i<groesse; i++) {
            for (int j=0; j<groesse; j++) {
                if (i == j) {
                    System.out.print("x");
                } else {
                    System.out.print(" ");
                }
            }    
            System.out.println();   
        }
        for (int i=2; i<groesse; i++) {
            for (int j=0; j<groesse; j++) {
                if (i == groesse - j) {
                    System.out.print("x");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        for (int i=0; i<groesse; i++) {
            System.out.print("x");
        }
        System.out.println();
    }
}
