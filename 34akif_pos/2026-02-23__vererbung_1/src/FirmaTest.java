import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FirmaTest {

    @Test
    public void testEinfuegen() {
        Firma firma = new Firma("TestFirma");
        Angesteller a1 = new Angesteller("Anna", 1980, 25, 40, true);
        Angesteller a2 = new Angesteller("Ben", 1975, 30, 35, false);
        Angesteller a3 = new Angesteller("Clara", 1990, 28, 38, true);
        Arbeiter w1 = new Arbeiter("David", 1985, 20, 40, true);
        Arbeiter w2 = new Arbeiter("Eva", 1992, 22, 36, false);
        Arbeiter w3 = new Arbeiter("Frank", 1978, 18, 42, true);

        firma.einstellen(a1);
        firma.einstellen(a2);
        firma.einstellen(a3);
        firma.einstellen(w1);
        firma.einstellen(w2);
        firma.einstellen(w3);

        // Check that 6 employees are added
        assertEquals(6, firma.anzahlMitarbeiter());
    }

    @Test
    public void testSetName() {
        Firma firma = new Firma();
        firma.setName("NeueFirma");
        assertEquals("NeueFirma", firma.getName());
        firma.setName(""); // Should not change name
        assertEquals("NeueFirma", firma.getName());
        firma.setName(null); // Should not change name
        assertEquals("NeueFirma", firma.getName());
    }

    @Test
    public void testToString() {
        Firma firma = new Firma("DemoFirma");
        firma.einstellen(new Angesteller("Anna", 1980, 25, 40, true));
        firma.einstellen(new Angesteller("Ben", 1975, 30, 35, false));
        firma.einstellen(new Angesteller("Clara", 1990, 28, 38, true));
        firma.einstellen(new Arbeiter("David", 1985, 20, 40, true));
        firma.einstellen(new Arbeiter("Eva", 1992, 22, 36, false));
        firma.einstellen(new Arbeiter("Frank", 1978, 18, 42, true));
        System.out.println(firma.toString());
    }
}

