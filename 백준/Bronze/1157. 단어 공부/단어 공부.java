import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine().toUpperCase();
		int[] arr = new int[26];
		for (char ch : str.toCharArray()) {
			if (ch >= 'A' && ch <= 'Z') {
				arr[ch - 'A']++;
			}
		}

		int max = 0, idx = -1;
		boolean check = true;
		for (int i = 0; i < 26; i++) {
			if (arr[i] > max) {
				max = arr[i];
				idx = i;
				check = true;
			} else if (arr[i] == max) {
				check = false;
			}
		}
		if (check)
			System.out.println((char) (idx + 'A'));
		else
			System.out.println("?");
	}
}
