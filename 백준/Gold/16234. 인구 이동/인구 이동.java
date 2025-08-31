import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int[][] A = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int days = 0;

        while (true) {
            boolean[][] visited = new boolean[N][N];
            boolean moved = false;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (visited[i][j]) {
                        continue;
                    }
                    ArrayDeque<int[]> q = new ArrayDeque<>();
                    ArrayList<int[]> cells = new ArrayList<>();
                    q.add(new int[]{i, j});
                    visited[i][j] = true;
                    cells.add(new int[]{i, j});
                    int sum = A[i][j];

                    while (!q.isEmpty()) {
                        int[] cur = q.poll();
                        int x = cur[0];
                        int y = cur[1];

                        for (int d = 0; d < 4; d++) {
                            int nx = x + dx[d];
                            int ny = y + dy[d];
                            if (nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny]) {
                                continue;
                            }
                            int diff = Math.abs(A[x][y] - A[nx][ny]);
                            if (diff >= L && diff <= R) {
                                visited[nx][ny] = true;
                                q.add(new int[]{nx, ny});
                                cells.add(new int[]{nx, ny});
                                sum += A[nx][ny];
                            }
                        }
                    }

                    if (cells.size() > 1) {
                        moved = true;
                        int avg = sum / cells.size();
                        for (int[] p : cells) {
                            A[p[0]][p[1]] = avg;
                        }
                    }
                }
            }

            if (!moved) {
                break;
            }
            days++;
        }

        System.out.println(days);
    }
}
