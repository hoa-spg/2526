import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AngestellerTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void erstelleAngestellten() {
        Angesteller ang = new Angesteller("Peter", 1985, 25, 30, true);
        ang.print();
    }

    @Test
    void erstelleAngestelltenMitParameterlosemKonstruktor() {
        Angesteller ang = new Angesteller();
        ang.print();
    }

    @Test
    void testToString() {
        Angesteller a = new Angesteller("Bob", 1987, 45, 25, true);
        System.out.println(a.toString());
    }
}