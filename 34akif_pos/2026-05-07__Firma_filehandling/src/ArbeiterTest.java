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
    void erstelleArbeiterMitAllenParameternUngueltigesGeburtsjahr() {
        boolean exceptionThrown = false;
        try {
            Arbeiter a = new Arbeiter("Max", 1890, 20, 40, true);
            System.out.println(a);
            assertTrue(a.isFacharbeiter());
        } catch (FirmaException e) {
            System.out.println("FEHLER: " + e.getMessage());
            exceptionThrown = true;
        }
        assertTrue(exceptionThrown);
    }

    /**
     * Alternative, (bessere) Variante geworfene Exception
     * im Testfall zu pruefen
     */
    @Test
    void erstelleArbeiterMitAllenParameternUngueltigesGeburtsjahr2() {
        try {
            Arbeiter a = new Arbeiter("Max", 1890, 20, 40, true);
            fail("Exception not thrown as expected");
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

    @Test
    void testToCsvString() {
        try {
            Arbeiter a = new Arbeiter("Max", 1990, 20, 40, true);
            String csv = a.toCsvString();
            assertEquals("Arbeiter;Max;1990;20;40;Facharbeiter", csv);
            Arbeiter b = new Arbeiter("Lisa", 1995, 18, 35, false);
            String csv2 = b.toCsvString();
            assertEquals("Arbeiter;Lisa;1995;18;35;Hilfsarbeiter", csv2);
        } catch (FirmaException e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    void erzeugeArbeiterMitGueltigemCsvString() {
        String csv = "Arbeiter;Bob;1995;35;40;Facharbeiter";
        try {
            Arbeiter a = new Arbeiter(csv);
            assertEquals("Bob", a.getName());
            assertEquals(1995, a.getGeburtsjahr());
            assertEquals(35, a.getStundenlohn());
            assertEquals(40, a.getAnzahlWochenStunden());
            assertTrue(a.isFacharbeiter());
            System.out.println(a);
        } catch (FirmaException fe) {
            fail("FEHLER: Exception wurde trotz gueltigem CSV-String geworfen.");
            System.out.println("FEHLER: " + fe.getMessage());
            fe.printStackTrace();
        }
    }

    @Test
    void erzeugeArbeiterMitGueltigemCsvStringHilfsarbeiter() {
        String csv = "Arbeiter;Lisa;1988;25;30;Hilfsarbeiter";
        try {
            Arbeiter a = new Arbeiter(csv);
            assertEquals("Lisa", a.getName());
            assertEquals(1988, a.getGeburtsjahr());
            assertEquals(25, a.getStundenlohn());
            assertEquals(30, a.getAnzahlWochenStunden());
            assertFalse(a.isFacharbeiter());
            System.out.println(a);
        } catch (FirmaException fe) {
            fail("FEHLER: Exception wurde trotz gueltigem CSV-String geworfen.");
            System.out.println("FEHLER: " + fe.getMessage());
            fe.printStackTrace();
        }
    }

    @Test
    void erzeugeArbeiterMitUngueltigemCsvString() {
        String csv = "Arbeiter;Bob;neunzehnneunundneunzig;35;40;Facharbeiter";
        // ..............................AAAAAAAAAAAAA...... ungueltiger Wert!
        try {
            Arbeiter a = new Arbeiter(csv);
            fail("FEHLER: Exception wurde erwartet, aber keine wurde geworfen.");
        } catch (FirmaException fe) {
            System.out.println("OK: Exception wurde wie erwartet geworfen: " + fe.getMessage());
        }
    }

    @Test
    void erzeugeArbeiterMitFalschemTyp() {
        String csv = "Angestellter;Bob;1995;35;40;Facharbeiter";
        try {
            Arbeiter a = new Arbeiter(csv);
            fail("FEHLER: Exception wurde erwartet, aber keine wurde geworfen.");
        } catch (FirmaException fe) {
            System.out.println("OK: Exception wurde wie erwartet geworfen: " + fe.getMessage());
        }
    }

    @Test
    void erzeugeArbeiterMitUngueltigemFacharbeiterWert() {
        String csv = "Arbeiter;Bob;1995;35;40;Meister";
        try {
            Arbeiter a = new Arbeiter(csv);
            fail("FEHLER: Exception wurde erwartet, aber keine wurde geworfen.");
        } catch (FirmaException fe) {
            System.out.println("OK: Exception wurde wie erwartet geworfen: " + fe.getMessage());
        }
    }
}
