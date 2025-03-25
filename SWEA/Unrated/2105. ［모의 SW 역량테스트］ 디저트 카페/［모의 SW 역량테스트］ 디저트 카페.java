import java.util.Scanner;

public class Solution {
	static int n, des;
	static int[][] map;
	static boolean[] visited;
	static int[] dy = { 1, 1, -1, -1 };
	static int[] dx = { 1, -1, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			n = sc.nextInt();
			map = new int[n][n];
			des = -1;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					visited = new boolean[101];
					visited[map[i][j]] = true;
					dfs(i, j, i, j, 0, 1);
					visited[map[i][j]] = false;
				}
			}
			System.out.println("#" + tc + " " + des);
		}
	}

	static void dfs(int sy, int sx, int y, int x, int dir, int count) {
		int ny = y + dy[dir];
		int nx = x + dx[dir];
		if (ny == sy && nx == sx && count >= 4) {
			des = Math.max(des, count);
			return;
		}
		if (ny >= 0 && ny < n && nx >= 0 && nx < n && !visited[map[ny][nx]]) {
			visited[map[ny][nx]] = true;
			dfs(sy, sx, ny, nx, dir, count + 1);
			visited[map[ny][nx]] = false;
		}

		if (dir < 3) {
			int ndir = dir + 1;
			ny = y + dy[ndir];
			nx = x + dx[ndir];
			if (ny == sy && nx == sx && count >= 4) {
				des = Math.max(des, count);
				return;
			}
			if (ny >= 0 && ny < n && nx >= 0 && nx < n && !visited[map[ny][nx]]) {
				visited[map[ny][nx]] = true;
				dfs(sy, sx, ny, nx, ndir, count + 1);
				visited[map[ny][nx]] = false;
			}
		}

	}
}
