
import java.util.Scanner;
import java.util.Stack;

public class Main {
	// 1662 - 압축
	// 압출된 문자열 S 를 보고 원래 문자열의 길이를 구한다.

	// K(Q) = Q가 K개
	// 33(562(71(9))) - 3567979567979567979
	// 제일 깊은 괄호에서 부터 나오면서 변환
	// 문자열을 돌면서 스택에 넣음 나오면서 해당 연산
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String str = sc.nextLine();

		System.out.println(restore(str));
	}

	private static int restore(String str) {
		Stack<Integer> stack = new Stack<>();
		int length = 0;
		int multi = 1;

		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);

			if (Character.isDigit(c)) {
				if (i + 1 < str.length() && str.charAt(i + 1) == '(') {
					multi = c - '0';
				} else {
					length++;
				}
			} else if (c == '(') {
				stack.push(length);
				stack.push(multi);
				length = 0;
				multi = 1;
			} else if (c == ')') {
				int prevm = stack.pop();
				int prevl = stack.pop();
				length = prevl + (length * prevm);
			}
		}

		return length;
	}
}