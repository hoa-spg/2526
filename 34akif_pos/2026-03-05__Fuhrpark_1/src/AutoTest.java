import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class AutoTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void testAlter() {
        Auto a = new Auto("Ferrari",
                LocalDate.of(2005, 03, 15),
                120_000, false, false);
        assertEquals(21, a.alter());

    }

    @Test
    void testToString() {
        Auto a = new Auto("Ferrari",
                LocalDate.of(2005, 03, 15),
                120_000, false, false);
        System.out.println(a);

    }
}