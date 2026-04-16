import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FuhrparkTest {

    private Fuhrpark park;
    private Auto a1;
    private Auto a2;
    private Motorrad m1;
    private Motorrad m2;

    @BeforeEach
    void setUp() {
        try {
            park = new Fuhrpark("Spengergassen-Fuhrpark");
            a1 = new Auto("VW Transporter", 90, 2500, false);
            a2 = new Auto("Mazda", 50, 1500, true);
            m1 = new Motorrad();
            m2 = new Motorrad("Yamaha", 45, 500, true);
        } catch (FuhrparkException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void aufnehmen() {
        assertEquals(0, park.anzahlFahrzeuge());
        try {
            park.aufnehmen(a1);
            park.aufnehmen(m1);
        } catch (FuhrparkException e) {
            System.out.println(e.getMessage());
        }
        assertEquals(2, park.anzahlFahrzeuge());
        try {
            park.aufnehmen(a2);
            park.aufnehmen(m2);
        } catch (FuhrparkException e) {
            System.out.println(e.getMessage());
        }
        assertEquals(4, park.anzahlFahrzeuge());
        System.out.println(park.toString());
    }

    @Test
    void istVorhandenTest() {
        try {
            park.aufnehmen(a1);
            assertTrue(park.istVorhanden(a1));
            assertFalse(park.istVorhanden(m1));
        } catch (FuhrparkException e) {
            System.out.println(e.getMessage());
        }

    }

    @Test
    void testBeidseitigeAssoziationVerschiedenFahrzeuge() {
        try {
            Fuhrpark f1 = new Fuhrpark("Rote Kreuz");
            Fuhrpark f2 = new Fuhrpark("Samariter Bund");
            f1.aufnehmen(a1);
            f2.aufnehmen(a2);
            System.out.println(f1);
            System.out.println(f2);
            assertEquals(1, f1.anzahlFahrzeuge());
            assertEquals(1, f2.anzahlFahrzeuge());
        } catch (FuhrparkException e) {
            System.out.println(e.getMessage());
            fail(e.getMessage());
        }
    }

    @Test
    void testBeidseitigeAssoziationFahrzeugInZweiFuhrparks() {
        try {
            Fuhrpark f1 = new Fuhrpark("Rote Kreuz");
            Fuhrpark f2 = new Fuhrpark("Samariter Bund");
            f1.aufnehmen(a1);
            f2.aufnehmen(a1);
            fail("Ein Fahrzeug darf nicht in zwei Fuhrparks aufgenommen werden");
        } catch (FuhrparkException e) {
            System.out.println(e.getMessage());
        }
    }


    @Test
    void testBeidseitigeAssoziationVerschiedenFahrzeugeXXXXXXXXXXXXXXXXXX() {
        try {
            Fuhrpark f1 = new Fuhrpark("Rote Kreuz");
            Fuhrpark f2 = new Fuhrpark("Samariter Bund");
            Fuhrpark f3 = new Fuhrpark("Grünes Kreuz");
            f1.aufnehmen(a1);
            f2.aufnehmen(a2);
            a1.setFuhrpark(f3);
            fail("Fehler: setFuhrpark sollte Exception werfen");
            System.out.println(f1);
            System.out.println(f2);
            assertEquals(1, f1.anzahlFahrzeuge());
            assertEquals(1, f2.anzahlFahrzeuge());
            assertEquals(f1, a1.getFuhrpark());
            assertEquals(f2, a2.getFuhrpark());
        } catch (FuhrparkException e) {
            System.out.println(e.getMessage());

        }
    }
}