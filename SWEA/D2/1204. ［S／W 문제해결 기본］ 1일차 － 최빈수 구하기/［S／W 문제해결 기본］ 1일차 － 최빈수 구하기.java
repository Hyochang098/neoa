import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			int test = Integer.parseInt(br.readLine());
			int[] checking = new int[101];
			int frequency = 0;// 빈도
			int max = 0;// 최대

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 1000; i++) {
				int score = Integer.parseInt(st.nextToken());
				checking[score]++;
				
				if (frequency < checking[score] ||( frequency == checking[score] && max < score)) {
					frequency = checking[score];
					max = score;
				}

			}

			sb.append("#" + tc).append(" ").append(max).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}