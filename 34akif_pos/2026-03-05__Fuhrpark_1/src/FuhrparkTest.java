import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class FuhrparkTest {

    private Fuhrpark fuhrpark;
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        fuhrpark = new Fuhrpark("Spengergassen-Fuhrpark");
    }


    @Test
    void aufnehmen() {
        Auto a1 = new Auto("Fiat", LocalDate.of(2011, 2, 19),
                19000, true, false);
        assertEquals(0, fuhrpark.anzahl());
        fuhrpark.aufnehmen(a1);
        assertEquals(1, fuhrpark.anzahl());
        assertTrue(fuhrpark.contains(a1));

    }

    /**
     * Testfall: Entfernen eines vorhandenen Fahrzeugs aus dem Fuhrpark.
     * Erwartung: Fahrzeug wird entfernt, anzahl sinkt, contains liefert false.
     */
    @Test
    void entfernen_vorhandenesFahrzeug() {
        Auto a1 = new Auto("VW Golf", LocalDate.of(2015, 5, 10), 15000, false, true);
        fuhrpark.aufnehmen(a1);
        assertEquals(1, fuhrpark.anzahl());
        assertTrue(fuhrpark.contains(a1));
        boolean entfernt = fuhrpark.entfernen(a1);
        assertTrue(entfernt);
        assertEquals(0, fuhrpark.anzahl());
        assertFalse(fuhrpark.contains(a1));
    }

    /**
     * Testfall: Entfernen eines nicht vorhandenen Fahrzeugs aus dem Fuhrpark.
     * Erwartung: entfernen liefert false, anzahl und contains bleiben unverändert.
     */
    @Test
    void entfernen_nichtVorhandenesFahrzeug() {
        Auto a1 = new Auto("VW Golf", LocalDate.of(2015, 5, 10), 15000, false, true);
        Auto a2 = new Auto("Audi A3", LocalDate.of(2018, 7, 20), 20000, false, true);
        fuhrpark.aufnehmen(a1);
        assertEquals(1, fuhrpark.anzahl());
        assertFalse(fuhrpark.contains(a2));
        boolean entfernt = fuhrpark.entfernen(a2);
        assertFalse(entfernt);
        assertEquals(1, fuhrpark.anzahl());
        assertTrue(fuhrpark.contains(a1));
    }

    /**
     * Testfall: Entfernen von null als Fahrzeug.
     * Erwartung: entfernen liefert false, anzahl bleibt unverändert.
     */
    @Test
    void entfernen_nullFahrzeug() {
        Auto a1 = new Auto("VW Golf", LocalDate.of(2015, 5, 10), 15000, false, true);
        fuhrpark.aufnehmen(a1);
        assertEquals(1, fuhrpark.anzahl());
        boolean entfernt = fuhrpark.entfernen(null);
        assertFalse(entfernt);
        assertEquals(1, fuhrpark.anzahl());
        assertTrue(fuhrpark.contains(a1));
    }

    /**
     * Testfall: Aufnehmen von null als Fahrzeug.
     * Erwartung: anzahl bleibt unverändert, contains liefert false.
     */
    @Test
    void aufnehmen_nullFahrzeug() {
        assertEquals(0, fuhrpark.anzahl());
        fuhrpark.aufnehmen(null);
        assertEquals(0, fuhrpark.anzahl());
    }

    /**
     * Testfall: Aufnehmen desselben Fahrzeugs mehrfach.
     * Erwartung: Fahrzeug wird nur einmal aufgenommen, anzahl bleibt 1.
     */
    @Test
    void aufnehmen_doppeltesFahrzeug() {
        Auto a1 = new Auto("VW Golf", LocalDate.of(2015, 5, 10), 15000, false, true);
        fuhrpark.aufnehmen(a1);
        fuhrpark.aufnehmen(a1);
        assertEquals(1, fuhrpark.anzahl());
        assertTrue(fuhrpark.contains(a1));
    }

    /**
     * Testfall: Aufnehmen mehrerer verschiedener Fahrzeuge.
     * Erwartung: alle Fahrzeuge werden aufgenommen, anzahl stimmt, contains für alle true.
     */
    @Test
    void aufnehmen_mehrereFahrzeuge() {
        Auto a1 = new Auto("VW Golf", LocalDate.of(2015, 5, 10), 15000, false, true);
        Motorrad m1 = new Motorrad("Yamaha", LocalDate.of(2017, 8, 15), 8000, false);
        fuhrpark.aufnehmen(a1);
        fuhrpark.aufnehmen(m1);
        assertEquals(2, fuhrpark.anzahl());
        assertTrue(fuhrpark.contains(a1));
        assertTrue(fuhrpark.contains(m1));
    }
}