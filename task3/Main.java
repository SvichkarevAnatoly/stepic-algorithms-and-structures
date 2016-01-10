import java.util.*;
import java.util.stream.Collectors;

class Main {
    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        int nA = sc.nextInt();
        final ArrayList<Integer> A = new ArrayList<>(nA);
        for (int i = 0; i < nA; i++) {
            A.add(sc.nextInt());
        }
        int nB = sc.nextInt();
        final List<Integer> minIndexes = new LinkedList<>();
        for (int i = 0; i < nB; i++) {
            int bi = sc.nextInt();
            final int minIndex = Collections.binarySearch(A, bi,
                    (i1, i2)-> i1 - i2); // TODO
            minIndexes.add(minIndex);
        }

        String spaceSeparatedPrimes = minIndexes.stream()
                .map(Object::toString)
                .collect(Collectors.joining(" "));
        System.out.print(spaceSeparatedPrimes);
    }
}