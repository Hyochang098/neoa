import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		for (int tc = 1; tc <= t; tc++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			sc.nextLine();

			int[][] check = new int[n][3];
			for (int i = 0; i < n; i++) {
				String temp = sc.nextLine();
				for (int j = 0; j < m; j++) {
					char russia = temp.charAt(j);
					if (russia == 'W') {
						check[i][0]++;
					} else if (russia == 'B') {
						check[i][1]++;
					} else if (russia == 'R') {
						check[i][2]++;
					}
				}
			}
			int sum = 0;
			sum = check[0][2] + check[0][1] + check[n - 1][1] + check[n - 1][0];
			int min = Integer.MAX_VALUE;
			for (int i = 1; i < n - 1; i++) {
				for (int j = i; j < n - 1; j++) {
					int w_c = 0;
					int b_c = 0;
					int r_c = 0;
					for (int k = 1; k < i; k++) {
						w_c += check[k][1] + check[k][2];
					}
					for (int k = i; k <= j; k++) {
						b_c += check[k][0] + check[k][2];
					}
					for (int k = j + 1; k < n - 1; k++) {
						r_c += check[k][0] + check[k][1];
					}

					min = Math.min(min, w_c + b_c + r_c);
				}
			}
			System.out.println("#" + tc + " " + (sum + min));
		}
	}
}
