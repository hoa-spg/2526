import static org.junit.jupiter.api.Assertions.*;

class LaborTest {

    private Labor labor;
    private Computer c1;
    private Computer c2;
    private Computer c3;
    private Computer c4;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        labor = new Labor("B3.10MF");
        c1 = new Computer("Lenovo", 1500, true);
        c2 = new Computer("Macbook", 2000, true);
        c3 = new Computer("Dell", 1700, false);
        c4 = new Computer("hp", 1300, false);
    }

    @org.junit.jupiter.api.Test
    void hinzufuegen() {
        labor.hinzufuegen(c1);
        labor.hinzufuegen(c2);
        System.out.println(labor);
    }

    @org.junit.jupiter.api.Test
    void entfernen() {
    }
}