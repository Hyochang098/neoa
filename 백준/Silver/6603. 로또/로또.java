import java.util.Scanner;

public class Main {
	static int n;
	static int[] lotto;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			n = sc.nextInt();
			if (n == 0) {
				return;
			}
			lotto = new int[n];
			for (int i = 0; i < n; i++) {
				lotto[i] = sc.nextInt();
			}
			bt(0, 0, new int[6]);
			System.out.println();
		}
	}

	private static void bt(int cur, int start, int[] selected) {
		if (cur == 6) {
			for (int i = 0; i < 6; i++) {
				System.out.print(selected[i] + " ");
			}
			System.out.println();
			return;
		}

		for (int i = start; i < n; i++) {
			selected[cur] = lotto[i]; 
			bt(cur + 1, i + 1, selected); 
		}
	}
}
