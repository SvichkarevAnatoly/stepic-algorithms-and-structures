import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        final ArrayList<Integer> A = new ArrayList<>(n);
        final ArrayList<Integer> B = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            A.add(sc.nextInt());
        }
        for (int i = 0; i < n; i++) {
            B.add(sc.nextInt());
        }

        final List<Integer> ij = maxAiBj(A, B);
        System.out.print(ij.get(0) + " " + ij.get(1));
    }

    private static List<Integer> maxAiBj(List<Integer> A, List<Integer> B) {
        int n = A.size();
        int iMax = 0, jMax = 0, maxAi = 0;
        int curMax = A.get(iMax) + B.get(jMax);
        for (int j = 1; j < n; j++) {
            if (A.get(iMax) + B.get(j) > curMax) {
                jMax = j;
                curMax = A.get(iMax) + B.get(jMax);
            }
            if (A.get(j) + B.get(j) > curMax) {
                iMax = jMax = j;
                curMax = A.get(iMax) + B.get(jMax);
            }
            if (A.get(j) > A.get(maxAi)){
                maxAi = j;
            }
            if (A.get(maxAi) + B.get(j) > curMax) {
                iMax = maxAi;
                jMax = j;
                curMax = A.get(iMax) + B.get(jMax);
            }
        }

        final List<Integer> ij = new ArrayList<>();
        ij.add(iMax);
        ij.add(jMax);
        return ij;
    }
}