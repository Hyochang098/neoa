import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    static int[][] yori;
    static boolean[] visit;
    static int n;
    static ArrayList<Integer> select;
    static ArrayList<Integer> nonsel;
    static int ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int tc = 1; tc <= t; tc++) {
            n = sc.nextInt();
            yori = new int[n][n];
            visit = new boolean[n];
            select = new ArrayList<>();
            ans = Integer.MAX_VALUE; // 초기값 설정

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    yori[i][j] = sc.nextInt();
                }
            }

            combi(0, 0);
            System.out.println("#" + tc + " " + ans);
        }
        sc.close();
    }

    // 백트래킹 조합
    static void combi(int cur, int start) {
        if (cur == n / 2) { // 조합이 완성되면 계산
            nonsel = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (!select.contains(i)) {
                    nonsel.add(i);
                }
            }
            ans = Math.min(ans, verse());
            return;
        }

        for (int i = start; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                select.add(i);
                combi(cur + 1, i + 1);
                select.remove(select.size() - 1);
                visit[i] = false;
            }
        }
    }

    // 계산하는 메서드
    private static int verse() {
        int suma = 0;
        int sumb = 0;

        for (int i = 0; i < select.size(); i++) {
            for (int j = 0; j < select.size(); j++) {
                if (i == j) continue;
                suma += yori[select.get(i)][select.get(j)];
                sumb += yori[nonsel.get(i)][nonsel.get(j)];
            }
        }
        return Math.abs(suma - sumb);
    }
}
