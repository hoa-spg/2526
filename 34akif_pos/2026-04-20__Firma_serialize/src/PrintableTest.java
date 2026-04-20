import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PrintableTest {

    @Test
    void print() {
        try {
            Mitarbeiter m1 = new Arbeiter("Max", 1990, 20, 25, true);
            Mitarbeiter m2 = new Arbeiter("Manuela", 1990, 20, 25, true);

            Firma f = new Firma();
            f.einstellen(m2);
//            f.print();
//            m1.print();
            ArrayList<Printable> printableArrayList = new ArrayList<>();
            printableArrayList.add(m1);
            printableArrayList.add(f);

            for (Printable p : printableArrayList) {
                p.print();
            }

        } catch (FirmaException e) {
            throw new RuntimeException(e);
        }

    }
}