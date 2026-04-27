import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MotorradTest {

    private Motorrad m1;
    private Motorrad m2;

    @BeforeEach
    void setUp() {
        try {
            m1 = new Motorrad();
            m2 = new Motorrad("Yamaha", 45, 500, true);
        } catch (FuhrparkException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void toStringTest() {
        System.out.println(m1.toString());
        System.out.println(m2.toString());
    }

    @Test
    void berechneSteuerTest() {
        assertEquals(30, m1.berechneSteuer());
        assertEquals(15, m2.berechneSteuer());
    }

    @Test
    void berechneVerbrauch() {
        System.out.println(m2.berechneVerbrauch());
        assertEquals(2.849, m2.berechneVerbrauch(), 0.01);
    }
}