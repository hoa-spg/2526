import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AutoTest {

    private Auto a1;
    private Auto a2;

    @BeforeEach
    void setUp() {
        try {
            a1 = new Auto();
            a2 = new Auto("Mazda", 45, 1500, true);
        } catch (FuhrparkException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void toStringTest() {
        System.out.println(a1.toString());
        System.out.println(a2.toString());
    }

    @Test
    void berechneSteuerTest() {
        assertEquals(100, a1.berechneSteuer());
        assertEquals(50, a2.berechneSteuer());
    }

    @Test
    void berechneVerbrauchTest() {
        System.out.println(a1.berechneVerbrauch());
        assertEquals(6.0, a1.berechneVerbrauch());

        System.out.println(a2.berechneVerbrauch());
        assertEquals(6.55, a2.berechneVerbrauch());
    }
}