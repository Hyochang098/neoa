import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] white = new int[100][100];

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;
            for (int j = y; j < y + 10; j++) {
                for (int k = x; k < x + 10; k++) {
                    white[j][k] = 1;
                }
            }
        }

        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        int ans = 0;

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (white[i][j] == 1) {
                    for (int k = 0; k < 4; k++) {
                        int y = i + dy[k];
                        int x = j + dx[k];
                        if (y < 0 || y >= 100 || x < 0 || x >= 100 || white[y][x] == 0) {
                            ans++;
                        }
                    }
                }
            }
        }

        System.out.println(ans);
    }
}
