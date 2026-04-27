import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MitarbeiterTest {

    @Test
    void testMitarbeiterErzeugen() {
        try {
            Mitarbeiter m = new Arbeiter("Bob", -3, -30, -3, true);


            ((Arbeiter)m).getKostenProMonat();
            System.out.println("Mitarbeiter: " + m);
        } catch (FirmaException e) {
            // Fehlerbehandlung
            System.out.println("FEHLER: " + e.getMessage());
        }
    }

}