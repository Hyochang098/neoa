
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		long n = Long.parseLong(br.readLine());
		long right = n;
		long left = 0;
		long ans = 0;
		if (n == 0) {
			bw.write("0");
			bw.flush();
			bw.close();
			return;
		}

		while (left <= right) {
			long center = left + (right - left) / 2;
			if (center == 0) {
				left = center + 1;
				continue;
			}
			if (center <= n / center) {
				ans = center;
				left = center + 1;
			} else {
				right = center - 1;
			}
		}
		if (ans * ans < n) {
			ans += 1;
		}
		bw.write(String.valueOf(ans));
		bw.flush();
		bw.close();
	}
}