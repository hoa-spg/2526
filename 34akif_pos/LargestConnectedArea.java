import java.util.*;

// VM-Argument um Stack-Groesse hinauf zu setzen: java -Xss3m LargestConnectedArea 
// Seitenweise Ausgabe (Linux-Terminal): java LargestConnectedArea 2>&1 | more


public class LargestConnectedArea {

    private static boolean[][] werte = {
                            {false,false,false,true,true,true,false,false,true,true,false,false},
                            {false,true,true,true,false,true,true,true,true,false,false,false},
                            {true,false,true,true,false,false,true,true,false,false,true,true},
                            {true,false,false,false,true,true,true,false,false,true,true,true},
                            {true,true,true,false,false,false,false,true,true,true,false,false},
                            {true,true,false,true,true,false,false,true,false,false,true,true},
                            {false,false,false,true,false,false,true,false,true,true,true,false},
                            {false,false,false,false,false,true,true,true,true,false,false,false}
                          };
                          
    private static boolean[][] visited;
    
    
    public static int dfs(int i, int j) {
        if (i < 0 || i >= werte.length || j < 0 || j >= werte[i].length) return 0;
        if (visited[i][j]) return 0;
        if (!werte[i][j]) return 0;
        
        visited[i][j] = true;
        int cnt = 1;
        
        if (i > 0)                 cnt += dfs(i-1, j); // nach oben
        if (j > 0)                 cnt += dfs(i, j-1); // nach links
        if (i+1 < werte.length)    cnt += dfs(i+1, j); // nach unten
        if (j+1 < werte[i].length) cnt += dfs(i, j+1); // nach rechts
        
        return cnt;
    }
    
    
    public static void randomInit() {
        Random rnd = new Random();
        werte = new boolean[300][300];
        for (int i=0; i<werte.length; i++) {
            for (int j=0; j<werte[i].length; j++) {
                // rnd.nextDouble liefert Zufallszahl 
                // zwischen 0 und 1
                if (rnd.nextDouble() < 2./3) {
                    werte[i][j] = true;
                }
            }
        }
    }
    
    // Schaetzung für P=1/3 true: 250 2000 20000 30000 15000 ==> ca. 50
    // Schaetzung für P=2/3 true: 150 95 100 70 2500
    
    public static void main(String[] args) {
    
        randomInit();
        
        visited = new boolean[werte.length][werte.length];
        for (int i=0; i<werte.length; i++) {
            visited[i] = new boolean[werte[i].length];
        }
        
        int max = 0;
        
        for (int i=0; i<werte.length; i++) {
            for (int j=0; j<werte[i].length; j++) {
                if (werte[i][j] && !visited[i][j]) {
                    int a = dfs(i, j);
                    if (a > max) max = a;
                }
            }
        }
        printWerte();
        System.out.println("Result: " + max);
        
    }
    
    public static void printWerte() {
        for (int i=0; i<werte.length; i++) {
            for (int j=0; j<werte[i].length; j++) {
                System.out.print(werte[i][j] ? "X" : ".");
            }
            System.out.println();
        }
    }
    
}
