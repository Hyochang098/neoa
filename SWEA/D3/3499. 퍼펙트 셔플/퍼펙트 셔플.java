
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			Queue<String> que = new LinkedList<>();// 홀
			Queue<String> queue = new LinkedList<>();// 짝
			if (n % 2 == 0) {
				for (int i = 0; i < n; i++) {
					if (i < n / 2) {
						queue.add(st.nextToken());
					} else {
						que.add(st.nextToken());
					}
				}
			} else {
				for (int i = 0; i < n; i++) {
					if (i < (n / 2)+1)
						queue.add(st.nextToken());
					else
						que.add(st.nextToken());
				}

			}

			sb.append("#").append(tc).append(" ");

			while (!queue.isEmpty() && !que.isEmpty()) {
				sb.append(queue.poll() + " ");
				sb.append(que.poll() + " ");
			}
			if (!queue.isEmpty()) {
				sb.append(queue.poll());
			}
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
