import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArbeiterTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void erstelleArbeiterMitAllenParametern() {
        try {
            Arbeiter a = new Arbeiter("Max", 1990, 20, 40, true);
            System.out.println(a);
            assertTrue(a.isFacharbeiter());
        } catch (FirmaException e) {
            System.out.println("FEHLER: " + e.getMessage());
        }
    }

    @Test
    void erstelleArbeiterMitParameterlosemKonstruktor() {
        try {
            Arbeiter a = new Arbeiter();
            System.out.println(a);
            assertFalse(a.isFacharbeiter());
        } catch (FirmaException e) {
            System.out.println("FEHLER: " + e.getMessage());
        }
    }

    @Test
    void erstelleArbeiterMitUngueltigenParametern() {
        try {
            Arbeiter a = new Arbeiter("", 1800, -10, -5, false);
            System.out.println(a);
        } catch (FirmaException e) {
            System.out.println("FEHLER: " + e.getMessage());
        }
    }

    @Test
    void testGetKostenProMonat() {
        try {
            Arbeiter a = new Arbeiter("Anna", 1985, 15, 40, true);
            int kosten = a.getKostenProMonat();
            System.out.println("Kosten pro Monat: " + kosten);
            assertTrue(kosten > 0);
        } catch (FirmaException e) {
            System.out.println("FEHLER: " + e.getMessage());
        }
    }
}
