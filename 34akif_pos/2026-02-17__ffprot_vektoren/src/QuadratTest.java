import static org.junit.jupiter.api.Assertions.*;

class QuadratTest {

    private Quadrat q;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        q = new Quadrat(3);
        // System.out.println(q);
    }

    @org.junit.jupiter.api.Test
    void printVsToString() {

        String str = q.toString();
        System.out.println(str);

        q.print();

        String s2 = "XXX" + str.toUpperCase().substring(5) + "YYY";
        System.out.println(s2);
    }

}