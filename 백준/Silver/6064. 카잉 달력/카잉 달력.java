import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken()); // x는 M 주기
			int y = Integer.parseInt(st.nextToken()); // y는 N 주기

			int lcm = lcm(M, N);
			boolean kying = false;

			for (int k = 0; k * M + x <= lcm; k++) {
				int year = k * M + x;
				if ((year - 1) % N + 1 == y) {
					sb.append(year).append("\n");
					kying = true;
					break;
				}
			}

			if (!kying)
				sb.append(-1).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	static int gcd(int a, int b) {
		if (b == 0)
			return a;
		return gcd(b, a % b);
	}

	static int lcm(int a, int b) {
		return a * (b / gcd(a, b));
	}
}
