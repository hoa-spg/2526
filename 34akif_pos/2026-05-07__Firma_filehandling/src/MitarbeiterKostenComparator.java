import java.util.Comparator;

public class MitarbeiterKostenComparator implements Comparator<Mitarbeiter> {

    @Override
        public int compare(Mitarbeiter m1, Mitarbeiter m2) {
        return m1.getKostenProMonat() - m2.getKostenProMonat();
    }

}
