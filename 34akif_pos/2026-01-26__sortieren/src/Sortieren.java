public class Sortieren {

    public static void bubbleSort(int[] a) {
        boolean vertauscht = true;
        while (vertauscht) {
            vertauscht = false;
            for (int i = 0; i < a.length - 1; i++) {
                if (a[i + 1] < a[i]) {
                    vertauschen(a, i, i + 1);
                    vertauscht = true;
                }
            }
        }
    }

    public static void bubbleSortOptimiert(int[] a) {
        boolean vertauscht = true;
        int durchlauf = 1;
        while (vertauscht) {
            vertauscht = false;
            for (int i = 0; i < a.length - durchlauf; i++) {
                if (a[i + 1] < a[i]) {
                    vertauschen(a, i, i + 1);
                    vertauscht = true;
                }
            }
            durchlauf++;
        }
    }

    public static void insertionSort(int[] a) {
        for (int i=1; i<a.length; i++) {
            for (int j=i; j>0; j--) {
                if (a[j] < a[j-1]) {
                    vertauschen(a, j, j-1);
                } else {
                    break;
                }
            }
        }
    }

    public static void selectionSort(int[] a) {
        for (int i=0; i<a.length-1; i++) {
            int jMin = i;
            for (int j=i+1; j<a.length; j++) {
                if (a[j] < a[jMin]) {
                    jMin = j;
                }
            }
            vertauschen(a, i, jMin);
        }
    }

    private static void vertauschen(int[] a, int i, int j) {
        if (i < a.length && j < a.length) {
            int tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
        } else {
            System.out.println("FEHLER: ungueltige Indizes in Methode vertauschen.");
        }
    }
}
