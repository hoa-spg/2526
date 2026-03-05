import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class MotorradTest {

    @Test
    void testAlter() {
        Motorrad m = new Motorrad("Puch Maxi",
                LocalDate.of(1985, 3, 3),
                5_000, true);
        assertEquals(LocalDate.now().getYear() - 1985, m.alter());
    }

    @Test
    void testToString() {
        Motorrad m = new Motorrad("Puch Maxi",
                LocalDate.of(1985, 3, 3),
                5_000, true);
        System.out.println(m);
        assertTrue(m.toString().contains("Kleinmotorrad"));
    }

    @Test
    void testGetterSetter() {
        Motorrad m = new Motorrad();
        m.setKleinMotorrad(true);
        assertTrue(m.isKleinMotorrad());
        m.setKleinMotorrad(false);
        assertFalse(m.isKleinMotorrad());
    }

}

