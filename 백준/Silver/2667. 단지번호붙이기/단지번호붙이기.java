import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		int[][] apart = new int[n][n];
		for (int i = 0; i < n; i++) {
			String temp = br.readLine();
			for (int j = 0; j < n; j++) {
				apart[i][j] = temp.charAt(j) - '0';
			}
		}
		Queue<int[]> que = new ArrayDeque<>();
		boolean[][] visit = new boolean[n][n];

		int[] dy = { 1, -1, 0, 0 };
		int[] dx = { 0, 0, -1, 1 };

		int ans = 0;
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (apart[i][j] == 1 && !visit[i][j]) {
					int cnt = 1;
					que.add(new int[] { i, j });
					visit[i][j] = true;
					while (!que.isEmpty()) {
						int[] arr = que.poll();
						int y = arr[0];
						int x = arr[1];

						for (int k = 0; k < 4; k++) {
							int ny = y + dy[k];
							int nx = x + dx[k];

							if (ny >= 0 && ny < n && nx >= 0 && nx < n && !visit[ny][nx] && apart[ny][nx] == 1) {
								que.add(new int[] { ny, nx });
								visit[ny][nx] = true;
								cnt++;
							}
						}
					}
					ans++;
					list.add(cnt);
				}
			}
		}
		Collections.sort(list);
		System.out.println(ans);
		for(int i:list) {
			sb.append(i).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}
}