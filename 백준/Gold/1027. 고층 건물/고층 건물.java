import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] h = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) h[i] = Long.parseLong(st.nextToken());

        int ans = 0;
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            double maxR = Double.NEGATIVE_INFINITY;
            for (int j = i + 1; j < n; j++) {
                double slope = (double)(h[j] - h[i]) / (j - i);
                if (slope > maxR) {
                    maxR = slope;
                    cnt++;
                }
            }
            double minL = Double.POSITIVE_INFINITY;
            for (int j = i - 1; j >= 0; j--) {
                double slope = (double)(h[j] - h[i]) / (j - i);
                if (slope < minL) {
                    minL = slope;
                    cnt++;
                }
            }
            if (cnt > ans) ans = cnt;
        }
        System.out.print(ans);
    }
}
