import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[][] lab;
	static int[][] sel = new int[3][2];
	static boolean[][] bisited;
	static boolean[][] visited;
	static Queue<int[]> q;

	static int[] dy = { 1, -1, 0, 0 };
	static int[] dx = { 0, 0, 1, -1 };
	static int ans = Integer.MIN_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		lab = new int[n][m];
		visited = new boolean[n][m];
		bisited = new boolean[n][m];
		q = new LinkedList<int[]>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				lab[i][j] = Integer.parseInt(st.nextToken());
				if (lab[i][j] == 2) {
					q.add(new int[] { i, j });
					visited[i][j] = true;
				}
			}
		}

		build(0);// 벽 세우기
		System.out.println(ans);
	}

	private static void build(int cur) {
		// TODO Auto-generated method stub
		if (cur == 3) {
			int[][] copylab = new int[n][m];
			boolean[][] qv = new boolean[n][m];
			for (int i = 0; i < n; i++) {
				System.arraycopy(lab[i], 0, copylab[i], 0, m);
				System.arraycopy(visited[i], 0, qv[i], 0, m);
			}
			Queue<int[]> que = new LinkedList<>();
			for (int[] a : q) {
				que.add(a);
			}
			for (int i = 0; i < 3; i++) {
				int y = sel[i][0];
				int x = sel[i][1];
				copylab[y][x] = 1;
			}
			bfs(copylab, que, qv);
			return;
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!bisited[i][j] && lab[i][j] == 0) {
					bisited[i][j] = true;
					sel[cur][0] = i;
					sel[cur][1] = j;
					build(cur + 1);
					bisited[i][j] = false;
				}
			}
		}

	}

	private static void bfs(int[][] ilab, Queue<int[]> que, boolean[][] qv) {
		// TODO Auto-generated method stub
		while (!que.isEmpty()) {
			int[] tmp = que.poll();
			int y = tmp[0];
			int x = tmp[1];
			for (int i = 0; i < 4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				if (ny >= 0 && ny < n && nx >= 0 && nx < m && ilab[ny][nx] != 1 && !qv[ny][nx]) {
					que.add(new int[] { ny, nx });
					ilab[ny][nx] = 2;
					qv[ny][nx] = true;
				}
			}
		}
		int safe = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (ilab[i][j] == 0) {
					safe++;
				}
			}
		}
		ans = Math.max(ans, safe);
	}
}
