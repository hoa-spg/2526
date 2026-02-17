import static org.junit.jupiter.api.Assertions.*;

class SitzplanTest {

    private Sitzplan sitzplan;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        sitzplan = new Sitzplan();
    }

    @org.junit.jupiter.api.Test
    void testToString() {
        System.out.println(sitzplan);
    }
}