import java.io.*;
import java.util.*;

public class Main {
    static List<int[]> virus = new ArrayList<>();
    static List<List<int[]>> combi = new ArrayList<>();
    static int m, n;
    static int ans = Integer.MAX_VALUE;

    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int[][] lab = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                lab[i][j] = Integer.parseInt(st.nextToken());
                if (lab[i][j] == 2) {
                    virus.add(new int[]{i, j});
                }
            }
        }

        combination(0, 0, new ArrayList<>());

        for (List<int[]> selectedVirus : combi) {
            int[][] sample = new int[n][n];
            for (int a = 0; a < n; a++) {
                sample[a] = lab[a].clone();
            }

            bfs(selectedVirus, sample);
        }

        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }

    private static void bfs(List<int[]> selectedVirus, int[][] sample) {
        Queue<int[]> que = new ArrayDeque<>();
        int[][] timeGrid = new int[n][n]; // 확산 일수 저장
        for (int[] row : timeGrid) Arrays.fill(row, -1); // 방문하지 않은 곳은 -1

        int emptyCount = 0;

        // 바이러스 초기 위치
        for (int[] pos : selectedVirus) {
            que.add(pos);
            timeGrid[pos[0]][pos[1]] = 0; // 시작점은 0일 차
        }

        // 초기 빈 공간 카운트
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (sample[i][j] == 0) {
                    emptyCount++;
                }
            }
        }

        int maxTime = 0;

        while (!que.isEmpty()) {
            int[] temp = que.poll();
            int y = temp[0];
            int x = temp[1];

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny >= 0 && ny < n && nx >= 0 && nx < n && sample[ny][nx] != 1 && timeGrid[ny][nx] == -1) {
                    que.add(new int[]{ny, nx});
                    timeGrid[ny][nx] = timeGrid[y][x] + 1;

                    if (sample[ny][nx] == 0) {
                        emptyCount--;
                        maxTime = Math.max(maxTime, timeGrid[ny][nx]);
                    }
                }
            }
        }

        if (emptyCount == 0) {
            ans = Math.min(ans, maxTime);
        }
    }

    private static void combination(int start, int cur, List<int[]> select) {
        if (cur == m) {
            combi.add(new ArrayList<>(select));
            return;
        }
        for (int i = start; i < virus.size(); i++) {
            select.add(virus.get(i));
            combination(i + 1, cur + 1, select);
            select.remove(select.size() - 1);
        }
    }
}
