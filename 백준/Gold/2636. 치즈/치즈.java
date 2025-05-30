import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int r, c;
    static int[][] board;
    static final int[] dr = {-1, 1, 0, 0};
    static final int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        board = new int[r][c];
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int hours = 0;
        int last = 0;

        while (true) {
            int cur = counting();
            if (cur == 0) break;
            last = cur;
            melting();
            hours++;
        }

        System.out.println(hours);
        System.out.println(last);
    }

    private static int counting() {
        int cnt = 0;
        for (int[] row : board)
            for (int v : row)
                if (v == 1) cnt++;
        return cnt;
    }

    private static void melting() {
        boolean[][] vis = new boolean[r][c];
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0});
        vis[0][0] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d], nc = c + dc[d];
                if (nr < 0 || nr >= Main.r || nc < 0 || nc >= Main.c || vis[nr][nc]) continue;

                if (board[nr][nc] == 1) {
                    board[nr][nc] = 0;
                    vis[nr][nc] = true;
                } else {
                    vis[nr][nc] = true;
                    q.offer(new int[]{nr, nc});
                }
            }
        }
    }
}
