import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static class fish {
		int y;
		int x;
		int num;
		int dir;
		boolean alive;

		public fish(int y, int x, int num, int dir) {
			this.y = y;
			this.x = x;
			this.num = num;
			this.dir = dir;
			this.alive = true;
		}
	}

	static int n = 4;
	static int ans = Integer.MIN_VALUE;
	static int[] dy = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dx = { 0, -1, -1, -1, 0, 1, 1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		fish[][] ocean = new fish[n][n];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				int num = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken()) - 1;
				ocean[i][j] = new fish(i, j, num, dir);
			}
		}

		fish first = ocean[0][0];
		int score = first.num;
		ocean[0][0] = new fish(0, 0, -1, first.dir);

		dfs(ocean, 0, 0, first.dir, score);
		System.out.println(ans);
	}

	static void dfs(fish[][] ocean, int sy, int sx, int sdir, int score) {
		ans = Math.max(ans, score);

		fish[][] sample = copy(ocean);
		moveFish(sample, sy, sx);

		for (int i = 1; i <= 3; i++) {
			int ny = sy + dy[sdir] * i;
			int nx = sx + dx[sdir] * i;
			if (!range(ny, nx))
				break;
			if (sample[ny][nx] == null)
				continue;
			if (sample[ny][nx].num == -1)
				continue;

			fish target = sample[ny][nx];
			fish[][] copy = copy(sample);
			copy[sy][sx] = null;
			copy[ny][nx] = new fish(ny, nx, -1, target.dir);

			dfs(copy, ny, nx, target.dir, score + target.num);
		}
	}

	static void moveFish(fish[][] ocean, int sharkY, int sharkX) {
		for (int num = 1; num <= 16; num++) {
			int fy = -1, fx = -1;
			boolean found = false;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (ocean[i][j] != null && ocean[i][j].num == num) {
						fy = i;
						fx = j;
						found = true;
						break;
					}
				}
				if (found)
					break;
			}
			if (!found)
				continue;

			fish f = ocean[fy][fx];
			for (int i = 0; i < 8; i++) {
				int nd = (f.dir + i) % 8;
				int ny = fy + dy[nd];
				int nx = fx + dx[nd];
				if (!range(ny, nx))
					continue;

				if (ocean[ny][nx] != null && ocean[ny][nx].num == -1)
					continue;

				fish temp = ocean[ny][nx];
				ocean[ny][nx] = new fish(ny, nx, f.num, nd);
				ocean[ny][nx].alive = f.alive;
				ocean[fy][fx] = temp;
				if (temp != null) {
					temp.y = fy;
					temp.x = fx;
				}
				break;
			}
		}
	}

	static boolean range(int y, int x) {
		if (y >= 0 && y < n && x >= 0 && x < n)
			return true;
		else
			return false;
	}

	static fish[][] copy(fish[][] ocean) {
		fish[][] res = new fish[n][n];
		for (int i = 0; i < n; i++) {
			System.arraycopy(ocean[i], 0, res[i], 0, n);
			for (int j = 0; j < n; j++) {
				if (res[i][j] != null) {
					fish f = res[i][j];
					res[i][j] = new fish(f.y, f.x, f.num, f.dir);
					res[i][j].alive = f.alive;
				}
			}
		}
		return res;
	}
}
