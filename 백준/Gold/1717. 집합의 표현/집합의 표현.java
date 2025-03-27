import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
	static int[] parents, rank;
	static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		parents = new int[n + 1];
		rank = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			parents[i] = i;
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int com = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			if (com == 1) {
				sb.append(find(a) == find(b) ? "YES" : "NO").append("\n");
			} else {
				union(a, b);
			}
		}
		System.out.println(sb);
	}

	private static void union(int a, int b) {
		int x = find(a);
		int y = find(b);
		if (x == y)
			return;

		if (rank[x] < rank[y]) {
			parents[x] = y;
		} else if (rank[x] > rank[y]) {
			parents[y] = x;
		} else {
			parents[y] = x;
			rank[x]++;
		}
	}

	private static int find(int x) {
		if (x != parents[x]) {
			parents[x] = find(parents[x]);
		}
		return parents[x];
	}
}
