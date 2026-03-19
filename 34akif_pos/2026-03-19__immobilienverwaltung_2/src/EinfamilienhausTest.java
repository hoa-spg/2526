import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EinfamilienhausTest {

    @Test
    void isPool() throws ImmobilienException {
        Einfamilienhaus haus = new Einfamilienhaus("Gartenweg 5", 350000, true);

        assertTrue(haus.isPool());
    }

    @Test
    void setPool() {
        Einfamilienhaus haus = new Einfamilienhaus();

        haus.setPool(true);

        assertTrue(haus.isPool());
    }

    @Test
    void defaultConstructorInitialisiertOhnePool() {
        Einfamilienhaus haus = new Einfamilienhaus();

        assertFalse(haus.isPool());
        assertEquals("n/a", haus.getAdresse());
        assertEquals(0, haus.getWert());
    }

    @Test
    void testToString() throws ImmobilienException {
        Einfamilienhaus haus = new Einfamilienhaus("Gartenweg 5", 350000, true);

        assertEquals("Einfamilienhaus Adresse: Gartenweg 5, Wert: 350000, mit Pool", haus.toString());
    }
}