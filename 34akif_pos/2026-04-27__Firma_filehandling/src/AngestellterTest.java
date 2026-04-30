import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AngestellterTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void erstelleAngestellten() {
        try {
            Angestellter ang = new Angestellter("Peter", 1985, 25, 30, true);
            ang.print();
        } catch (FirmaException e) {
            System.out.println("FEHLER: " + e.getMessage());
        }

    }

    @Test
    void erstelleAngestelltenMitParameterlosemKonstruktor() {
        try {
            Angestellter ang = new Angestellter();
            ang.print();
        } catch (FirmaException e) {
            System.out.println("FEHLER: " + e.getMessage());
        }
    }

    @Test
    void testToString() {
        try {
            Angestellter a = new Angestellter("Bob", 1987, 45, 25, true);
            System.out.println(a);
        } catch (FirmaException e) {
            System.out.println("FEHLER: " + e.getMessage());
        }
    }

    @Test
    void erstelleAngestelltenMitUngueltigenParametern() {
        try {
            Angestellter ang = new Angestellter("", 1800, -10, -5, false);
            ang.print();
        } catch (FirmaException e) {
            System.out.println("FEHLER: " + e.getMessage());
        }
    }

    @Test
    void testGetKostenProMonat() {
        try {
            Angestellter ang = new Angestellter("Lisa", 1992, 25, 40, false);
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
            Angestellter a = new Angestellter("Clara", 1998, 35, 15, false);
            String csv = a.toCsvString();
            System.out.println(csv);
            assertEquals("Angestellter;Clara;1998;35;15;keine Überstundenpauschale", csv);
        } catch (FirmaException e) {
            System.out.println("FEHLER: " + e.getMessage());
        }
    }

    @Test
    void erzeugeAngestelltenMitGueltigemCsvString() {
        String csv = "Angestellter;Alice;1999;45;25;Überstundenpaschale";
        try {
            Angestellter a = new Angestellter(csv);
            System.out.println(a);
        } catch (FirmaException fe) {
            fail("FEHLER: Exception wurde trotz gueltigem CSV-String geworfen.");
            System.out.println("FEHLER: " + fe.getMessage());
            fe.printStackTrace();
        }
    }

    @Test
    void erzeugeAngestelltenMitUngueltigemCsvString() {
        String csv = "Angestellter;Alice;neunzehnneunundneunzig;fuenfundvierzig Euro;25;Überstundenpaschale";
        // ..............................AAAAAAAAAAAAA...... ungueltiger Wert!
        try {
            Angestellter a = new Angestellter(csv);
            fail("FEHLER: Exception nicht wie erwartet geworfen!");
        } catch (FirmaException fe) {
            // System.out.println("FEHLER: " + fe.getMessage());
            fe.printStackTrace();
        }
    }
}