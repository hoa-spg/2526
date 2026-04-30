import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FirmaTest {

    @Test
    public void testEinfuegen() {
        try {
            Firma firma = new Firma("TestFirma");
            Angestellter a1 = new Angestellter("Anna", 1980, 25, 40, true);
            Angestellter a2 = new Angestellter("Ben", 1975, 30, 35, false);
            Angestellter a3 = new Angestellter("Clara", 1990, 28, 38, true);
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
            Angestellter a1 = new Angestellter("Anna", 1980, 25, 40, true);
            Angestellter a2 = new Angestellter("Ben", 1975, 30, 35, false);
            Angestellter a3 = new Angestellter("Clara", 1990, 28, 38, true);
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
            firma.einstellen(new Angestellter("Anna", 1980, 25, 40, true));
            firma.einstellen(new Angestellter("Ben", 1975, 30, 35, false));
            firma.einstellen(new Angestellter("Clara", 1990, 28, 38, true));
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

            firma.einstellen(new Angestellter("Anna", 1980, 25, 40, true));
            firma.einstellen(new Angestellter("Clara", 1990, 28, 38, true));
            firma.einstellen(new Angestellter("Ben", 1975, 30, 35, false));
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

    @Test
    void testSerialize() {
        try {
            Firma firma = new Firma("TestFirma");
            Angestellter a1 = new Angestellter("Anna", 1980, 25, 40, true);
            Angestellter a2 = new Angestellter("Ben", 1975, 30, 35, false);
            Angestellter a3 = new Angestellter("Clara", 1990, 28, 38, true);
            Arbeiter w1 = new Arbeiter("David", 1985, 20, 40, true);
            Arbeiter w2 = new Arbeiter("Eva", 1992, 22, 36, false);
            Arbeiter w3 = new Arbeiter("Frank", 1978, 18, 42, true);

            firma.einstellen(a1);
            firma.einstellen(a2);
            firma.einstellen(a3);
            firma.einstellen(w1);
            firma.einstellen(w2);
            firma.einstellen(w3);
            System.out.println(firma);

            firma.serialize("firma.ser");

            firma = new Firma();

            Firma f2 = Firma.deserialize("firma.ser");
            System.out.println("Eingelesene Firma: " + f2);
            // Vergleichen ob f2 und deren Mitarbeiter gleich ist
            // wie firma


        } catch (FirmaException e) {
//            System.out.println("FEHLER: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Test
    void testCsvString() {
        try {
            Firma f = new Firma("Spenger Corp.");
            Mitarbeiter m1 = new Arbeiter("Bob", 1999, 40, 25, true);
            Angestellter m2 = new Angestellter("Alice", 2001, 45, 25, true);
            Praktikant m3 = new Praktikant("Fritz", 2002, 12, 20);
            // weitere Mitarbeiter
            Mitarbeiter m4 = new Arbeiter("Eva", 1995, 30, 30, false);
            Angestellter m5 = new Angestellter("Clara", 1998, 35, 15, false);
            Praktikant m6 = new Praktikant("Tom", 2003, 10, 15);
            f.einstellen(m1);
            f.einstellen(m2);
            f.einstellen(m3);
            f.einstellen(m4);
            f.einstellen(m5);
            f.einstellen(m6);
            String csv = f.toCsvString();
            System.out.println(csv);
        } catch (FirmaException e) {
            System.out.println("FEHLER: " + e);
        }
    }

    @Test
    void writeToFile() {
        try {
            Firma f = new Firma("Spenger Corp.");
            Mitarbeiter m1 = new Arbeiter("Bob", 1999, 40, 25, true);
            Angestellter m2 = new Angestellter("Alice", 2001, 45, 25, true);
            Praktikant m3 = new Praktikant("Fritz", 2002, 12, 20);

            Mitarbeiter m4 = new Arbeiter("Eva", 1995, 30, 30, false);
            Angestellter m5 = new Angestellter("Clara", 1998, 35, 15, false);
            Praktikant m6 = new Praktikant("Tom", 2003, 10, 15);
            f.einstellen(m1);
            f.einstellen(m2);
            f.einstellen(m3);
            f.einstellen(m4);
            f.einstellen(m5);
            f.einstellen(m6);
            f.writeToFile("firma.csv");
        } catch (FirmaException e) {
            System.out.println("FEHLER: " + e);
        }
    }
}
