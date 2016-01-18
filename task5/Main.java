import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        final String inputString = sc.nextLine();

        final Stack<Character> stack = firstSelection(inputString);
        final String outputString = supplementBracketsString(inputString, stack);

        System.out.println(outputString);
    }

    private static String supplementBracketsString(String inputString, Stack<Character> stack) {
        boolean isCorrectString = true;
        boolean isEndElongation = true;
        final StringBuilder endRestoredString = new StringBuilder(inputString);
        final StringBuilder beginRestoredString = new StringBuilder();
        while (!stack.empty()) {
            final char c = stack.pop();
            if (isEndElongation) {
                if (!isClosed(c)) {
                    endRestoredString.append(pairBracket(c));
                } else {
                    isEndElongation = false;
                    beginRestoredString.append(pairBracket(c));
                }
            }else {
                if (isClosed(c)){
                    beginRestoredString.append(pairBracket(c));
                } else {
                    isCorrectString = false;
                    break;
                }
            }
        }
        final String outputString;
        if (!isCorrectString) {
            outputString = "IMPOSSIBLE";
        } else {
            outputString = beginRestoredString.toString() + endRestoredString.toString();
        }
        return outputString;
    }

    private static Stack<Character> firstSelection(String inputString) {
        final Stack<Character> stack = new Stack<>();
        stack.push(inputString.charAt(0));
        for (int i = 1; i < inputString.length(); i++) {
            final char b = inputString.charAt(i);
            if (!stack.empty()) {
                final char a = stack.peek();
                if (isPairBracket(a, b) && isClosed(b)) {
                    stack.pop();
                } else {
                    stack.push(b);
                }
            } else {
                stack.push(b);
            }
        }
        return stack;
    }

    private static char pairBracket(char c) {
        switch (c) {
            case '[':
                return ']';
            case '{':
                return '}';
            case '(':
                return ')';
            case ']':
                return '[';
            case '}':
                return '{';
            case ')':
                return '(';
        }
        return 'x';
    }

    private static boolean isPairBracket(char c1, char c2) {
        return c1 == '[' && c2 == ']' ||
                c1 == '{' && c2 == '}' ||
                c1 == '(' && c2 == ')' ||
                c2 == '[' && c1 == ']' ||
                c2 == '{' && c1 == '}' ||
                c2 == '(' && c1 == ')';
    }

    private static boolean isClosed(char c) {
        return ")]}".indexOf(c) != -1;
    }
}
