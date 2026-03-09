import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MitarbeiterTest {

    @BeforeEach
    void setUp() {
    }

    /**
     * Testfall: bei Erzeugen von Mitarbeiter mit ungueltigen
     * Parametern wird eine Exception geworfen!
     */
    @Test
    void testMitarbeiterErzeugen() {
        try {
            Mitarbeiter m = new Mitarbeiter("Bob", -3, -30, -3);
            System.out.println("Mitarbeiter: " + m);
        } catch (FirmaException e) {
            // Fehlerbehandlung
            System.out.println("FEHLER: " + e.getMessage());
        }
    }

    @Test
    void testMitarbeiterValid() {
        try {
            Mitarbeiter m = new Mitarbeiter("Alice", 1995, 20, 40);
            System.out.println("Mitarbeiter: " + m);
            assertEquals("Alice", m.getName());
            assertEquals(1995, m.getGeburtsjahr());
            assertEquals(20, m.getStundenlohn());
            assertEquals(40, m.getAnzahlWochenStunden());
        } catch (FirmaException e) {
            System.out.println("FEHLER: " + e.getMessage());
        }
    }

    @Test
    void testMitarbeiterUngueltigeParameter() {
        try {
            Mitarbeiter m = new Mitarbeiter("", 1800, -10, -5);
            System.out.println("Mitarbeiter: " + m);
        } catch (FirmaException e) {
            System.out.println("FEHLER: " + e.getMessage());
        }
    }

    @Test
    void testGetters() {
        try {
            Mitarbeiter m = new Mitarbeiter("Tom", 2000, 15, 35);
            assertEquals("Tom", m.getName());
            assertEquals(2000, m.getGeburtsjahr());
            assertEquals(15, m.getStundenlohn());
            assertEquals(35, m.getAnzahlWochenStunden());
        } catch (FirmaException e) {
            System.out.println("FEHLER: " + e.getMessage());
        }
    }

}