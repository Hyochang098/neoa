import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static int[][] house;
	static int count = 0;

	static class pipe {
		int x, y, dir;

		pipe(int x, int y, int dir) {
			this.x = x;
			this.y = y;
			this.dir = dir;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		house = new int[n][n];
		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				house[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(new pipe(0, 1, 0));
		System.out.println(count);
	}

	static void dfs(pipe p) {
		if (p.x == n - 1 && p.y == n - 1) {
			count++;
			return;
		}

		int x = p.x;
		int y = p.y;
		int dir = p.dir;

		if (dir == 0 || dir == 2) {
			if (y + 1 < n && house[x][y + 1] == 0) {
				dfs(new pipe(x, y + 1, 0));
			}
		}
		if (dir == 1 || dir == 2) {
			if (x + 1 < n && house[x + 1][y] == 0) {
				dfs(new pipe(x + 1, y, 1));
			}
		}
		if (x + 1 < n && y + 1 < n && house[x][y + 1] == 0 && house[x + 1][y] == 0 && house[x + 1][y + 1] == 0) {
			dfs(new pipe(x + 1, y + 1, 2));
		}
	}
}
