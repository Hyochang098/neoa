import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			int n = sc.nextInt();
			int[][] map = new int[n][n];

			int snail = 1;

			int dir = 1;

			int j = 0;

			int i = 0;
			while (snail <= n * n) {
				map[i][j] = snail++;
				if (dir == 1 && (j == n - 1 || map[i][j + 1] != 0))// 하
					dir = 2;
				if (dir == 2 && (i == n - 1 || map[i + 1][j] != 0))// 좌
					dir = 3;
				if (dir == 3 && (j == 0 || map[i][j - 1] != 0))// 상
					dir = 4;
				if (dir == 4 && (i == 0 || map[i - 1][j] != 0))
					dir = 1;
				switch (dir) {
                case 1: // 우
                    ++j;
                    break;
                case 2: // 하
                    ++i;
                    break;
                case 3: // 좌
                    --j;
                    break;
                case 4: // 상
                    --i;
                    break;
            }
			}

			System.out.println("#" + tc);

			for (int k = 0; k < n; k++) {
				for (int m : map[k]) {
					System.out.print(m + " ");
				}
				System.out.println();
			}
		}
	}
}