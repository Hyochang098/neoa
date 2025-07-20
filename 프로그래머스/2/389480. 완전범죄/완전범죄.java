import java.util.Arrays;

class Solution {
    public int solution(int[][] info, int n, int m) {
        int[][] dp = new int[info.length + 1][m];
        for (int[] row : dp) Arrays.fill(row, Integer.MAX_VALUE);
        dp[0][0] = 0;

        for (int i = 0; i < info.length; i++) {
            for (int b = 0; b < m; b++) {
                if (dp[i][b] == Integer.MAX_VALUE) continue;

                int aTrace = dp[i][b];
                int aNext = aTrace + info[i][0];
                int bNext = b + info[i][1];

                // Case 1: A가 훔치는 경우
                if (aNext < n) {
                    dp[i + 1][b] = Math.min(dp[i + 1][b], aNext);
                }

                // Case 2: B가 훔치는 경우
                if (bNext < m) {
                    dp[i + 1][bNext] = Math.min(dp[i + 1][bNext], aTrace);
                }
            }
        }

        int minA = Integer.MAX_VALUE;
        for (int b = 0; b < m; b++) {
            minA = Math.min(minA, dp[info.length][b]);
        }

        return minA == Integer.MAX_VALUE ? -1 : minA;
    }
}
