import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static class Smell {
        int shark;
        int time;

        public Smell(int shark, int time) {
            this.shark = shark;
            this.time = time;
        }
    }

    static class Shark {
        int id;
        int y, x;
        int dir;
        boolean alive;
        int[][] priority;

        public Shark(int id, int y, int x, int dir) {
            this.id = id;
            this.y = y;
            this.x = x;
            this.dir = dir;
            this.alive = true;
            this.priority = new int[4][4];
        }
    }

    static int N, M, K;
    static Smell[][] ocean;
    static Shark[] sharks;
    static int[] dy = { 0, -1, 1, 0, 0 };
    static int[] dx = { 0, 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        ocean = new Smell[N][N];
        sharks = new Shark[M + 1];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                ocean[i][j] = new Smell(0, 0);
            }
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num != 0) {
                    sharks[num] = new Shark(num, i, j, 0);
                    ocean[i][j] = new Smell(num, K);
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= M; i++) {
            int d = Integer.parseInt(st.nextToken());
            if (sharks[i] != null) {
                sharks[i].dir = d;
            }
        }

        for (int i = 1; i <= M; i++) {
            if (sharks[i] == null)
                continue;
            for (int d = 0; d < 4; d++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 4; j++) {
                    sharks[i].priority[d][j] = Integer.parseInt(st.nextToken());
                }
            }
        }

        int time = 0;
        while (time <= 1000) {
            if (one()) {
                System.out.println(time);
                return;
            }
            time++;

            int[] newY = new int[M + 1];
            int[] newX = new int[M + 1];
            int[] newDir = new int[M + 1];

            for (int i = 1; i <= M; i++) {
                if (!sharks[i].alive)
                    continue;
                int r = sharks[i].y;
                int c = sharks[i].x;
                int curDir = sharks[i].dir;
                boolean moved = false;
                int chosenDir = 0, nr = 0, nc = 0;

                // 먼저 냄새가 없는 인접 칸을 우선순위에 따라 탐색
                for (int dIdx = 0; dIdx < 4; dIdx++) {
                    int nd = sharks[i].priority[curDir - 1][dIdx];
                    int tr = r + dy[nd];
                    int tc = c + dx[nd];
                    if (tr < 0 || tr >= N || tc < 0 || tc >= N)
                        continue;
                    if (ocean[tr][tc].time == 0) { // 냄새 없음
                        chosenDir = nd;
                        nr = tr;
                        nc = tc;
                        moved = true;
                        break;
                    }
                }
                if (!moved) {
                    for (int dIdx = 0; dIdx < 4; dIdx++) {
                        int nd = sharks[i].priority[curDir - 1][dIdx];
                        int tr = r + dy[nd];
                        int tc = c + dx[nd];
                        if (tr < 0 || tr >= N || tc < 0 || tc >= N)
                            continue;
                        if (ocean[tr][tc].shark == sharks[i].id) {
                            chosenDir = nd;
                            nr = tr;
                            nc = tc;
                            break;
                        }
                    }
                }
                newY[i] = nr;
                newX[i] = nc;
                newDir[i] = chosenDir;
            }

            int[][] cellShark = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    cellShark[i][j] = 0;
                }
            }

            for (int i = 1; i <= M; i++) {
                if (!sharks[i].alive)
                    continue;
                int r = newY[i];
                int c = newX[i];
                if (cellShark[r][c] == 0) {
                    cellShark[r][c] = i;
                } else {
                    int other = cellShark[r][c];
                    if (i < other) {
                        sharks[other].alive = false;
                        cellShark[r][c] = i;
                    } else {
                        sharks[i].alive = false;
                    }
                }
            }
            for (int i = 1; i <= M; i++) {
                if (!sharks[i].alive)
                    continue;
                sharks[i].y = newY[i];
                sharks[i].x = newX[i];
                sharks[i].dir = newDir[i];
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (ocean[i][j].time > 0) {
                        ocean[i][j].time--;
                        if (ocean[i][j].time == 0) {
                            ocean[i][j].shark = 0;
                        }
                    }
                }
            }

            for (int i = 1; i <= M; i++) {
                if (!sharks[i].alive)
                    continue;
                int r = sharks[i].y;
                int c = sharks[i].x;
                ocean[r][c].shark = sharks[i].id;
                ocean[r][c].time = K;
            }
        }
        System.out.println(-1);
    }

    static boolean one() {
        int count = 0;
        for (int i = 1; i < sharks.length; i++) {
            if (sharks[i] != null && sharks[i].alive)
                count++;
        }
        return count == 1;
    }
}
