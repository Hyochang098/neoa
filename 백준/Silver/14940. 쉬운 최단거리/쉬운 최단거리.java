import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st1 = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st1.nextToken());
		int m = Integer.parseInt(st1.nextToken());
		int[][] map = new int[n][m];

		boolean[][] visited = new boolean[n][m];
		Queue<int[]> que = new ArrayDeque<>();

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					que.add(new int[] { i, j });
					visited[i][j] = true;
					map[i][j] = 0;
				}
			}
		}

		int[] dy = new int[] { 1, -1, 0, 0 };
		int[] dx = new int[] { 0, 0, -1, 1 };
		while (!que.isEmpty()) {
			int size = que.size();
			for (int i = 0; i < size; i++) {
				int[] temp = que.poll();
				int y = temp[0];
				int x = temp[1];

				for (int j = 0; j < 4; j++) {
					int ny = y + dy[j];
					int nx = x + dx[j];

					if (0 <= ny && ny < n && 0 <= nx && nx < m && map[ny][nx] == 1 && !visited[ny][nx]) {
						que.add(new int[] { ny, nx });
						visited[ny][nx] = true;
						map[ny][nx] = map[y][x] + 1;
					}
				}
			}
		}
		for (int i = 0; i < n; i++) {
			if (i != 0)
				sb.append("\n");
			for (int j = 0; j < m; j++) {
				if (!visited[i][j] && map[i][j] == 1) {
					map[i][j] = -1;
				}
				sb.append(map[i][j]).append(" ");

			}
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}
