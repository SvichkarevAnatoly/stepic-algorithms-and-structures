import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class Main {
    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        final List<Integer> primes = primeFactorization(n);

        String spaceSeparatedPrimes = primes.stream()
                .map(Object::toString)
                .collect(Collectors.joining(" "));
        System.out.print(spaceSeparatedPrimes);
    }

    private static List<Integer> primeFactorization(int n) {
        final LinkedList<Integer> primes = new LinkedList<>();

        int i = 2;
        while (i * i <= n) {
            if (n % i == 0) {
                primes.add(i);
                n /= i;
            } else {
                i++;
            }
        }
        primes.add(n);

        return primes;
    }
}