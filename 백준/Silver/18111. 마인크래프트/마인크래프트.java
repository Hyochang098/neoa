import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		int[][] mine = new int[n][m];
		int min = 256;
		int max = 0;

		for (int i = 0; i < n; i++) {
			StringTokenizer sa = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				mine[i][j] = Integer.parseInt(sa.nextToken());
				min = Math.min(min, mine[i][j]);
				max = Math.max(max, mine[i][j]);
			}
		}

		int time = Integer.MAX_VALUE;
		int cur_h = 0;

		for (int i = min; i <= max; i++) {
			int remove = 0;
			int add = 0;
			for (int y = 0; y < n; y++) {
				for (int x = 0; x < m; x++) {
					if (i < mine[y][x]) {
						remove += mine[y][x] - i;
					} else if (i > mine[y][x]) {
						add += i - mine[y][x];
					}
				}
			}
			if (remove + b >= add) { 
                int try_time = remove * 2 + add; 
                if (time > try_time || (time == try_time && i > cur_h)) {
                    time = try_time;
                    cur_h = i;
                }
            }
        
		}
		System.out.println(time + " " + cur_h);
	}
}
