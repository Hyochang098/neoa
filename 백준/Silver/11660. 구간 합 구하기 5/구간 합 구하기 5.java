import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n + 1][n + 1];
        int[][] sum_arr = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                sum_arr[i][j] = arr[i][j];
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 2; j <= n; j++) {
                sum_arr[i][j] += sum_arr[i][j - 1];
            }
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                sum_arr[i][j] += sum_arr[i - 1][j];
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int ans = sum_arr[x2][y2];
            if (x1 > 1) ans -= sum_arr[x1 - 1][y2];
            if (y1 > 1) ans -= sum_arr[x2][y1 - 1];
            if (x1 > 1 && y1 > 1) ans += sum_arr[x1 - 1][y1 - 1];

            sb.append(ans).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
