import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine().trim());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] d = new long[6];
        for (int i = 0; i < 6; ++i) d[i] = Long.parseLong(st.nextToken());
        if (N == 1) {
            long sum = 0, mx = 0;
            for (long v : d) {
                sum += v;
                if (v > mx) mx = v;
            }
            System.out.println(sum - mx);
            return;
        }
        int[] opp = {5, 4, 3, 2, 1, 0};
        long min1 = Arrays.stream(d).min().getAsLong();
        long min2 = Long.MAX_VALUE;
        for (int i = 0; i < 6; ++i)
            for (int j = i + 1; j < 6; ++j)
                if (j != opp[i])
                    min2 = Math.min(min2, d[i] + d[j]);
        long min3 = Long.MAX_VALUE;
        for (int i = 0; i < 6; ++i)
            for (int j = i + 1; j < 6; ++j)
                if (j != opp[i])
                    for (int k = j + 1; k < 6; ++k)
                        if (k != opp[i] && k != opp[j])
                            min3 = Math.min(min3, d[i] + d[j] + d[k]);
        long three = 4;
        long two = 8 * N - 12;
        long one = 5 * N * N - 16 * N + 12;
        long ans = three * min3 + two * min2 + one * min1;
        System.out.println(ans);
    }
}
