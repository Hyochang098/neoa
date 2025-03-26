import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Solution {
	static class Node {
		int r, c, t;

		Node(int r, int c, int t) {
			this.r = r;
			this.c = c;
			this.t = t;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int r = sc.nextInt();
			int c = sc.nextInt();
			int l = sc.nextInt();
			int[][] grid = new int[n][m];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					grid[i][j] = sc.nextInt();
				}
			}
			int[][] dirs = new int[8][];
			dirs[0] = new int[0];
			dirs[1] = new int[] { 0, 1, 2, 3 };
			dirs[2] = new int[] { 0, 1 };
			dirs[3] = new int[] { 2, 3 };
			dirs[4] = new int[] { 0, 3 };
			dirs[5] = new int[] { 1, 3 };
			dirs[6] = new int[] { 1, 2 };
			dirs[7] = new int[] { 0, 2 };
			int[] opp = { 1, 0, 3, 2 };
			boolean[][] visited = new boolean[n][m];
			Queue<Node> q = new LinkedList<>();
			q.add(new Node(r, c, 1));
			visited[r][c] = true;
			int count = 1;
			while (!q.isEmpty()) {
				Node cur = q.poll();
				if (cur.t >= l)
					continue;
				int type = grid[cur.r][cur.c];
				for (int d : dirs[type]) {
					int nr = cur.r, nc = cur.c;
					if (d == 0)
						nr--;
					else if (d == 1)
						nr++;
					else if (d == 2)
						nc--;
					else if (d == 3)
						nc++;
					if (nr < 0 || nr >= n || nc < 0 || nc >= m)
						continue;
					if (visited[nr][nc] || grid[nr][nc] == 0)
						continue;
					boolean valid = false;
					for (int nd : dirs[grid[nr][nc]]) {
						if (nd == opp[d]) {
							valid = true;
							break;
						}
					}
					if (!valid)
						continue;
					visited[nr][nc] = true;
					q.add(new Node(nr, nc, cur.t + 1));
					count++;
				}
			}
			System.out.println("#" + tc + " " + count);
		}
	}
}
