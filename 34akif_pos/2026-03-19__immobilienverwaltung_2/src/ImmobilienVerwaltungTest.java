import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ImmobilienVerwaltungTest {

    @Test
    void anzahlIstZuBeginnNull() {
        ImmobilienVerwaltung verwaltung = new ImmobilienVerwaltung();

        assertEquals(0, verwaltung.anzahl());
    }

    @Test
    void hinzufuegenErhoehtDieAnzahlUndObjektIstVorhanden() throws ImmobilienException {
        ImmobilienVerwaltung verwaltung = new ImmobilienVerwaltung();
        Wohnung wohnung = new Wohnung("Ringstraße 1", 150000, true, 4, 70);

        verwaltung.hinzufuegen(wohnung);

        assertEquals(1, verwaltung.anzahl());
        assertTrue(verwaltung.istVorhanden(wohnung));
    }

    @Test
    void istVorhandenLiefertFalseFuerNichtHinzugefuegteImmobilie() throws ImmobilienException {
        ImmobilienVerwaltung verwaltung = new ImmobilienVerwaltung();
        Einfamilienhaus haus = new Einfamilienhaus("Gartenweg 5", 350000, true);

        assertFalse(verwaltung.istVorhanden(haus));
    }

    @Test
    void entfernenLoeschtVorhandeneImmobilie() throws ImmobilienException {
        ImmobilienVerwaltung verwaltung = new ImmobilienVerwaltung();
        Wohnung wohnung = new Wohnung("Ringstraße 1", 150000, false, 2, 60);
        verwaltung.hinzufuegen(wohnung);

        boolean entfernt = verwaltung.entfernen(wohnung);

        assertTrue(entfernt);
        assertEquals(0, verwaltung.anzahl());
        assertFalse(verwaltung.istVorhanden(wohnung));
    }

    @Test
    void entfernenLiefertFalseWennImmobilieNichtVorhandenIst() throws ImmobilienException {
        ImmobilienVerwaltung verwaltung = new ImmobilienVerwaltung();
        Wohnung wohnung = new Wohnung("Ringstraße 1", 150000, false, 2, 60);

        assertFalse(verwaltung.entfernen(wohnung));
    }

    @Test
    void gesamtWertSummiertAlleImmobilien() throws ImmobilienException {
        ImmobilienVerwaltung verwaltung = new ImmobilienVerwaltung();
        Wohnung wohnung = new Wohnung("Ringstraße 1", 150000, true, 4, 70);
        Einfamilienhaus haus = new Einfamilienhaus("Gartenweg 5", 350000, false);
        verwaltung.hinzufuegen(wohnung);
        verwaltung.hinzufuegen(haus);

        assertEquals(500000, verwaltung.gesamtWert());
    }

    @Test
    void toStringEnthaeltUeberschriftUndImmobilien() throws ImmobilienException {
        ImmobilienVerwaltung verwaltung = new ImmobilienVerwaltung();
        Wohnung wohnung = new Wohnung("Ringstraße 1", 150000, true, 4, 70);
        verwaltung.hinzufuegen(wohnung);

        String ausgabe = verwaltung.toString();

        assertTrue(ausgabe.contains("Immobilienverwaltung"));
        assertTrue(ausgabe.contains("Wohnung Adresse: Ringstraße 1, Wert: 150000"));
    }

    @Test
    void hinzufuegenWirftExceptionBeiNull() {
        ImmobilienVerwaltung verwaltung = new ImmobilienVerwaltung();

        ImmobilienException exception = assertThrows(ImmobilienException.class, () -> verwaltung.hinzufuegen(null));

        assertTrue(exception.getMessage().contains("immobilie ist null"));
    }

    @Test
    void istVorhandenWirftExceptionBeiNull() {
        ImmobilienVerwaltung verwaltung = new ImmobilienVerwaltung();

        ImmobilienException exception = assertThrows(ImmobilienException.class, () -> verwaltung.istVorhanden(null));

        assertTrue(exception.getMessage().contains("immobilie ist null"));
    }

    @Test
    void entfernenWirftExceptionBeiNull() {
        ImmobilienVerwaltung verwaltung = new ImmobilienVerwaltung();

        ImmobilienException exception = assertThrows(ImmobilienException.class, () -> verwaltung.entfernen(null));

        assertTrue(exception.getMessage().contains("immobilie ist null"));
    }

    @Test
    void testBeiPLF() {
        ImmobilienVerwaltung verwaltung = new ImmobilienVerwaltung();
        try {
            Wohnung wohnung = new Wohnung("Ringstraße 1", 1_500_000, true, 4, 70);
            Wohnung wohnung2 = new Wohnung("Spengergasse 10", 700_000, false, 33, 70);
            Buero b = new Buero("Stephanplatz 1", 1_800_000, false, 13, 110);
            Einfamilienhaus eh = new Einfamilienhaus("Pampastrasse 13", 800_000, false);
            verwaltung.hinzufuegen(wohnung);
            verwaltung.hinzufuegen(wohnung2);
            verwaltung.hinzufuegen(eh);
            verwaltung.hinzufuegen(b);

            System.out.println(verwaltung);
        } catch (ImmobilienException e) {
            System.out.println("FEHLER: " + e.getMessage());
        }
    }
}

