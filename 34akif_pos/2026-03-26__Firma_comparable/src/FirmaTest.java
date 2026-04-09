import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FirmaTest {

    @Test
    public void testEinfuegen() {
        try {
            Firma firma = new Firma("TestFirma");
            Angesteller a1 = new Angesteller("Anna", 1980, 25, 40, true);
            Angesteller a2 = new Angesteller("Ben", 1975, 30, 35, false);
            Angesteller a3 = new Angesteller("Clara", 1990, 28, 38, true);
            Arbeiter w1 = new Arbeiter("David", 1985, 20, 40, true);
            Arbeiter w2 = new Arbeiter("Eva", 1992, 22, 36, false);
            Arbeiter w3 = new Arbeiter("Frank", 1978, 18, 42, true);

            firma.einstellen(a1);
            firma.einstellen(a2);
            firma.einstellen(a3);
            firma.einstellen(w1);
            firma.einstellen(w2);
            firma.einstellen(w3);

            // Check that 6 employees are added
            assertEquals(6, firma.anzahlMitarbeiter());
        } catch (FirmaException e) {
            System.out.println("FEHLER: " + e.getMessage());
        }
    }

    @Test
    public void testKostenProMonat() {
        try {
            Firma firma = new Firma("TestFirma");
            Angesteller a1 = new Angesteller("Anna", 1980, 25, 40, true);
            Angesteller a2 = new Angesteller("Ben", 1975, 30, 35, false);
            Angesteller a3 = new Angesteller("Clara", 1990, 28, 38, true);
            Arbeiter w1 = new Arbeiter("David", 1985, 20, 40, true);
            Arbeiter w2 = new Arbeiter("Eva", 1992, 22, 36, false);
            Arbeiter w3 = new Arbeiter("Frank", 1978, 18, 42, true);

            firma.einstellen(a1);
            firma.einstellen(a2);
            firma.einstellen(a3);
            firma.einstellen(w1);
            firma.einstellen(w2);
            firma.einstellen(w3);

            int kostenProMonat = firma.getKostenProMonat();
            System.out.println("Kosten pro Monat: " + kostenProMonat);

            assertEquals(22398, kostenProMonat);

            Praktikant p = new Praktikant("Fritz", 2001, 10, 40);
            firma.einstellen(p);
            kostenProMonat = firma.getKostenProMonat();
            System.out.println("Kosten pro Monat mit Praktikant: " + kostenProMonat);

        } catch (FirmaException e) {
            fail("FEHLER: " + e.getMessage());
        }
    }

    @Test
    public void testSetName() {
        try {
            Firma firma = new Firma();
            firma.setName("NeueFirma");
            assertEquals("NeueFirma", firma.getName());
            firma.setName(""); // Should not change name
            assertEquals("NeueFirma", firma.getName());
            firma.setName(null); // Should not change name
            assertEquals("NeueFirma", firma.getName());
        } catch (FirmaException e) {
            System.out.println("FEHLER: " + e.getMessage());
        }
    }

    @Test
    public void testToString() {
        try {
            Firma firma = new Firma("DemoFirma");
            firma.einstellen(new Angesteller("Anna", 1980, 25, 40, true));
            firma.einstellen(new Angesteller("Ben", 1975, 30, 35, false));
            firma.einstellen(new Angesteller("Clara", 1990, 28, 38, true));
            firma.einstellen(new Arbeiter("David", 1985, 20, 40, true));
            firma.einstellen(new Arbeiter("Eva", 1992, 22, 36, false));
            firma.einstellen(new Arbeiter("Frank", 1978, 18, 42, true));
            System.out.println(firma.toString());
        } catch (FirmaException e) {
            System.out.println("FEHLER: " + e.getMessage());
        }
    }

    @Test
    public void testSortierteListe() {
        try {
            Firma firma = new Firma("DemoFirma");
            firma.einstellen(new Arbeiter("David", 1985, 20, 40, true));
            firma.einstellen(new Arbeiter("David", 1981, 25, 40, true));

            firma.einstellen(new Arbeiter("Frank", 1978, 18, 42, true));
            firma.einstellen(new Arbeiter("Eva", 1992, 22, 36, false));

            firma.einstellen(new Angesteller("Anna", 1980, 25, 40, true));
            firma.einstellen(new Angesteller("Clara", 1990, 28, 38, true));
            firma.einstellen(new Angesteller("Ben", 1975, 30, 35, false));
            List<Mitarbeiter> sortiert = firma.sortierteListe();
            for (Mitarbeiter m : sortiert) {
                System.out.println(m);
            }
//            System.out.println(firma.toString());
        } catch (FirmaException e) {
            System.out.println("FEHLER: " + e.getMessage());
        }
    }

    @Test
    public void testVorhanden() {
        try {
            Firma firma = new Firma("DemoFirma");
            firma.einstellen(new Arbeiter("David", 1985, 20, 40, true));
            firma.einstellen(new Praktikant("Fritz", 1981, 25, 40));
            boolean vorhanden = firma.istVorhanden(new Arbeiter("David", 1985, 20, 40, true));
            System.out.println("David vorhanden: " + vorhanden);
            assertTrue(vorhanden);

            vorhanden = firma.istVorhanden(new Praktikant("Fritz", 1981, 25, 40));

            assertTrue(vorhanden);

         } catch (FirmaException e) {
             System.out.println("FEHLER: " + e.getMessage());
         }

    }
}

