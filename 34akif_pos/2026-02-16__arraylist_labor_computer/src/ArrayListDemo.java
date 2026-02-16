import java.util.ArrayList;

public class ArrayListDemo {

    public static void main(String[] args) {
        ArrayList<String> namen = new ArrayList<>();
        namen.add("Lisa");
        namen.add("Peter");
        namen.add("Norbert");
        System.out.println(namen);

        ArrayList<MeinInteger> zahlen = new ArrayList<>();
        zahlen.add(new MeinInteger(45));
        zahlen.add(new MeinInteger(33));
        zahlen.add(new MeinInteger(78));
        System.out.println(zahlen);

        int summe = 0;
        for (MeinInteger mi: zahlen) {
            summe += mi.getWert(); // un-boxing
        }
        System.out.println("Summe: " + summe);

        // Integer: auto-boxing, auto-unboxing
        ArrayList<Integer> bessereZahlen = new ArrayList<>();
        bessereZahlen.add(45);
        bessereZahlen.add(33);
        bessereZahlen.add(78);

        summe = 0;
        for (Integer i: bessereZahlen) {
            summe += i; // un-boxing
        }
        System.out.println("Summe: " + summe);
    }
}
