import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] room;
	static int r, c, t, dust, up, down;

	static int[] dy = { -1, 1, 0, 0 }; // 상하좌우
	static int[] dx = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		room = new int[r][c];

		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < c; j++) {
				room[i][j] = Integer.parseInt(st.nextToken());
				if (room[i][j] == -1) {
					if (up == 0)
						up = i;
					else
						down = i;
				}
			}
		}

		while (t-- > 0) {
			spread();
			upcleaning();
			downcleaning();
		}

		int sum = 0;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (room[i][j] > 0)
					sum += room[i][j];
			}
		}
		System.out.println(sum);
	}

	static void spread() {
		int[][] temp = new int[r][c];

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (room[i][j] > 0) {
					int amount = room[i][j] / 5;
					int count = 0;

					for (int d = 0; d < 4; d++) {
						int ny = i + dy[d];
						int nx = j + dx[d];

						if (ny >= 0 && ny < r && nx >= 0 && nx < c && room[ny][nx] != -1) {
							temp[ny][nx] += amount;
							count++;
						}
					}
					room[i][j] -= amount * count;
				}
			}
		}
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				room[i][j] += temp[i][j];
			}
		}
	}

	static void upcleaning() {
		for (int i = up - 1; i > 0; i--)
			room[i][0] = room[i - 1][0];
		for (int j = 0; j < c - 1; j++)
			room[0][j] = room[0][j + 1];
		for (int i = 0; i < up; i++)
			room[i][c - 1] = room[i + 1][c - 1];
		for (int j = c - 1; j > 1; j--)
			room[up][j] = room[up][j - 1];
		room[up][1] = 0;
	}

	static void downcleaning() {
		for (int i = down + 1; i < r - 1; i++)
			room[i][0] = room[i + 1][0];
		for (int j = 0; j < c - 1; j++)
			room[r - 1][j] = room[r - 1][j + 1];
		for (int i = r - 1; i > down; i--)
			room[i][c - 1] = room[i - 1][c - 1];
		for (int j = c - 1; j > 1; j--)
			room[down][j] = room[down][j - 1];
		room[down][1] = 0;
	}
}
