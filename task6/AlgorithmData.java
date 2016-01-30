import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AlgorithmData {
    public List<Integer> fruitMasses;
    public int K;

    public AlgorithmData(String dataStr) {
        final Scanner sc = new Scanner(dataStr);
        parse(sc);
    }

    public AlgorithmData(Scanner sc) {
        parse(sc);
    }

    private void parse(Scanner sc) {
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
