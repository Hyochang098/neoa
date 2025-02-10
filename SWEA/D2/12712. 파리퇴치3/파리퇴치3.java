import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken()) - 1;

			int[][] fly = new int[n][n];

			for (int i = 0; i < n; i++) {
				StringTokenizer st1 = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					fly[i][j] = Integer.parseInt(st1.nextToken());
				}
			}
			int ans = 0;
			int[] dy = { 0, 0, 1, -1 };
			int[] dx = { 1, -1, 0, 0 };
			int[] dy1 = { 1, -1, 1, -1 };
			int[] dx1 = { 1, 1, -1, -1 };
			for (int y = 0; y < n; y++) {
				for (int x = 0; x < n; x++) {
					int catch_flies = fly[y][x];

					for (int k = 0; k < 4; k++) {
						for (int o = 1; o <= m; o++) {
							int ny = y + dy[k] * o;
							int nx = x + dx[k] * o;
							if (0 <= ny && ny < n && 0 <= nx && nx < n) {
								catch_flies += fly[ny][nx];
							}
						}
					}
					ans = Math.max(ans, catch_flies);
				}
			}
			for (int y = 0; y < n; y++) {
				for (int x = 0; x < n; x++) {
					int catch_flies = fly[y][x];

					for (int k = 0; k < 4; k++) {
						for (int o = 1; o <= m; o++) {
							int ny = y + dy1[k] * o;
							int nx = x + dx1[k] * o;
							if (0 <= ny && ny < n && 0 <= nx && nx < n) {
								catch_flies += fly[ny][nx];
							}
						}
					}
					ans = Math.max(ans, catch_flies);
				}
			}
			sb.append("#" + tc + " " + ans + "\n");
		}

		bw.append(sb.toString());
		bw.flush();
		bw.close();
	}
}