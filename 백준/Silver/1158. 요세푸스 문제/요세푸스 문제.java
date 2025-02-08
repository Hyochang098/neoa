import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		Queue<Integer> que = new LinkedList<>();
		for (int i = 1; i <= n; i++) {
			que.add(i);
		}
		sb.append("<");
		int cnt = 1;
		while (!que.isEmpty()) {
			if (cnt % k == 0) {
				sb.append(que.poll());
				if (!que.isEmpty()) {
					sb.append(", ");
				}
			} else {
				que.add(que.poll());
			}
			cnt++;
		}
		sb.append(">");
		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}
}