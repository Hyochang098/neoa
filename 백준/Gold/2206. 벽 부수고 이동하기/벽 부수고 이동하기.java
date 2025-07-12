import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] map = new char[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int[][][] dist = new int[N][M][2];
        int start;
        if (map[0][0] == '1') {
            start = 1;
        } else {
            start = 0;
        }
        dist[0][0][start] = 1;

        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.add(new int[] { 0, 0, start });

        int[] dr = { -1, 1, 0, 0 };
        int[] dc = { 0, 0, -1, 1 };

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];
            int b = cur[2];
            int d = dist[r][c][b];

            if (r == N - 1 && c == M - 1) {
                System.out.println(d);
                return;
            }

            for (int k = 0; k < 4; k++) {
                int nr = r + dr[k];
                int nc = c + dc[k];
                if (nr < 0 || nr >= N || nc < 0 || nc >= M) {
                    continue;
                }

                if (map[nr][nc] == '0' && dist[nr][nc][b] == 0) {
                    dist[nr][nc][b] = d + 1;
                    q.add(new int[] { nr, nc, b });
                } else {
                    if (map[nr][nc] == '1' && b == 0 && dist[nr][nc][1] == 0) {
                        dist[nr][nc][1] = d + 1;
                        q.add(new int[] { nr, nc, 1 });
                    }
                }
            }
        }
        System.out.println(-1);
    }
}
