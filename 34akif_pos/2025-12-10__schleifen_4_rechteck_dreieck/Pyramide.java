
/*
     @
    @@@
   @@@@@
  @@@@@@@
  
  Schritt 1:
@
@@@
@@@@@
@@@@@@@
 */
public class Pyramide {

    private int hoehe;

    
    public Pyramide() {
        setHoehe(7);
    }
    
    public Pyramide(int hoehe) {
        setHoehe(hoehe);
    }    

    public void setHoehe(int hoehe) {
        if (hoehe > 0) {
            this.hoehe = hoehe;
        } else {
            System.out.println("FEHLER: ungueltige Hoehe");
        }
    }
    
    public void zeichnen() {
        // TODO
    }
}
