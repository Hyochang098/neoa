import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static final int[] dx = {1, -1, 0, 0};
    private static final int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int years = 0;
        while (true) {
            if (isAllMelted(arr, n, m)) {
                System.out.println(0);
                return;
            }

            int[][] meltQueue = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (arr[i][j] > 0) {
                        int seaCount = 0;
                        for (int k = 0; k < 4; k++) {
                            int ni = i + dx[k];
                            int nj = j + dy[k];
                            if (ni >= 0 && ni < n && nj >= 0 && nj < m && arr[ni][nj] == 0) {
                                seaCount++;
                            }
                        }
                        meltQueue[i][j] = seaCount;
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = Math.max(0, arr[i][j] - meltQueue[i][j]);
                }
            }

            years++;
            if (isSeparated(arr, n, m)) {
                System.out.println(years);
                return;
            }
        }
    }

    private static boolean isAllMelted(int[][] arr, int n, int m) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] > 0) return false;
            }
        }
        return true;
    }

    private static boolean isSeparated(int[][] arr, int n, int m) {
        boolean[][] visited = new boolean[n][m];
        int componentCount = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] > 0 && !visited[i][j]) {
                    bfs(arr, visited, i, j, n, m);
                    componentCount++;
                    if (componentCount >= 2) return true;
                }
            }
        }
        return false;
    }

    private static void bfs(int[][] arr, boolean[][] visited, int sx, int sy, int n, int m) {
        Queue<int[]> queue = new LinkedList<>();
        visited[sx][sy] = true;
        queue.add(new int[]{sx, sy});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0], y = cur[1];
            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (!visited[nx][ny] && arr[nx][ny] > 0) {
                        visited[nx][ny] = true;
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
        }
    }
}
