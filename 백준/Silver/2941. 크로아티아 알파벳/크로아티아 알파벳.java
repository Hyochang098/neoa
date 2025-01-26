import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		int ans = str.length();

		for (int i = 0; i < str.length(); i++) {
			char s = str.charAt(i);

			if (s == 'c') {
				if (i + 1 < str.length()) {
					char t = str.charAt(i + 1);
					if (t == '=' || t == '-') {
						ans -= 1;
					}
				}
			} else if (s == 'z') {
				if (i + 1 < str.length()) {
					char t = str.charAt(i + 1);
					if (t == '=') {
						if (i - 1 >= 0) {
							char r = str.charAt(i - 1);
							if (r == 'd') {
								ans -= 2;
							} else {
								ans -= 1;
							}
						} else {
							ans -= 1;
						}
					}
				}
			} else if (s == 'd') {
				if (i + 1 < str.length()) {
					char t = str.charAt(i + 1);
					if (t == '-') {
						ans -= 1;
					}
				}
			} else if (s == 'l') {
				if (i + 1 < str.length()) {
					char t = str.charAt(i + 1);
					if (t == 'j') {
						ans -= 1;
					}
				}
			} else if (s == 'n') {
				if (i + 1 < str.length()) {
					char t = str.charAt(i + 1);
					if (t == 'j') {
						ans -= 1;
					}
				}
			} else if (s == 's') {
				if (i + 1 < str.length()) {
					char t = str.charAt(i + 1);
					if (t == '=') {
						ans -= 1;
					}
				}
			}
		}

		System.out.println(ans);
	}
}
