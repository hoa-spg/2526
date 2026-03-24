import static org.junit.jupiter.api.Assertions.*;

class BTest {

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.Test
    void testToString() {
        B b = new B(5, 6);
        System.out.println(b.toString());
    }
}