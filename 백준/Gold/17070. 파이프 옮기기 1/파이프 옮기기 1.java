import java.util.Scanner;

public class Main {

    static int N;
    static int[][] map;
    static int[][][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N][N];
        dp = new int[N][N][3]; // [x][y][dir]

        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                map[i][j] = sc.nextInt();

        // 초기값: (0, 1) 위치에 가로 방향 파이프
        dp[0][1][0] = 1;

        for (int x = 0; x < N; x++) {
            for (int y = 2; y < N; y++) { // y는 2부터 (0,1) 시작을 고려
                if (map[x][y] == 1) continue;

                // 가로
                dp[x][y][0] = dp[x][y - 1][0] + dp[x][y - 1][2];

                // 세로
                if (x > 0)
                    dp[x][y][1] = dp[x - 1][y][1] + dp[x - 1][y][2];

                // 대각선
                if (x > 0 && map[x - 1][y] == 0 && map[x][y - 1] == 0)
                    dp[x][y][2] = dp[x - 1][y - 1][0] + dp[x - 1][y - 1][1] + dp[x - 1][y - 1][2];
            }
        }

        int answer = dp[N - 1][N - 1][0] + dp[N - 1][N - 1][1] + dp[N - 1][N - 1][2];
        System.out.println(answer);
    }
}
