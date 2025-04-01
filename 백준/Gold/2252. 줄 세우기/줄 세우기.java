import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		Queue<Integer> que = new ArrayDeque<>();
		ArrayList<Integer>[] link = new ArrayList[n + 1];// 여러개로 연결 될 수 있으니 2차원으로
		for (int i = 0; i < n + 1; i++) {
			link[i] = new ArrayList<>();
		}
		int[] order = new int[n + 1];

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			link[start].add(end);
			order[end]++;
		}

		for (int i = 1; i < n + 1; i++) {
			if (order[i] == 0) {
				que.add(i);
				order[i] = -1;
			}
		}

		while (!que.isEmpty()) {
			int cur = que.poll();
			sb.append(cur).append(" ");

			for (int l : link[cur]) {
				order[l]--;
				if (order[l] == 0) {
					que.add(l);
				}
			}

		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}