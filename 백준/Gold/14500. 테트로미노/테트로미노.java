import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[][] paper;
	static boolean[][] visited;
	static int max = 0;

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		paper = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				visited[i][j] = true;
				dfs(i, j, paper[i][j], 1);
				visited[i][j] = false;
				special(i, j);
			}
		}

		System.out.println(max);
	}

	static void dfs(int x, int y, int sum, int count) {
		if (count == 4) {
			max = Math.max(max, sum);
			return;
		}

		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];

			if (nx < 0 || ny < 0 || nx >= N || ny >= M)
				continue;
			if (visited[nx][ny])
				continue;

			visited[nx][ny] = true;
			dfs(nx, ny, sum + paper[nx][ny], count + 1);
			visited[nx][ny] = false;
		}
	}

	static void special(int x, int y) {
		int[][][] extra = { { { 0, 0 }, { 0, 1 }, { 0, 2 }, { 1, 1 } }, { { 0, 0 }, { 1, 0 }, { 2, 0 }, { 1, 1 } },
				{ { 0, 0 }, { 0, 1 }, { 0, 2 }, { -1, 1 } }, { { 0, 0 }, { 1, 0 }, { 2, 0 }, { 1, -1 } } };

		for (int[][] shape : extra) {
			int sum = 0;
			boolean valid = true;

			for (int[] d : shape) {
				int nx = x + d[0];
				int ny = y + d[1];

				if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
					valid = false;
					break;
				}

				sum += paper[nx][ny];
			}

			if (valid)
				max = Math.max(max, sum);
		}
	}
}
