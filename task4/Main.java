import java.util.Deque;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        boolean allMatch = true;
        final Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            final int a = sc.nextInt();
            final int b = sc.nextInt();

            allMatch = dequeAction(deque, a, b);
            if (!allMatch) {
                break;
            }
        }
        if (allMatch) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    public static boolean dequeAction(Deque<Integer> deque, int a, int b) {
        switch (a) {
            case 1:
                deque.addFirst(b);
                break;
            case 2:
                return popFront(deque, b);
            case 3:
                deque.addLast(b);
                break;
            case 4:
                return popBack(deque, b);
        }
        return true;
    }

    private static boolean popBack(Deque<Integer> deque, int b) {
        int actualB;
        try {
            actualB = deque.getLast();
            deque.removeLast();
            if (actualB != b) {
                return false;
            }
        } catch (NoSuchElementException e) {
            if (b != -1) {
                return false;
            }
        }
        return true;
    }

    private static boolean popFront(Deque<Integer> deque, int b) {
        int actualB;
        try {
            actualB = deque.getFirst();
            deque.removeFirst();
            if (actualB != b) {
                return false;
            }
        } catch (NoSuchElementException e) {
            if (b != -1) {
                return false;
            }
        }
        return true;
    }
}
