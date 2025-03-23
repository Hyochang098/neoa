import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class location {
        int id;
        int population;
        List<Integer> link = new ArrayList<>();

        location(int id, int population) {
            this.id = id;
            this.population = population;
        }

        void add(int id) {
            link.add(id);
        }
    }

    static location[] locations;
    static int n;
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        locations = new location[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            locations[i] = new location(i, Integer.parseInt(st.nextToken()));
        }

        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int range = Integer.parseInt(st.nextToken());
            for (int j = 0; j < range; j++) {
                int rev = Integer.parseInt(st.nextToken());
                locations[i].add(rev);
                locations[rev].add(i);
            }
        }

        for (int i = 1; i <= n / 2; i++) {
            combi(1, 0, i, new boolean[n + 1]);
        }
        if (ans == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else
            System.out.println(ans);
    }

    static void combi(int start, int cur, int r, boolean[] sel) {
        if (cur == r) {
            List<Integer> gary = new ArrayList<>();
            List<Integer> man = new ArrayList<>();
            for (int i = 1; i < n + 1; i++) {
                if (!sel[i])
                    gary.add(i);
                else
                    man.add(i);
            }
            if (divided(gary) && divided(man)) {
                ans = Math.min(ans, Math.abs(cal(gary) - cal(man)));
            }
            return;
        }
        for (int i = start; i < n + 1; i++) {
            sel[i] = true;
            combi(i + 1, cur + 1, r, sel);
            sel[i] = false;
        }
    }

    static boolean divided(List<Integer> list) {
        if (list.isEmpty()) {
            return false;
        }
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> que = new ArrayDeque<>();
        int s = list.get(0);
        que.add(s);
        visited[s] = true;
        while (!que.isEmpty()) {
            int cur = que.poll();
            for (int pre : locations[cur].link) {
                if (!visited[pre] && list.contains(pre)) {
                    visited[pre] = true;
                    que.add(pre);
                }
            }
        }
        for (int l : list) {
            if (!visited[l]) {
                return false;
            }
        }
        return true;
    }

    static int cal(List<Integer> list) {
        int result = 0;
        for (int l : list) {
            result += locations[l].population;
        }
        return result;
    }
}