import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] abil;
    static ArrayList<Integer> start;
    static ArrayList<Integer> link;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ans = Integer.MAX_VALUE;
        n = Integer.parseInt(br.readLine());

        start = new ArrayList<>();
        link = new ArrayList<>();
        abil = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                abil[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 팀의 최소 크기를 1부터 최대 n-1까지 탐색
        for (int member = 1; member <= n - 1; member++) {
            matching(0, member);
        }

        System.out.println(ans);
    }

    static void matching(int cur, int member) {
        if (start.size() == member) {
            link.clear();
            for (int i = 0; i < n; i++) {
                if (!start.contains(i)) {
                    link.add(i);
                }
            }
            if (!link.isEmpty()) {
                verse();
            }
            return;
        }

        for (int i = cur; i < n; i++) {
            start.add(i);
            matching(i + 1, member);
            start.remove(start.size() - 1);
        }
    }

    static void verse() {
        int s_abil = 0;
        int l_abil = 0;

        for (int i = 0; i < start.size(); i++) {
            for (int j = i + 1; j < start.size(); j++) {
                int pair1 = start.get(i);
                int pair2 = start.get(j);
                s_abil += abil[pair1][pair2] + abil[pair2][pair1];
            }
        }

        for (int i = 0; i < link.size(); i++) {
            for (int j = i + 1; j < link.size(); j++) {
                int pair1_l = link.get(i);
                int pair2_l = link.get(j);
                l_abil += abil[pair1_l][pair2_l] + abil[pair2_l][pair1_l];
            }
        }

        int temp = Math.abs(l_abil - s_abil);
        ans = Math.min(ans, temp);
    }
}
