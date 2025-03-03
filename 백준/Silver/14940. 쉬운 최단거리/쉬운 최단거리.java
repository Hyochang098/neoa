import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[][] map;

	static int[][] time;
	static boolean[][] visited;

	static int[] dy = { 1, -1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	static Queue<int[]> que;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		time = new int[n][m];
		visited = new boolean[n][m];
		que = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					que.add(new int[] { i, j });
					visited[i][j] = true;
					time[i][j] = 0;
				}
			}
		}
		bfs();

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (visited[i][j]) {
					sb.append(time[i][j]).append(" ");
				} else if (map[i][j] == 1 && !visited[i][j]) {
					sb.append(-1).append(" ");
				}else if(!visited[i][j]) {
					sb.append(0).append(" ");
				}
			}
			sb.append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}

	private static void bfs() {
		// TODO Auto-generated method stub
		while (!que.isEmpty()) {
			int[] temp = que.poll();
			int y = temp[0];
			int x = temp[1];

			for (int i = 0; i < 4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				if (ny >= 0 && ny < n && nx >= 0 && nx < m&& !visited[ny][nx] && map[ny][nx] == 1) {
					que.add(new int[] { ny, nx });
					visited[ny][nx] = true;
					time[ny][nx] = time[y][x] + 1;
				}
			}

		}

	}
}