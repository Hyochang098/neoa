import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	static int ans, n, k;

	static int[] dy = { 1, -1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	static int[][] hill;
	static boolean[][] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			n = sc.nextInt();
			k = sc.nextInt();
			ans = 1;
			hill = new int[n][n];
			visited = new boolean[n][n];
			int max = 0;

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					hill[i][j] = sc.nextInt();
					max = Math.max(max, hill[i][j]);
				}
			}

			List<int[]> start = new ArrayList<>();

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (hill[i][j] == max) {
						start.add(new int[] { i, j });
					}
				}
			}

			for (int[] s : start) {
				int si = s[0];
				int sj = s[1];
				visited[si][sj] = true;
				boolean build = true;
				make(si, sj, 1, build);
				visited[si][sj]=false;
			}
			System.out.println("#" + tc + " " + ans);
		}
	}
	private static void make(int si, int sj, int range, boolean build) {
		ans = Math.max(ans, range);

		for (int i = 0; i < 4; i++) {
			int ny = si + dy[i];
			int nx = sj + dx[i];

			if (ny >= 0 && ny < n && nx >= 0 && nx < n && !visited[ny][nx]) {
				if (hill[ny][nx] < hill[si][sj]) {
					visited[ny][nx] = true;
					make(ny, nx, range + 1, build);
					visited[ny][nx] = false;
				}
				else if (build) {
					for (int cut = 1; cut <= k; cut++) {
						if (hill[ny][nx] - cut < hill[si][sj]) {
							int ori = hill[ny][nx];
							hill[ny][nx] -= cut;

							visited[ny][nx] = true;
							make(ny, nx, range + 1, false);
							visited[ny][nx] = false;

							hill[ny][nx] = ori;
						}
					}
				}
			}
		}
	}

//	private static void make(int si, int sj, int range, boolean build) {
//		ans = Math.max(ans, range);
//
//		for (int i = 0; i < 4; i++) {
//			int ny = si + dy[i];
//			int nx = sj + dx[i];
//			if (ny >= 0 && ny < n && nx >= 0 && nx < n && !visited[ny][nx] && hill[ny][nx] < hill[si][sj]) {
//				visited[ny][nx] = true;
//				make(ny, nx, range + 1, true);
//				visited[ny][nx] = false;
//			} else if (ny >= 0 && ny < n && nx >= 0 && nx < n && !visited[ny][nx] && build) {
//				for (int cut = 1; cut <= k; cut++) {
//					if (hill[ny][nx] - cut < hill[si][sj]) {
//						int ori = hill[ny][nx];
//						hill[ny][nx] -= cut;
//
//						visited[ny][nx] = true;
//						make(ny, nx, range + 1, false);
//						visited[ny][nx] = false;
//
//						hill[ny][nx] = ori;
//					}
//				}
//			}
//
//		}
//	}
}