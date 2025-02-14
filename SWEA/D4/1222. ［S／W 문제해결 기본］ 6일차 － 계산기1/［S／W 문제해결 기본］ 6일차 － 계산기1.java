import java.util.Scanner;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int tc = 1; tc <= 10; tc++) {
			int n = sc.nextInt();
			sc.nextLine();
			String str = sc.nextLine();
			Stack<Character> cal = new Stack<>();
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < n; i++) {
				if ('0' <= str.charAt(i) && str.charAt(i) <= '9') {
					sb.append(str.charAt(i));
				} else {
					if (cal.isEmpty())
						cal.push(str.charAt(i));
					else {
						sb.append(cal.pop());
						cal.push(str.charAt(i));
					}

				}
			}
			while (!cal.isEmpty()) {
				sb.append(cal.pop());
			}
			
			Stack<Integer> stack = new Stack<>();
			for(int i=0;i<sb.length();i++) {
				if('0'<=sb.charAt(i)&&sb.charAt(i)<='9') {
					stack.push(sb.charAt(i)-'0');
				}else {
					int b=stack.pop();
					int a=stack.pop();
					stack.push(a+b);
				}
			}

			System.out.println("#"+tc+" "+stack.pop());
		}
	}
}