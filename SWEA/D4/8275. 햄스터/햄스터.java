import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {
    // n 우리
    // x 우리 안의 햄스터 수
    // m 기록 수
    // 기록: l번 부터 R번까지 햄스터 s마리

    // 조합 구하기

    // 햄스터 전체 수가 없음
    // 해당 범위에서 마지막에 몰아 넣고 정보가 없는 곳은 최대 마리수로로

    // ans 올리고
    // 처음에만 위치 저장
    static int[] cage;
    static int[][] research;
    static boolean[] visited;
    static int[] sel;
    static int max;
    static int n, m, x;
    static List<int[]> result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int tc = 1; tc <= t; tc++) {
            n = sc.nextInt();
            x = sc.nextInt();
            m = sc.nextInt();
            result = new ArrayList<>();
            cage = new int[n];
            visited = new boolean[n];
            research = new int[m][3];
            max = Integer.MIN_VALUE;
            // 가장 마지막칸부터 x마리씩채움
            // 가장 앞의 우리에는 최소의 마리
            // 선택받지 못한 애들은 최대 마리 수
            for (int i = 0; i < m; i++) {
                research[i][0] = sc.nextInt(); // 시작 케이지
                research[i][1] = sc.nextInt(); // 종료 케이지
                research[i][2] = sc.nextInt(); // 총 마리수
            }

            bt(0);
            // 조합해놓은 경우의 수를 담은 리스트
            int[] ans = new int[n];
            for (int[] l : result) {
                int sum = 0;
                for (int i = 0; i < n; i++) {
                    sum += l[i];
                }
                if (sum > max) {
                    max = sum;
                    System.arraycopy(l, 0, ans, 0, n);
                } else if (sum == max) {
                    if (isLexSmaller(l, ans)) {
                        System.arraycopy(l, 0, ans, 0, n);
                    }
                }
            }

            System.out.print("#" + tc + " ");
            if (max == Integer.MIN_VALUE) {
                System.out.println(-1);
            } else {
                for (int i = 0; i < n; i++) {
                    System.out.print(ans[i] + " ");
                }
                System.out.println();
            }
        }
    }

    static boolean isLexSmaller(int[] a, int[] b) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] < b[i])
                return true;
            else if (a[i] > b[i])
                return false;
        }
        return false;
    }

    static void bt(int idx) {
        if (idx == n) {
            if (check()) {
                result.add(cage.clone());
            }
            return;
        }

        for (int i = 0; i <= x; i++) {
            cage[idx] = i;
            bt(idx + 1);
        }
    }

    static boolean check() {
        for (int i = 0; i < m; i++) {
            int temp = 0;
            int start = research[i][0] - 1;
            int end = research[i][1] - 1;
            int sum = research[i][2];
            for (int j = start; j <= end; j++) {
                temp += cage[j];
            }
            if (sum != temp) {
                return false;
            }
        }
        return true;
    }
}
