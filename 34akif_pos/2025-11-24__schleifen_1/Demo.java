
public class Demo {
    
    public static void demo1() {
        System.out.println("Diese Methode kann direkt auf der Klasse aufgerufen werden.");
        System.out.println("Sie ist ein Teil der Klasse, und nicht des Objektes.");
    }
    
    public static String buildLine(int laenge) {
        
        String line = null;
        if (laenge >= 0) {
            line = "";
            int pos = 0;
            while (pos < laenge) {
                line += "*";
                pos++;
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
    public static void printZahlen(int n) {
        // 1. Version: n=10: 0 1 2 3 4 .... 9
        // 2. Version: 0, 1, 2, 3, 4, 5, 6, 7, 8, 9
    }
}
