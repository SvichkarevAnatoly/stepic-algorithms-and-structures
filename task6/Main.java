import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        final AlgorithmData ad = new AlgorithmData(sc);

        final Heap heap = new HeapImpl(ad.fruitMasses);
        final int approaches = measureApproaches(heap, ad.K);

        System.out.println(approaches);
    }

    public static int measureApproaches(Heap heap, int k) {
        int numApproaches = 0;
        int sumMass = 0;
        List<Integer> restedFruits = new ArrayList<>();
        boolean isApproaches = false;
        while (!heap.isEmpty()) {
            isApproaches = true;
            final int fruitMass = heap.popMax();
            if (sumMass + fruitMass <= k) {
                sumMass += heap.extractMax();
                if (fruitMass != 1) {
                    final int cutFruitMass = (fruitMass + 1) / 2;
                    restedFruits.add(cutFruitMass);
                }
            } else {
                heap.addAll(restedFruits);
                restedFruits = new ArrayList<>();
                sumMass = 0;
                numApproaches++;
                isApproaches = false;
            }
        }
        if (isApproaches) {
            numApproaches++;
        }
        return numApproaches;
    }
}
