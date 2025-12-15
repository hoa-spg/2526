import java.util.Random;

public class ZeichenTools {

    public static String erzeugeChristbaumLinie(int laenge, char zeichen, char kugel, char kerze) {
        return ZeichenTools.erzeugeLinie(laenge, zeichen, zeichen, kugel, kerze);
    }

    public static String erzeugeLinie(int laenge, char zeichen) {
        return ZeichenTools.erzeugeLinie(laenge, zeichen, zeichen, zeichen, zeichen);
    }

    public static String erzeugeLinie(int laenge, char zeichen, char rand, char kugel, char kerze) {
        String str = "";
        for (int i=0; i<laenge; i++) {
            if (i == 0 || i == laenge-1) {
                str += " " + rand;
            } else {
                Random random = new Random();
                int r = random.nextInt(10);
                if (r < 1) {
                    str += " " + kugel;
                } else if (r < 2) {
                    str += " " + kerze;
                } else {
                    str += " " + zeichen;
                }
            }
        }
        return str;
    }

}
