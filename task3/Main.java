import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static java.lang.Math.abs;

class Main {
    public static int binarySearch(List<Integer> A, int b) {
        if (b > A.get(A.size() - 1)) {
            return A.size() - 1;
        }

        int first = 0;
        int last = A.size();
        while (first < last) {
            int mid = (first + last) / 2;
            if (b <= A.get(mid)) {
                last = mid;
            } else {
                first = mid + 1;
            }
        }

        if (first > 0 && b < (A.get(first - 1) + A.get(first)) / 2.0) {
            first--;
        }

        while (first > 0 &&
                abs(A.get(first) - b) == abs(A.get(first - 1) - b)) {
            first--;
        }

        return first;
    }

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
            final int minIndex = binarySearch(A, bi);
            minIndexes.add(minIndex);
        }

        String spaceSeparatedIndexes = minIndexes.stream()
                .map(Object::toString)
                .collect(Collectors.joining(" "));
        System.out.print(spaceSeparatedIndexes);
    }
}