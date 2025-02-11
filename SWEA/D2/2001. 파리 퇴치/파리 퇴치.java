import java.util.Scanner;

public class Solution {
	static int[] dy = { 0, 1, 1 };
	static int[] dx = { 1, 0, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		for (int tc = 1; tc <= 10; tc++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] fly = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					fly[i][j] = sc.nextInt();
				}
			}

			int caught = 0;

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					int temp = 0;
					for (int k = i; k <i+m; k++) {
						for (int o = j; o <j+m; o++) {
							int ny = k;
							int nx = o;
							if (0 <= ny && ny < n && 0 <= nx && nx < n) {
								temp += fly[ny][nx];
							}
						}
					}
					if (caught < temp) {
						caught = temp;
					}
				}

			}
			System.out.println("#" + tc + " " + caught);
		}
	}
}