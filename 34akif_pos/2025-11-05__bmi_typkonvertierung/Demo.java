public class Demo {
    
    public void foo() {
        int a = 250;
        int b = 100;
        System.out.println("Division (ganzzahlig): " + (a/b));
        System.out.println("Rest: " + (a%b));
        
        float c = 250;
        int d = 100;
        System.out.println("Division: " + (c/d));
        
        int e = 250;
        int f = 100;
        // Typkonvertierung (Typecast)
        System.out.println("Division: " + ((float)e/f));        
    }
}
