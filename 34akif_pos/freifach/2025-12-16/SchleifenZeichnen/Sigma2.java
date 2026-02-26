public class Sigma2 {

    private int groesse;
  
    public Sigma2() {
        this.groesse = 9;
    }
    
    public Sigma2(int groesse) {
        if (groesse > 0) {
            this.groesse = groesse;
        } else {
            System.out.println("FEHLER: ungueltige Groesse");
        }
    }

    public void zeichnen() {
        for (int i=0; i<groesse; i++) {
            for (int j=0; j<groesse; j++) {
                if (i == j || i == 0) {
                    System.out.print("x");
                } else {
                    System.out.print(" ");
                }
            }    
            System.out.println();   
        }
        for (int i=1; i<groesse; i++) {
            for (int j=0; j<groesse; j++) {
                if (i == groesse - 1 - j || i == groesse - 1) {
                    System.out.print("x");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

    }
}
