import static org.junit.jupiter.api.Assertions.assertEquals;

class MesswerteTest {

    private Messwerte messwerte;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        messwerte = new Messwerte();
        messwerte.messwertHinzufuegen(13);
        messwerte.messwertHinzufuegen(7);
        messwerte.messwertHinzufuegen(0);
        messwerte.messwertHinzufuegen(-5);
        messwerte.messwertHinzufuegen(3);
    }

    @org.junit.jupiter.api.Test
    void zugriffAufMesswerte() {
        assertEquals(-5, messwerte.messwert(3));
    }

    @org.junit.jupiter.api.Test
    void messwertHinzufuegen() {
        Messwerte messwerte = new Messwerte();
        messwerte.messwertHinzufuegen(13);
        assertEquals(13, messwerte.messwert(0));
        messwerte.messwertHinzufuegen(7);
        assertEquals(7, messwerte.messwert(1));
        messwerte.messwertHinzufuegen(0);
        assertEquals(0, messwerte.messwert(2));
        messwerte.messwertHinzufuegen(-5);
        assertEquals(-5, messwerte.messwert(3));
        System.out.println(messwerte);
    }

    @org.junit.jupiter.api.Test
    void messwertEntfernen() {
        System.out.println(messwerte);
        // TODO
        assertEquals(5, messwerte.getAnzahl());
        messwerte.wertLoeschen(2);
        assertEquals(4, messwerte.getAnzahl());
        assertEquals(13, messwerte.messwert(0));
        assertEquals(7, messwerte.messwert(1));
        assertEquals(-5, messwerte.messwert(2));
        assertEquals(3, messwerte.messwert(3));
        System.out.println(messwerte);
    }

    @org.junit.jupiter.api.Test
    void messwertEinfuegen() {
        assertEquals(5, messwerte.getAnzahl());
        System.out.println(messwerte);
        messwerte.wertEinfuegen(2, 4);
        System.out.println(messwerte);
        assertEquals(4, messwerte.messwert(2));
        assertEquals(0, messwerte.messwert(3));
        assertEquals(-5, messwerte.messwert(4));
        assertEquals(3, messwerte.messwert(5));
        assertEquals(6, messwerte.getAnzahl());
    }
}