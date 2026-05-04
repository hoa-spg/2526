import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PraktikantTest {
    @Test
    void testToCsvString() {
        try {
            Praktikant p = new Praktikant("Fritz", 2001, 10, 40);
            String csv = p.toCsvString();
            assertEquals("Praktikant;Fritz;2001;10;40", csv);
        } catch (FirmaException e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    void testToCsvStringWithOtherValues() {
        try {
            Praktikant p = new Praktikant("Anna", 2005, 15, 20);
            String csv = p.toCsvString();
            assertEquals("Praktikant;Anna;2005;15;20", csv);
        } catch (FirmaException e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    void erzeugePraktikantMitGueltigemCsvString() {
        String csv = "Praktikant;Charlie;2000;20;30";
        try {
            Praktikant p = new Praktikant(csv);
            assertEquals("Charlie", p.getName());
            assertEquals(2000, p.getGeburtsjahr());
            assertEquals(20, p.getStundenlohn());
            assertEquals(30, p.getAnzahlWochenStunden());
            System.out.println(p);
        } catch (FirmaException fe) {
            fail("FEHLER: Exception wurde trotz gueltigem CSV-String geworfen.");
            System.out.println("FEHLER: " + fe.getMessage());
            fe.printStackTrace();
        }
    }

    @Test
    void erzeugePraktikantMitUngueltigemCsvString() {
        String csv = "Praktikant;Charlie;zweitausend;20;30";
        // ..............................AAAAAAAAA...... ungueltiger Wert!
        try {
            Praktikant p = new Praktikant(csv);
            fail("FEHLER: Exception wurde erwartet, aber keine wurde geworfen.");
        } catch (FirmaException fe) {
            System.out.println("OK: Exception wurde wie erwartet geworfen: " + fe.getMessage());
        }
    }

    @Test
    void erzeugePraktikantMitFalschemTyp() {
        String csv = "Arbeiter;Charlie;2000;20;30";
        try {
            Praktikant p = new Praktikant(csv);
            fail("FEHLER: Exception wurde erwartet, aber keine wurde geworfen.");
        } catch (FirmaException fe) {
            System.out.println("OK: Exception wurde wie erwartet geworfen: " + fe.getMessage());
        }
    }

    @Test
    void erzeugePraktikantMitZuWenigTokens() {
        String csv = "Praktikant;Charlie;2000;20";
        try {
            Praktikant p = new Praktikant(csv);
            fail("FEHLER: Exception wurde erwartet, aber keine wurde geworfen.");
        } catch (FirmaException fe) {
            System.out.println("OK: Exception wurde wie erwartet geworfen: " + fe.getMessage());
        }
    }
}
