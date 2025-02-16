import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			int n = sc.nextInt();

			String[][] water = new String[n][n];

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					water[i][j] = sc.next();
				}
			}

			int[] dy = { 1, -1, 0, 0, 1, 1, -1, -1 };
			int[] dx = { 0, 0, 1, -1, 1, -1, 1, -1 };

			int max = 1;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (water[i][j].equals("W")) {
						int cnt = 0;
						for (int k = 0; k < 8; k++) {
							int ny = i + dy[k];
							int nx = j + dx[k];
							if (0 <= ny && ny < n && 0 <= nx && nx < n && water[ny][nx].equals("W")) {
								cnt++;
							}							
						}
						max = Math.max(max, cnt);
					}
				}
			}
			System.out.println("#" + tc + " " + max);
		}
	}
}