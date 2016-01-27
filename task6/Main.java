import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        final AlgorithmData ad = new AlgorithmData(sc);

        final Heap heap = new HeapImpl(ad.fruitMasses);
        final int approaches = measureApproaches(heap, ad.K);

        System.out.println(approaches);
    }

    private static int measureApproaches(Heap heap, int k) {
        int numApproaches = 0;
        while (!heap.isEmpty()) {
            final ArrayList<Integer> selectedFruits = new ArrayList<>();
            for (int i = 0; i < k; i++) {
                final int fruitMass = heap.extractMax();
                final int cutFruitMass = (fruitMass + 1) / 2;
                if (cutFruitMass != 1) {
                    selectedFruits.add(cutFruitMass);
                }
            }
            heap.addAll(selectedFruits);
            numApproaches++;
        }
        return numApproaches;
    }
}
