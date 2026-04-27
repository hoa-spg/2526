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
        park = new Fuhrpark();
        try {
            a1 = new Auto();
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
}