
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
                line += " * ";
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
    public static void printZahlenWhile(int n) {
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
    
    public static void printZahlenDoWhile(int n) {
        if (n > 0) {
            int i = 0;
            do {
                System.out.print(i + " ");
                i++;
            } while (i < n);
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
    
    /**
     * 1) Parameter: start, ende -> Zahlen ausgeben (start < ende)
     *      - while, for, do - while
     * 2) Parameter: start, ende, inkrement (start < ende, inkrement > 0)
     *      - while, for, do - while
     * 3) Abwärtszählen: start, end (start > ende, Schritt jeweils 1)
     *      - while, for, do - while
     */
    
    public static void zahlenAusgebenWhile(int start, int ende, int inkrement) {
        if (inkrement > 0) {
            if (start < ende) {
                int i = start;
                while (i < ende) {
                    System.out.print(i + " ");
                    i += inkrement;
                }
                System.out.println();
            } else {
                System.out.println("FEHLER: start ist nicht kleiner als ende.");
            }
        } else {
            System.out.println("FEHLER: inkrement ist nicht größer als 0");
        }
    }
    
    public static void zahlenAusgebenDoWhile(int start, int ende, int inkrement) {
        if (inkrement > 0) {
            if (start < ende) {
                int i = start;
                do {
                    System.out.print(i + " ");
                    i += inkrement;
                } while (i < ende);
                System.out.println();
            } else {
                System.out.println("FEHLER: start ist nicht kleiner als ende.");
            }
        } else {
            System.out.println("FEHLER: inkrement ist nicht größer als 0");
        }            
    }
   
    public static void zahlenAusgebenFor(int start, int ende, int inkrement) {
        if (inkrement > 0) {
            if (start < ende) {
                for (int i=start; i<ende; i+=inkrement) {
                    System.out.print(i + " ");
                }
                System.out.println();
            } else {
                System.out.println("FEHLER: start ist nicht kleiner als ende.");
            }
        } else {
            System.out.println("FEHLER: inkrement ist nicht größer als 0");
        }            
    }    
    
    public static void zahlenAusgebenAbsteigend(int start, int ende) {
        if (start > ende) {
            for (int i=start; i>ende; i--) {
                System.out.print(i + " ");
            }
            System.out.println();
        } else {
            System.out.println("FEHLER: start ist nicht groesser als ende.");
        }          
    }      
    
    public static int sumNumbersOneTo(int n) {
        int summe = 0;
        for (int i=1; i<=n; i++) {
            summe += i;
        }
        return summe;
    }
    
    public static void zeichneRechteck(int hoehe, int breite) {
        for (int z=0; z<hoehe; z++) { // hoehe (zeilen)
            /*
            for (int s=0; s<breite; s++) {
                System.out.print(" * ");
            }
            System.out.println();
            */
            Demo.zeichneLinie1(breite); // Code re-use
        }
    }
    
    public static void zeichneQuadrat(int seitenLaenge) {
        Demo.zeichneRechteck(seitenLaenge, seitenLaenge);
    }
    
    /**
     * Aufgabe: zeichen Rechteck (mit 2 Schleifen), Rand anderes
     *          Zeichen als innerer Bereich.
     * 
     * 
     *   # # # # # # # # #
     *   # . . . . . . . #
     *   # . . . . . . . #
     *   # # # # # # # # #
     * 
     *
     */
    
}
