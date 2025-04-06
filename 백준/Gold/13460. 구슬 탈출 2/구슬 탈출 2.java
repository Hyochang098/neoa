import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static class ball {
		int y, x;
		boolean out;

		public ball(int y, int x) {
			this.y = y;
			this.x = x;
			this.out = false;
		}

		public ball(int y, int x, boolean out) {
			this.y = y;
			this.x = x;
			this.out = out;
		}

		public ball copy() {
			return new ball(this.y, this.x, this.out);
		}
	}

	static int n, m, ans = Integer.MAX_VALUE;
	static char[][] map;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new char[n][m];

		ball red = null;
		ball blue = null;
		for (int i = 0; i < n; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = tmp.charAt(j);
				if (map[i][j] == 'R') {
					red = new ball(i, j);
					map[i][j] = '.';
				} else if (map[i][j] == 'B') {
					blue = new ball(i, j);
					map[i][j] = '.';
				}
			}
		}

		dfs(0, red, blue);
		if (ans > 10) {
			System.out.println(-1);
		} else {
			System.out.println(ans);
		}
	}

	private static void dfs(int depth, ball red, ball blue) {
		if (depth > 10 || blue.out)
			return;
		if (red.out) {
			ans = Math.min(ans, depth);
			return;
		}

		for (int dir = 0; dir < 4; dir++) {
			ball nextr = red.copy();
			ball nextb = blue.copy();

			boolean order = check(red, blue, dir);

			if (order) {
				move(nextr, dir);
				move(nextb, dir);
			} else {
				move(nextb, dir);
				move(nextr, dir);
			}

			if (nextb.out)
				continue;
			if (nextr.out && !nextb.out) {
				ans = Math.min(ans, depth + 1);
				continue;
			}

			if (nextr.y == nextb.y && nextr.x == nextb.x) {
				if (order) {
					nextb.y = nextr.y - dy[dir];
					nextb.x = nextr.x - dx[dir];
				} else {
					nextr.y = nextb.y - dy[dir];
					nextr.x = nextb.x - dx[dir];
				}
			}

			dfs(depth + 1, nextr, nextb);
		}
	}

	private static void move(ball b, int dir) {
		while (true) {
			int ny = b.y + dy[dir];
			int nx = b.x + dx[dir];
			if (map[ny][nx] == '#')
				break;
			if (map[ny][nx] == 'O') {
				b.y = ny;
				b.x = nx;
				b.out = true;
				return;
			}
			b.y = ny;
			b.x = nx;
		}
	}

	private static boolean check(ball red, ball blue, int dir) {
		if (dir == 0)
			return red.y < blue.y;
		if (dir == 1)
			return red.y > blue.y;
		if (dir == 2)
			return red.x < blue.x;
		return red.x > blue.x;
	}
}
