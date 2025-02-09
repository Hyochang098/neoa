import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			List<Integer> pre = new ArrayList<>();
			int n = Integer.parseInt(br.readLine())-1;
			pre.add(0);
			pre.add(1);
			pre.add(0);
			sb.append("#").append(tc+"\n");
			sb.append(1).append("\n");
			for (int i = 0; i < n; i++) {
				List<Integer> cur = new ArrayList<>();
				cur.add(0);
				for(int j=0;j<pre.size()-1;j++) {
					cur.add(pre.get(j)+pre.get(j+1));
					sb.append(pre.get(j)+pre.get(j+1)+" ");
				}
				cur.add(0);
				pre = cur;
				sb.append("\n");
			}
			
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}