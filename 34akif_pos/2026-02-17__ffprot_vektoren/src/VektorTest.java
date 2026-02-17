import static org.junit.jupiter.api.Assertions.*;

class VektorTest {

    /**
     * Potentielle Erweiterungen dieser Testklasse
     * -
     */

    private Vektor v1;
    private Vektor v2;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        v1 = new Vektor(3);
        v1.set(0, 1);
        v1.set(1, 2);
        v1.set(2, 3);

        v2 = new Vektor(3);
        v2.set(0, 5);
        v2.set(1, 3);
        v2.set(2, -4);
    }

    @org.junit.jupiter.api.Test
    void dim() {
        assertEquals(3, v1.dim());
        assertEquals(3, v2.dim());
    }

    @org.junit.jupiter.api.Test
    void get() {
        assertEquals(1, v1.get(0));
    }

    @org.junit.jupiter.api.Test
    void set() {
        v1.set(0, 17);
        assertEquals(17, v1.get(0));
    }

    @org.junit.jupiter.api.Test
    void mult() {
        int s = v1.mult(v2);
        // System.out.println("v1: " + v1 + ", v2: " + v2 + ", s: " + s);
        assertEquals(-1, s);
    }

    @org.junit.jupiter.api.Test
    void add() {
        // 6, 5, -1
        Vektor s = v1.add(v2);
        System.out.println("s: " + s);
        assertEquals(6, s.get(0));
        assertEquals(5, s.get(1));
        assertEquals(-1, s.get(2));
    }

}