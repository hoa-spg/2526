import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class FahrzeugTest {

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.Test
    void demoEquals() {
        Fahrzeug f = new Fahrzeug();
        Fahrzeug f2 = new Fahrzeug();
        Auto a = new Auto();
        // deklarierte Typ / statischer Typ  ist Fahrzeug
        // dyamische Typ ist Auto
        Fahrzeug fz = new Auto();

        System.out.println("f instanceof Fahrzeug? " + (f instanceof Fahrzeug)); // true
        System.out.println("f instanceof Auto? " + (f instanceof Auto)); // false
        System.out.println("a instanceof Auto? " + (a instanceof Auto)); // true
        System.out.println("a instanceof Fahrzeug? " + (a instanceof Fahrzeug)); // true
        System.out.println("fz instanceof Auto? " + (fz instanceof Auto)); // true
        System.out.println("fz instanceof Fahrzeug? " + (fz instanceof Fahrzeug)); // true

        System.out.println("f.getClass() equals f.getClass()?" + (f.getClass() == f2.getClass())); // true
        System.out.println("a.getClass() equals f.getClass()?" + (a.getClass() == f.getClass())); // false
        System.out.println("fz.getClass() equals a.getClasS()? " + (fz.getClass() == a.getClass())); // true
        System.out.println("fz.getClass() equals f.getClasS()? " + (fz.getClass() == f.getClass())); // false
    }

    @org.junit.jupiter.api.Test
    void testToString() {
        Fahrzeug f = new Fahrzeug("Puch Maxi", LocalDate.of(1985, 03, 03), 5_000);
        System.out.println(f);
    }

    @Test
    void testToString2() {
        Fahrzeug a = new Auto("Ferrari",
                LocalDate.of(2005, 03, 15),
                120_000, false, false);
        System.out.println(a);
    }

}