import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] info;
    static int[] lineup = new int[9];
    static boolean[] visited = new boolean[9];
    static int performance = Integer.MIN_VALUE;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        info = new int[n][9];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                info[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        lineup[3] = 0;
        visited[0] = true;
        bt(0);
        System.out.println(performance);
    }

    static void bt(int depth) {
        if (depth == 9) {
            performance = Math.max(performance, cal());
            return;
        }
        if (depth == 3) {
            bt(depth + 1);
            return;
        }
        for (int i = 1; i < 9; i++) {
            if (!visited[i]) {
                visited[i] = true;
                lineup[depth] = i;
                bt(depth + 1);
                visited[i] = false;
            }
        }
    }

    static int cal() {
        int score = 0;
        int inning = 0;
        int order = 0;

        while (inning < n) {
            int out = 0;
            boolean[] base = new boolean[4];

            while (out < 3) {
                int player = lineup[order];
                int result = info[inning][player];

                if (result == 0) {
                    out++;
                } else if (result == 1) {
                    if (base[3])
                        score++;
                    base[3] = base[2];
                    base[2] = base[1];
                    base[1] = true;
                } else if (result == 2) {
                    if (base[3])
                        score++;
                    if (base[2])
                        score++;
                    base[3] = base[1];
                    base[2] = true;
                    base[1] = false;
                } else if (result == 3) {
                    if (base[3])
                        score++;
                    if (base[2])
                        score++;
                    if (base[1])
                        score++;
                    base[3] = true;
                    base[2] = false;
                    base[1] = false;
                } else if (result == 4) {
                    for (int i = 1; i <= 3; i++) {
                        if (base[i])
                            score++;
                        base[i] = false;
                    }
                    score++;
                }
                order = (order + 1) % 9;
            }
            inning++;
        }

        return score;
    }
}
