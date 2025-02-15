import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			int n = sc.nextInt();
			int m = sc.nextInt();

			boolean[] stone = new boolean[n];
			for (int i = 0; i < n; i++) {
				int num = sc.nextInt();
				if (num == 1) {
					stone[i] = true;
				}
			}

			for (int i = 0; i < m; i++) {
				int start = sc.nextInt() - 1;
				int lange = sc.nextInt();
				for (int x = start; x < start + lange; x++) {
					if (x < n) {
						if (stone[start]) {
							stone[x] = true;
						} else {
							stone[x] = false;
						}
					}
				}
			}

			System.out.print("#" + tc + " ");
			for (boolean z : stone) {
				if (z) {
					System.out.print(1 + " ");
				} else {
					System.out.print(0 + " ");
				}
			}
			System.out.println();
		}
	}

}