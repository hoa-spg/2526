import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AngestellerTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void erstelleAngestellten() {
        try {
            Angesteller ang = new Angesteller("Peter", 1985, 25, 30, true);
            ang.print();
        } catch (FirmaException e) {
            System.out.println("FEHLER: " + e.getMessage());
        }

    }

    @Test
    void erstelleAngestelltenMitParameterlosemKonstruktor() {
        try {
            Angesteller ang = new Angesteller();
            ang.print();
        } catch (FirmaException e) {
            System.out.println("FEHLER: " + e.getMessage());
        }
    }

    @Test
    void testToString() {
        try {
            Angesteller a = new Angesteller("Bob", 1987, 45, 25, true);
            System.out.println(a);
        } catch (FirmaException e) {
            System.out.println("FEHLER: " + e.getMessage());
        }
    }

    @Test
    void erstelleAngestelltenMitUngueltigenParametern() {
        try {
            Angesteller ang = new Angesteller("", 1800, -10, -5, false);
            ang.print();
        } catch (FirmaException e) {
            System.out.println("FEHLER: " + e.getMessage());
        }
    }

    @Test
    void testGetKostenProMonat() {
        try {
            Angesteller ang = new Angesteller("Lisa", 1992, 25, 40, false);
            int kosten = ang.getKostenProMonat();
            System.out.println("Kosten pro Monat: " + kosten);
            assertTrue(kosten > 0);
        } catch (FirmaException e) {
            System.out.println("FEHLER: " + e.getMessage());
        }
    }

    @Test
    void testCsvString() {
        try {
            Angesteller a = new Angesteller("Clara", 1998, 35, 15, false);
            String csv = a.toCsvString();
            System.out.println(csv);
            assertEquals("Angestellter;Clara;1998;35;15;keine Überstundenpauschale", csv);
        } catch (FirmaException e) {
            System.out.println("FEHLER: " + e.getMessage());
        }
    }
}