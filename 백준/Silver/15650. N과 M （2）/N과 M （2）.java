import java.util.Scanner;

public class Main {
	static int n, k;

	static int[] arr, sel;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		k = sc.nextInt();

		arr = new int[n];
		sel = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = i + 1;
		}

		recur(0, 0);
	}

	private static void recur(int cur, int start) {
		// TODO Auto-generated method stub
		if (cur == k) {
			for (int i = 0; i < k; i++) {
				System.out.print(sel[i] + " ");
			}
			System.out.println();
			return;
		}
		for (int i = start; i < n; i++) {
			sel[cur] = arr[i];
			recur(cur + 1, i + 1);
		}
	}
}