import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] cost = new int[n];
        int[] cust = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            cost[i] = Integer.parseInt(st.nextToken());
            cust[i] = Integer.parseInt(st.nextToken());
        }
        int limit = c + 100;
        int inf = 1_000_000_000;
        int[] dp = new int[limit + 1];
        Arrays.fill(dp, inf);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            int a = cust[i], b = cost[i];
            for (int j = a; j <= limit; j++) {
                if (dp[j - a] + b < dp[j]) dp[j] = dp[j - a] + b;
            }
        }
        int ans = inf;
        for (int j = c; j <= limit; j++) ans = Math.min(ans, dp[j]);
        System.out.println(ans);
    }
}
