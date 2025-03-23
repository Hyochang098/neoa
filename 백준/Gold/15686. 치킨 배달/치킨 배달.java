import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[][] chicken;

	static boolean[] visited;
	static int[] sel;
	static int ans = Integer.MAX_VALUE;
	static List<int[]> c_list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		chicken = new int[n][n];
		sel = new int[m];
		c_list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				chicken[i][j] = Integer.parseInt(st.nextToken());
				if (chicken[i][j] == 2) {
					c_list.add(new int[] { i, j });
				}
			}
		}
		visited = new boolean[c_list.size()];

		bt(0, 0);
		if (ans == 0) {
			System.out.println(0);
			return;
		}
		System.out.println(ans);

	}

	private static void bt(int cur, int start) {
		if (cur == m) {
			ans = Math.min(ans, cal());
			return;
		}
		for (int i = start; i < c_list.size(); i++) {
			sel[cur] = i;
			bt(cur + 1, i + 1);
		}

	}

	private static int cal() {
		int result = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (chicken[i][j] == 1) {
					int tmp = 0;
					int cd = Integer.MAX_VALUE;
					for (int s : sel) {
						int[] temp = c_list.get(s);
						tmp = Math.abs(i - temp[0]) + Math.abs(j - temp[1]);
						cd = Math.min(cd, tmp);
					}
					result += cd;
				}
			}
		}
		return result;
	}
}