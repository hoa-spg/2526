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
}

