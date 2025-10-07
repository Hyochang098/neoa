import java.io.*;
import java.util.*;

public class Main {
    static List<Integer>[] g;
    static int del;

    static int dfs(int u) {
        int cnt = 0;
        int child = 0;
        for (int v : g[u]) {
            if (v == del) continue;
            child++;
            cnt += dfs(v);
        }
        if (child == 0) return 1;
        return cnt;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        g = new ArrayList[n];
        for (int i = 0; i < n; i++) g[i] = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int root = -1;
        for (int i = 0; i < n; i++) {
            int p = Integer.parseInt(st.nextToken());
            if (p == -1) root = i;
            else g[p].add(i);
        }
        del = Integer.parseInt(br.readLine());
        if (del == root) {
            System.out.println(0);
            return;
        }
        System.out.println(dfs(root));
    }
}
