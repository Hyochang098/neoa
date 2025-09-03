import java.io.*;
import java.util.*;

public class Main {
    static final long MOD = 1_000_000_007L;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        long[] dp = new long[3];
        dp[0] = 1;
        for (int i = 0; i < N - 1; i++) {
            long[] ndp = new long[3];
            ndp[(0 + 1) % 3] = (ndp[(0 + 1) % 3] + dp[0]) % MOD;
            ndp[(0 + 2) % 3] = (ndp[(0 + 2) % 3] + dp[0]) % MOD;
            ndp[(1 + 1) % 3] = (ndp[(1 + 1) % 3] + dp[1]) % MOD;
            ndp[(1 + 2) % 3] = (ndp[(1 + 2) % 3] + dp[1]) % MOD;
            ndp[(2 + 1) % 3] = (ndp[(2 + 1) % 3] + dp[2]) % MOD;
            ndp[(2 + 2) % 3] = (ndp[(2 + 2) % 3] + dp[2]) % MOD;
            dp = ndp;
        }
        System.out.println(dp[1] % MOD);
    }
}
