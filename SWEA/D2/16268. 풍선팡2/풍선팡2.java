import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] poong = new int[n][m];

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					poong[i][j] = sc.nextInt();
				}
			}

			int[] dy = { 1, -1, 0, 0 };
			int[] dx = { 0, 0, 1, -1 };

			int ans = Integer.MIN_VALUE;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					int paper = poong[i][j];
					for (int k = 0; k < 4; k++) {
						int ny = i + dy[k];
						int nx = j + dx[k];
						if (0 <= ny && ny < n && 0 <= nx && nx < m) {
							paper += poong[ny][nx];
						}

					}
					ans = Math.max(ans, paper);
				}
			}
			System.out.println("#" + tc + " " + ans);
		}
	}

}