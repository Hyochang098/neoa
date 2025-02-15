import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		sc.nextLine();
		for (int tc = 1; tc <= t; tc++) {
			String a = sc.next();
			String b = sc.next();

			boolean kyung = true;

			if (a.length() != b.length()) {
				kyung = false;
			} else {
				for (int i = 0; i < a.length(); i++) {
					if (tran(a.charAt(i)) != tran(b.charAt(i))) {
						kyung = false;
						break;
					}
				}
			}
			if (kyung) {
				System.out.println("#" + tc + " " + "SAME");
			} else {
				System.out.println("#" + tc + " " + "DIFF");
			}

		}
	}

	static char tran(char a) {
		char result = 'a';
		switch (a) {
		case 'A':
		case 'D':
		case 'O':
		case 'P':
		case 'Q':
		case 'R':
			result = 'A';
			break;
		case 'B':
			result = 'B';
			break;
		default:
			result = 'C';
			break;
		}
		return result;
	}

}