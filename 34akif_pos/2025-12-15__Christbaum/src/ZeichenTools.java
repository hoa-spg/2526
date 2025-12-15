public class ZeichenTools {

    public static String erzeugeLinie(int laenge, char zeichen) {
        return ZeichenTools.erzeugeLinie(laenge, zeichen, zeichen);
    }

    public static String erzeugeLinie(int laenge, char zeichen, char rand) {
        String str = "";
        for (int i=0; i<laenge; i++) {
            if (i == 0 || i == laenge-1) {
                str += " " + rand;
            } else {
                str += " " + zeichen;
            }
        }
        return str;
    }

}
