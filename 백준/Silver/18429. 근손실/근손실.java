import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, k, ans;

	static int[] weight;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 하루 지날때마다 중량 k만큼 감소
		// n개의 운동 키트
		// 순열 만들어서

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		weight = new int[n];
		visited = new boolean[n];
		ans = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			weight[i] = Integer.parseInt(st.nextToken());
		}
		bt(0, 500);
		System.out.println(ans);
	}

	private static void bt(int cur, int total) {
		// TODO Auto-generated method stub
		if (cur == n) {
			if (total > 500) {
				ans++;
			}
			return;
		}
		if(total<500) {
			return;
		}
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				bt(cur + 1, total + weight[i]-k);
				visited[i] = false;
			}
		}
	}
}
