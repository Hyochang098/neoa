import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			String vps = sc.next();
			if (checking(vps)) {
				System.out.println("YES");
			} else
				System.out.println("NO");

		}
	}

	public static Boolean checking(String str) {
		int c = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '(') {
				c++;
			} else if (str.charAt(i) == ')') {
				c--;
			}
			if (c < 0)
				return false;
		}

		if (c == 0) {
			return true;
		} else {
			return false;
		}

	}

}
