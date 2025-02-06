import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str);
			
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());

			int ans =a+b;
			sb.append(ans).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
}