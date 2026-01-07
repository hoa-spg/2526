import static org.junit.jupiter.api.Assertions.*;

class MesswerteTest {

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.Test
    void durschnittsWert() {
        Messwerte mw = new Messwerte();

        assertEquals(-1.685714, mw.durschnittsWert(), 0.001);
    }
}