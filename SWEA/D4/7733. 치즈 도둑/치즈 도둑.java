import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	static class cheeze {
		int y;
		int x;
		int taste;
		boolean live = true;

		public cheeze(int y, int x, int taste) {
			this.y = y;
			this.x = x;
			this.taste = taste;

		}
	}

	static int[] dy = { 1, -1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			int n = sc.nextInt();
			int max = 0;
			cheeze[][] cheze = new cheeze[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					int taste = sc.nextInt();
					max = Math.max(max, taste);
					cheze[i][j] = new cheeze(i, j, taste);
				}
			}
			int day = 0;
			int ans = 0;
			while (max-- > 0) {
				Queue<int[]> que = new ArrayDeque<>();
				boolean[][] visited = new boolean[n][n];
				int cnt = 0;// 매일 덩어리 갯수 초기화
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						if (cheze[i][j].taste > day && !visited[i][j]) {
							que.add(new int[] { i, j });
							visited[i][j] = true;
							cnt++;
							while (!que.isEmpty()) {
								int[] temp = que.poll();
								int y = temp[0];
								int x = temp[1];

								for (int k = 0; k < 4; k++) {
									int ny = y + dy[k];
									int nx = x + dx[k];

									if (ny >= 0 && ny < n && nx >= 0 && nx < n && !visited[ny][nx]
											&& cheze[ny][nx].taste > day) {
										visited[ny][nx] = true;
										que.add(new int[] { ny, nx });
									}
								}
							}
						}
					}
				}
				ans = Math.max(ans, cnt);
				day++;
			}
			System.out.println("#"+tc+" " + ans);
		}
	}
}