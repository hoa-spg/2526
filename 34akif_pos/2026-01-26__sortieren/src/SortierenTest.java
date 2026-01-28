import java.util.Random;

class SortierenTest {

    private int[] a = {3, -4, 9, 6, 0, -4, 5, 7, 1};

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        Random rnd = new Random();
        a = new int[100_000];
        for (int i=0; i<a.length; i++) {
            a[i] = rnd.nextInt(100_000);
        }
    }

    @org.junit.jupiter.api.Test
    void sortierenBubbleSortEinfach() {
//        System.out.println("Werte: ");
//        printArray(a);
        Sortieren.bubbleSort(a);
//        System.out.println("Sortiert: ");
//        printArray(a);

        for (int i=0; i<a.length-1; i++) {
            assert(a[i] <= a[i+1]);
        }
    }

    @org.junit.jupiter.api.Test
    void sortierenBubbleSortOptimiert() {
//        System.out.println("Werte: ");
//        printArray(a);
        Sortieren.bubbleSortOptimiert(a);
//        System.out.println("Sortiert: ");
//        printArray(a);

        for (int i=0; i<a.length-1; i++) {
            assert(a[i] <= a[i+1]);
        }
    }

    @org.junit.jupiter.api.Test
    void sortierenInsertionSort() {
        Sortieren.insertionSort(a);
        for (int i=0; i<a.length-1; i++) {
            assert(a[i] <= a[i+1]);
        }
    }

    @org.junit.jupiter.api.Test
    void sortierenSelectionSort() {
        Sortieren.selectionSort(a);
        for (int i=0; i<a.length-1; i++) {
            assert(a[i] <= a[i+1]);
        }
    }

    private void printArray(int[] a) {
        for (int i=0; i<a.length; i++) {
            System.out.print((i!=0 ? ", " : "") + a[i]);
        }
        System.out.println();
    }
}