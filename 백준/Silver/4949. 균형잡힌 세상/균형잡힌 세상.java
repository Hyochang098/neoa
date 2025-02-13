import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		while (true) {
			String str = br.readLine();
			if (str.equals("."))
				break;
			Stack<Character> stack = new Stack<>();
			boolean check = true;

			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == '[' || str.charAt(i) == '(') {
					stack.push(str.charAt(i));
				}
				if (str.charAt(i) == ']') {
					if (!stack.isEmpty() && stack.peek() == '[') {
						stack.pop();
					} else {
						check = false;
						break;
					}
				}
				if (str.charAt(i) == ')') {
					if (!stack.isEmpty() && stack.peek() == '(') {
						stack.pop();
					} else {
						check = false;
						break;
					}
				}
			}
			if (!stack.isEmpty())
				check = false;
			if (check)
				sb.append("yes").append("\n");
			else
				sb.append("no").append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}