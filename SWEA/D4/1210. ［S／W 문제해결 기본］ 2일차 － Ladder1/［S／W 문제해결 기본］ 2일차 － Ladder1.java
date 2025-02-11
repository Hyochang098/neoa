import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int t = 0; t < 10; t++) {
			int tc = sc.nextInt();

			int[][] ladder = new int[100][100];
			int xh = 0;
			int xw = 0;
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					ladder[i][j] = sc.nextInt();
					if (ladder[i][j] == 2) {
						xh = i;
						xw = j;
					}
				}
			}

			boolean[][] visited = new boolean[100][100];
			visited[xh][xw] = true;
			while (xh > 0) {
				if (xw > 0 && ladder[xh][xw - 1] == 1 && !visited[xh][xw - 1]) {
					while (xw > 0 && ladder[xh][xw - 1] != 0) {
						--xw;
						visited[xh][xw] = true;
					}
				} else if (xw < 99 && ladder[xh][xw + 1] == 1 && !visited[xh][xw + 1]) {
					while (xw < 99 && ladder[xh][xw + 1] != 0) {
						++xw;
						visited[xh][xw] = true;
					}
				}
				xh--;

			}

			System.out.println("#" + tc + " " + xw);

		}

	}
}