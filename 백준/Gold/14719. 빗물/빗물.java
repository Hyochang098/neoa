import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int[] a = new int[w];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < w; i++) a[i] = Integer.parseInt(st.nextToken());
        int[] l = new int[w];
        int[] r = new int[w];
        l[0] = a[0];
        for (int i = 1; i < w; i++) l[i] = Math.max(l[i - 1], a[i]);
        r[w - 1] = a[w - 1];
        for (int i = w - 2; i >= 0; i--) r[i] = Math.max(r[i + 1], a[i]);
        long ans = 0;
        for (int i = 0; i < w; i++) {
            int m = Math.min(l[i], r[i]);
            if (m > a[i]) ans += m - a[i];
        }
        System.out.println(ans);
    }
}
