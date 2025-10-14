class Solution {
    public int solution(int[][] visible, int[][] hidden, int k) {
        final int n = visible.length;
        final int m = visible[0].length;
        final int INF = 1_000_000_000;

        boolean bothEven = (n % 2 == 0) && (m % 2 == 0);

        int answer = Integer.MIN_VALUE;

        int totalMasks = 1 << n;
        for (int mask = 0; mask < totalMasks; mask++) {
            int rowFlipCount = Integer.bitCount(mask);

            int[] bestS = new int[m];
            int[] bestMinus = new int[m];

            int sumBest = 0;
            for (int j = 0; j < m; j++) {
                int s0 = 0;        
                int s1 = -k;       
                int m0 = INF;      
                int m1 = INF;      

                for (int i = 0; i < n; i++) {
                    boolean r = ((mask >> i) & 1) == 1;
                    
                    int val0 = r ? hidden[i][j] : visible[i][j];
                    int val1 = r ? visible[i][j] : hidden[i][j];

                    s0 += val0;
                    s1 += val1;

                    if (((i + j) & 1) == 1) { 
                        if (val0 < m0) m0 = val0;
                        if (val1 < m1) m1 = val1;
                    }
                }

                int colBest = Math.max(s0, s1);
                bestS[j] = colBest;
                sumBest += colBest;

                int minus0 = (m0 == INF) ? -INF : (s0 - m0);
                int minus1 = (m1 == INF) ? -INF : (s1 - m1);
                bestMinus[j] = Math.max(minus0, minus1);
            }

            int base = -k * rowFlipCount;

            if (!bothEven) {
                int candidate = sumBest + base;
                if (candidate > answer) answer = candidate;
            } else {
            
                int bestExcludingOne = Integer.MIN_VALUE;
                for (int j = 0; j < m; j++) {
                    if (bestMinus[j] == -INF) continue;
                    int cand = (sumBest - bestS[j]) + bestMinus[j];
                    if (cand > bestExcludingOne) bestExcludingOne = cand;
                }
                if (bestExcludingOne == Integer.MIN_VALUE) {

                } else {
                    int candidate = bestExcludingOne + base;
                    if (candidate > answer) answer = candidate;
                }
            }
        }

        return answer;
    }
}
