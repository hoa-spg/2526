
/*              
   @       3
  @@@      2
 @@@@@     1
@@@@@@@    0
  
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
    
/*       hoehe=4
 
   @       3    h=0   hoehe-h-1
  @@@      2    h=1
 @@@@@     1    h=2
@@@@@@@    0    h=3
*/
    public void zeichnen() {
        int breite = 1;
        for (int h=0; h<hoehe; h++) {
            for (int l=0; l<hoehe-h-1; l++) {
                System.out.print("_");
            }
            for (int b=0; b<breite; b++) {
                System.out.print("*");
            }
            System.out.println();
            breite += 2;
        }
    }
}
