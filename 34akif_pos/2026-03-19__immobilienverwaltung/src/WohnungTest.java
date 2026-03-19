import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WohnungTest {

    @Test
    void isBalkon() throws ImmobilienException {
        Wohnung wohnung = new Wohnung("Musterweg 1", 120000, true, 3, 75);

        assertTrue(wohnung.isBalkon());
    }

    @Test
    void setBalkon() throws ImmobilienException {
        Wohnung wohnung = new Wohnung();

        wohnung.setBalkon(false);

        assertFalse(wohnung.isBalkon());
    }

    @Test
    void getNummer() throws ImmobilienException {
        Wohnung wohnung = new Wohnung("Musterweg 1", 120000, true, 7, 75);

        assertEquals(7, wohnung.getNummer());
    }

    @Test
    void setNummer() throws ImmobilienException {
        Wohnung wohnung = new Wohnung();

        wohnung.setNummer(12);

        assertEquals(12, wohnung.getNummer());
    }

    @Test
    void setNummerThrowsForInvalidValue() throws ImmobilienException {
        Wohnung wohnung = new Wohnung();

        ImmobilienException exception = assertThrows(ImmobilienException.class, () -> wohnung.setNummer(0));

        assertTrue(exception.getMessage().contains("nummer"));
    }

    @Test
    void getGroesse() throws ImmobilienException {
        Wohnung wohnung = new Wohnung("Musterweg 1", 120000, false, 2, 88);

        assertEquals(88, wohnung.getGroesse());
    }

    @Test
    void setGroesse() throws ImmobilienException {
        Wohnung wohnung = new Wohnung();

        wohnung.setGroesse(95);

        assertEquals(95, wohnung.getGroesse());
    }

    @Test
    void setGroesseThrowsForInvalidValue() throws ImmobilienException {
        Wohnung wohnung = new Wohnung();

        ImmobilienException exception = assertThrows(ImmobilienException.class, () -> wohnung.setGroesse(-1));

        assertTrue(exception.getMessage().contains("groesse"));
    }
}