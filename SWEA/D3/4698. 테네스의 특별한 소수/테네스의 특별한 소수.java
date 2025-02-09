import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int ans = specialPrime(a, b, d);
			sb.append("#"+tc+" "+ans+"\n");

		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	public static int specialPrime(int x, int y, int s) {
        boolean[] check = new boolean[y + 1];
        for (int i = 2; i <= y; i++) check[i] = true;

        for (int i = 2; i * i <= y; i++) {
            if (check[i]) {
                for (int j = i * i; j <= y; j += i) {
                    check[j] = false;
                }
            }
        }

        int result = 0;
        String target = String.valueOf(s);
        for (int i = Math.max(2, x); i <= y; i++) {
            if (check[i] && String.valueOf(i).contains(target)) {
                result++;
            }
        }

        return result;
    }

}