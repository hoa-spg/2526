

public class Demo {
    
    public void foo1() {
        String a = "abc";
        String b = "abc";
        System.out.println("a == b ? " + a.equals(b));
    }    
    
    public void foo2() {
        String a = "abc";
        String b = "abc";
        System.out.println("a == b ? " + (a == b));
    }
    
    public void foo3() {
        String a = "ab";
        a += "c"; // a = "abc"
        String b = "abc";
        System.out.println("a: " + a);
        System.out.println("b: " + b);
        System.out.println("a == b ? " + (a == b));
    }    
}
