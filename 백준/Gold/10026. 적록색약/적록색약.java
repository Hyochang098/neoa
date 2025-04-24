import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int n;
	static char[][] picture;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		sc.nextLine();

		picture = new char[n][n];
		for (int i = 0; i < n; i++) {
			String line = sc.nextLine();
			for (int j = 0; j < n; j++) {
				picture[i][j] = line.charAt(j);
			}
		}

		int cnt = normal(picture);

		char[][] adnormal = new char[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				adnormal[i][j] = (picture[i][j] == 'G') ? 'R' : picture[i][j];
			}
		}
		int count = normal(adnormal);

		System.out.println(cnt + " " + count);
	}

	private static int normal(char[][] pic) {
		boolean[][] visited = new boolean[n][n];
		int regions = 0;

		for (int y = 0; y < n; y++) {
			for (int x = 0; x < n; x++) {
				if (!visited[y][x]) {
					bfs(y, x, pic[y][x], pic, visited);
					regions++;
				}
			}
		}

		return regions;
	}

	private static void bfs(int startY, int startX, char color, char[][] pic, boolean[][] visited) {
		int[] dy = { -1, 1, 0, 0 };
		int[] dx = { 0, 0, -1, 1 };

		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] { startY, startX });
		visited[startY][startX] = true;

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int y = cur[0], x = cur[1];

			for (int d = 0; d < 4; d++) {
				int ny = y + dy[d];
				int nx = x + dx[d];
				if (ny >= 0 && ny < n && nx >= 0 && nx < n && !visited[ny][nx] && pic[ny][nx] == color) {
					visited[ny][nx] = true;
					queue.add(new int[] { ny, nx });
				}
			}
		}
	}
}
