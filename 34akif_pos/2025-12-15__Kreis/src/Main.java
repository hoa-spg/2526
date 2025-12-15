public class Main {
    public static void main(String[] args) {
        Kreis k = null;
        if (args.length > 0) {
            k = new Kreis(Integer.parseInt(args[0]));
        } else {
            k = new Kreis();
        }
        k.zeichnen();
    }
}
