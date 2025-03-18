
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[][] abil;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		abil = new int[n][n];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++)
				abil[i][j] = Integer.parseInt(st.nextToken());
		}

		int ans = Integer.MAX_VALUE;

		for (int bit = 1; bit < (1 << n); bit++) {
			int cnt = Integer.bitCount(bit);
			if (cnt > n / 2)
				continue;

			int start = 0;
			int link = 0;

			for (int i = 0; i < n; i++) {
				for (int j = i + 1; j < n; j++) {
					if ((bit & (1 << i)) != 0 && (bit & (1 << j)) != 0) {
						start += abil[i][j] + abil[j][i];
					} else if ((bit & (1 << i)) == 0 && (bit & (1 << j)) == 0) {
						link += abil[i][j] + abil[j][i];
					}
				}
			}

			ans = Math.min(ans, Math.abs(start - link));
			if (ans == 0)
				break;
		}

		System.out.println(ans);
	}
}
