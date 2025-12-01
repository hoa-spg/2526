
public class Demo {
    
    public static void demo1() {
        System.out.println("Diese Methode kann direkt auf der Klasse aufgerufen werden.");
        System.out.println("Sie ist ein Teil der Klasse, und nicht des Objektes.");
    }
    
    /**
     * Methode erstellt einen String, der soviele Zeichen "*"
     * enthaelt, wie im Parameter laenge angegeben.
     * Beispiel: buildLine(3) --> "***"
     * 
     * parameter laenge = 3
     * pos = 0
     * while 0 < 3 -> schleife wird ausgefuehrt
     *      line += "*"  --> line == "*"
     *      pos++ --> pos == 1
     * 1 < 3 --> schleife wird ausgefuehrt
     *      line += "*"  --> line == "**"
     *      pos++ -> pos == 2
     * 2 < 3 -->  schleife wird ausgefuehrt 
     *      line += "* " --> line == "***"
     *      pos++ -> pos == 3
     * 3 < 3 --> ENDE DER SCHLEIFE
     */
    public static String buildLine(int laenge) {
        
        String line = null;
        if (laenge >= 0) {
            line = "";
            int pos = 0;
            while (pos < laenge) {
                line += "*";
                pos++; // pos += 1;
                
            }
            // line += "\n";
        } else {
            System.out.println("FEHLER: ungueltige Laenge");            
        }
        return line;
    }
    
    public static void zeichneLinie1(int laenge) {
        System.out.println(buildLine(laenge));
        
    }
    
    // Methode die alle Zahlen von 1 bis n ausgibt
    public static void printZahlenEinfach(int n) {
        if (n > 0) {
            int i = 0;
            while (i < n) {
                System.out.print(i + " ");
                i++;
            }
            System.out.println();
        } else {
            System.out.println("FEHLER: ungueltiger Wert n=" + n);
        }
    }
    
    public static void printZahlenVerbessert(int n) {
        if (n > 0) {
            int i = 0;
            while (i < n) {
                System.out.print(i);
                if (i < n-1) {
                    System.out.print(", ");
                }
                i++;
            }
            System.out.println();
        } else {
            System.out.println("FEHLER: ungueltiger Wert n=" + n);
        }            
    }    
    
    /**
     * Selbes Verhalten wie printZahlenEinfach, aber mit
     * for-Schleife statt while-Schleife umgesetzt.
     */
    public static void printZahlenEinfachMitForSchleife(int n) {
        if (n > 0) {

            // For-Schleife
            // for(x; y; z)
            // x: Deklaration und Initialisierung der Zählvariable: z.B. int i=0
            // y: Fortsetzungsbedinung z.B.: i<n
            // x: Modifikation der Zählvariable
            for (int i=0; i<n; i++) {
                System.out.print(i + " ");
            }
            System.out.println();
        } else {
            System.out.println("FEHLER: ungueltiger Wert n=" + n);
        }
    }    
}
