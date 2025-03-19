import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[][] abil = new int[n][n];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				abil[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int ans = Integer.MAX_VALUE;

		for (int bit = 1; bit < (1 << n); bit++) {
			if (Integer.bitCount(bit) == n / 2) {
				int start = 0;
				int link = 0;
				for (int i = 0; i < n; i++) {
					for (int j = i + 1; j < n; j++) {
						if (((bit & (1 << i)) == 0) && ((bit & (1 << j)) == 0)) {
							start += abil[i][j] + abil[j][i];
						}
						if (((bit & (1 << i)) != 0) && ((bit & (1 << j)) != 0)) {
							link += abil[i][j] + abil[j][i];
						}
					}
				}
				ans = Math.min(ans, Math.abs(start - link));
			}
		}
		System.out.println(ans);
	}
}
