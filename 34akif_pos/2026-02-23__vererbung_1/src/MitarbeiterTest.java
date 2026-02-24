import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MitarbeiterTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void testToString() {
        Mitarbeiter m = new Mitarbeiter("Alice", 1993, 40, 30);
        System.out.println(m.toString());
    }
}