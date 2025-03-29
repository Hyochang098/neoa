import java.util.Scanner;

public class Main {
	static String str;
	static boolean[] selected;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		str = sc.nextLine();
		selected = new boolean[str.length()];
		zoac(0, str.length() - 1);
	}

	static void zoac(int left, int right) {
		if (left > right) {
			return;
		}
		int idx = -1;
		char min = 'Z' + 1;

		for (int i = left; i <= right; i++) {
			if (!selected[i] && str.charAt(i) < min) {
				min = str.charAt(i);
				idx = i;
			}
		}

		selected[idx] = true;

		for (int i = 0; i < str.length(); i++) {
			if (selected[i])
				System.out.print(str.charAt(i));
		}
		System.out.println();

		zoac(idx + 1, right);
		zoac(left, idx - 1);
	}
}
