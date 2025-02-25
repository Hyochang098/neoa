import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        String str = sc.nextLine();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (c >= 'A' && c <= 'Z') {
                sb.append(c);
            } else if (c == '(') {
                stack.add(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    sb.append(stack.pop());
                }
                stack.pop();
            } else {
                while (!stack.isEmpty()) {
                    char top = stack.peek();
                    if ((c == '+' || c == '-') && (top == '+' || top == '-' || top == '*' || top == '/')) {
                        sb.append(stack.pop());
                    } else if ((c == '*' || c == '/') && (top == '*' || top == '/')) {
                        sb.append(stack.pop());
                    } else {
                        break;
                    }
                }
                stack.add(c);
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        System.out.println(sb.toString());
    }
}
