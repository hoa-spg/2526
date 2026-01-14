import static org.junit.jupiter.api.Assertions.*;

class LaborTest {

    private Labor labor;
    private Computer c1;
    private Computer c2;
    private Computer c3;
    private Computer c4;
    private Computer c5;
    private Computer c6;
    private Computer c7;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        labor = new Labor("B3.10MF", 6);
        c1 = new Computer("Lenovo", 1500, true);
        c2 = new Computer("Macbook", 2000, true);
        c3 = new Computer("Dell", 1700, false);
        c4 = new Computer("Asus", 1300, false);
        c5 = new Computer("Acer", 1300, false);
        c6 = new Computer("Lenovo T14", 1300, false);
        c7 = new Computer("Macbook Pro", 1300, false);
        labor.hinzufuegen(c1);
        labor.hinzufuegen(c2);
        labor.hinzufuegen(c3);
        assertEquals(3, labor.anzahlComputer());
    }

    @org.junit.jupiter.api.Test
    void hinzufuegen() {
        // 3 Computer im Labor
        labor.hinzufuegen(c4); // also an platz=3
        assertEquals(4, labor.anzahlComputer());
        assertEquals(c4, labor.getComputer(3));
        labor.hinzufuegen(c5);
        assertEquals(5, labor.anzahlComputer());
        assertEquals(c5, labor.getComputer(4));
    }

    @org.junit.jupiter.api.Test
    void hinzufuegenUngueltigerParameter() {
        labor.hinzufuegen(null);
        assertEquals(3, labor.anzahlComputer());
    }

    @org.junit.jupiter.api.Test
    void hinzufuegenArrayVoll() {
        labor.hinzufuegen(c4);
        labor.hinzufuegen(c5);
        labor.hinzufuegen(c6);
        assertEquals(6, labor.anzahlComputer());
        labor.hinzufuegen(c7);
        assertEquals(6, labor.anzahlComputer());
    }

    @org.junit.jupiter.api.Test
    void einfuegen() {
        labor.einfuegen(1, c4);
        assertEquals(c1, labor.getComputer(0));
        assertEquals(c4, labor.getComputer(1));
        assertEquals(c2, labor.getComputer(2));
        assertEquals(c3, labor.getComputer(3));
        System.out.println(labor);
    }

    @org.junit.jupiter.api.Test
    void einfuegenAmEnde() {
        labor.einfuegen(3, c4);
        assertEquals(c1, labor.getComputer(0));
        assertEquals(c2, labor.getComputer(1));
        assertEquals(c3, labor.getComputer(2));
        assertEquals(c4, labor.getComputer(3));
        System.out.println(labor);
    }

    @org.junit.jupiter.api.Test
    void einfuegenMitUngueltigemIndex() {
        labor.einfuegen(-1, c4);
        assertEquals(c1, labor.getComputer(0));
        assertEquals(c2, labor.getComputer(1));
        assertEquals(c3, labor.getComputer(2));
        assertEquals(3, labor.anzahlComputer());
    }

    @org.junit.jupiter.api.Test
    void einfuegenMitUngueltigemIndex2() {
        labor.einfuegen(4, c4);
        assertEquals(c1, labor.getComputer(0));
        assertEquals(c2, labor.getComputer(1));
        assertEquals(c3, labor.getComputer(2));
        assertEquals(3, labor.anzahlComputer());
    }


    @org.junit.jupiter.api.Test
    void einfuegenUngueligeReferenz() {
        labor.einfuegen(1, null);
        assertEquals(c1, labor.getComputer(0));
        assertEquals(c2, labor.getComputer(1));
        assertEquals(c3, labor.getComputer(2));
        assertEquals(3, labor.anzahlComputer());
    }

    @org.junit.jupiter.api.Test
    void einfuegenArrayVoll() {
        labor.hinzufuegen(c4);
        labor.hinzufuegen(c5);
        labor.hinzufuegen(c6);
        assertEquals(6, labor.anzahlComputer());

        labor.einfuegen(3, c7);
        assertEquals(c4, labor.getComputer(3));
        assertEquals(c5, labor.getComputer(4));
        assertEquals(c6, labor.getComputer(5));
        assertEquals(6, labor.anzahlComputer());
        System.out.println(labor);
    }

    @org.junit.jupiter.api.Test
    void vorhanden() {
        assertEquals(false, labor.vorhanden(c4));
        assertEquals(true, labor.vorhanden(c2));
    }

    @org.junit.jupiter.api.Test
    void entfernen() {
        System.out.println(labor);
        Computer c = labor.entfernen(1);
        assertEquals(2, labor.anzahlComputer());
        assertEquals(c, c2); // Rückgabewert von entfernen muss c2 sein!
        System.out.println(labor);
        assertEquals(c3, labor.getComputer(1));
    }

    // TODO

    @org.junit.jupiter.api.Test
    void entfernenMitNamen() {

    }

    }