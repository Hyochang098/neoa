import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int[][] location = new int[n][n];

		int high = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				location[i][j] = sc.nextInt();
				high = Math.max(high, location[i][j]);
			}
		}

		int[] dy = { 1, -1, 0, 0 };
		int[] dx = { 0, 0, -1, 1 };

		int water = 0;// 물높이
		int max_safe = 0;// 최대 안전지대

		Queue<int[]> que = new LinkedList<>();

		while (water <= high) {
			int safe = 0;// 안전지대
			boolean[][] visit = new boolean[n][n];// 방문체크
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (water < location[i][j] && !visit[i][j]) {
						que.add(new int[] { i, j });
						visit[i][j] = true;
						while (!que.isEmpty()) {
							int[] temp = que.poll();
							int y = temp[0];
							int x = temp[1];
							for (int k = 0; k < 4; k++) {
								int ny = y + dy[k];
								int nx = x + dx[k];
								if (ny >= 0 && ny < n && nx >= 0 && nx < n && !visit[ny][nx]
										&& location[ny][nx] > water) {
									que.add(new int[] { ny, nx });
									visit[ny][nx] = true;
								}
							}
						}
						safe++;
					}

				}
			}
			max_safe = Math.max(max_safe, safe);
			water++;
		}
		System.out.println(max_safe);
	}
}