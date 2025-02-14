import java.util.Scanner;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int tc = 1; tc <= 10; tc++) {
			int n = sc.nextInt();
			sc.nextLine();
			String str = sc.nextLine();
			StringBuilder sb = new StringBuilder();
			Stack<Character> cal = new Stack<>();

			for (int i = 0; i < n; i++) {
				char c = str.charAt(i);
				if (c == '(') {// (면
					cal.push(c);
				} else if (c == ')') {// )면
					while (cal.peek() != '(') {
						sb.append(cal.pop());
					}
					cal.pop();
				} else if ('0' <= c && c <= '9') {// 숫자면
					sb.append(c);
				} else {// 연산자
					if (cal.isEmpty()) {
						cal.push(c);
					} else {
						while (!cal.isEmpty() && cal.peek() != '(') {// 안비어있으면
							if ((c == '+' || c == '-') && (cal.peek() == '+' || cal.peek() == '-' || cal.peek() == '*'
									|| cal.peek() == '/')) {
								sb.append(cal.pop());
							} else if ((c == '*' || c == '/') && (cal.peek() == '*' || cal.peek() == '/')) {
								sb.append(cal.pop());
							} else {
								break;
							}
						}
						cal.push(c);

					}
				}
			}
			while (!cal.isEmpty()) {
				sb.append(cal.pop());
			}
			Stack<Integer> check = new Stack<>();
			for (int i = 0; i < sb.length(); i++) {
				if (sb.charAt(i) >= '0' && sb.charAt(i) <= '9') {
					check.push(sb.charAt(i) - '0');

				}else {
					int b= check.pop();
					int a= check.pop();
					
					switch(sb.charAt(i)) {
					case '+':
						check.push(a+b);
						break;
					case '-':
						check.push(a-b);
						break;
					case '*':
						check.push(a*b);
						break;
					case '/':
						check.push(a/b);
						break;
					}
				}
			}
			System.out.println("#"+tc+" "+check.pop());
		}
	}
}