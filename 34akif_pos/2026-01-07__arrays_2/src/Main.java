public class Main {

    public static void main(String[] args) {
        Messwerte messwerte = new Messwerte();
        System.out.println(messwerte);
        messwerte.messwertHinzufuegen(13);
        System.out.println(messwerte);
        messwerte.messwertHinzufuegen(7);
        System.out.println(messwerte);
    }

}