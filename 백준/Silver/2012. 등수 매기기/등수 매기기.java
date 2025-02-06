import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		if (n == 1) {
			br.readLine();
			System.out.println(0);
			return;
		} else {
			int[] contest = new int[n];
			for (int i = 0; i < n; i++) {
				contest[i] = Integer.parseInt(br.readLine());
			}
			Arrays.sort(contest);
			long ans = 0;
			for (int i = 0; i < n; i++) {
			    ans += Math.abs(contest[i] - (i + 1));
			}

			System.out.println(ans);
		}
	}
}