public class Sitzplan {
    private String[][] plaetze;

    public Sitzplan() {
        plaetze = new String[5][];
        plaetze[0] = new String[2];
        plaetze[1] = new String[4];
        plaetze[2] = new String[8];
        plaetze[3] = new String[8];

        plaetze[0][1] = "AH";

        plaetze[1][2] = "JB";
        plaetze[2][1] = "BH";
        plaetze[2][2] = "LS";
        plaetze[2][5] = "MR";
        plaetze[3][4] = "SH";
        plaetze[3][5] = "FS";
        plaetze[3][6] = "JB";
        plaetze[3][7] = "MD";
    }

    @Override
    public String toString() {
        String str = "Sitzplan: \n";
        for (int i=0; i<plaetze.length; i++) {
            str += "Reihe " + i + ": \t";
            if (plaetze[i] != null) {
                for (int j = 0; j < plaetze[i].length; j++) {
                    if (plaetze[i][j] != null) {
                        str += plaetze[i][j] + "\t";
                    } else {
                        str += "  \t";
                    }
                }
            } else {
                str += "leere Reihe";
            }
            str += "\n";
        }
        return str;
    }
}
