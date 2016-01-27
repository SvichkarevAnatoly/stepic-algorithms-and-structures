import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AlgorithmData {
    public final List<Integer> fruitMasses;
    public final int K;

    public AlgorithmData(Scanner sc) {
        fruitMasses = new ArrayList<>();
        final int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            fruitMasses.add(sc.nextInt());
        }
        K = sc.nextInt();
    }

    public AlgorithmData(List<Integer> fm, int K) {
        fruitMasses = fm;
        this.K = K;
    }
}
