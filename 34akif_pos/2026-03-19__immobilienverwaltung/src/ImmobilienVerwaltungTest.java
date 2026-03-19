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
}

