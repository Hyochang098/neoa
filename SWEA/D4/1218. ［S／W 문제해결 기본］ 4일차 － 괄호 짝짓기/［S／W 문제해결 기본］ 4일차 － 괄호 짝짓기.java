import java.util.Scanner;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {
			int n = sc.nextInt();
			sc.nextLine();
			String str = sc.nextLine();

			boolean check = true;

			Stack<Character> stack = new Stack<>();
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == '[' || str.charAt(i) == '{' || str.charAt(i) == '(' || str.charAt(i) == '<') {
					stack.push(str.charAt(i));
				} else if (str.charAt(i) == ']') {
					if (stack.peek() == '[') {
						stack.pop();
					} else {
						check = false;
						break;
					}
				} else if (str.charAt(i) == '}') {
					if (stack.peek() == '{') {
						stack.pop();
					} else {
						check = false;
						break;
					}
				} else if (str.charAt(i) == ')') {
					if (stack.peek() == '(') {
						stack.pop();
					} else {
						check = false;
						break;
					}
				} else if (str.charAt(i) == '>') {
					if (stack.peek() == '<') {
						stack.pop();
					} else {
						check = false;
						break;
					}
				}
			}
			if(check)
				System.out.println("#"+tc+" "+1);
			else
				System.out.println("#"+tc+" "+0);

		}
	}
}