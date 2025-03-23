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
        int inning = 0;
        int order = -1;
        int score = 0;

        while (inning < n) {
            int outcnt = 0;
            int base = 0;
            while (outcnt < 3) {
                order = (order + 1) % 9;
                int result = info[inning][lineup[order]];
                if (result == 0) {
                    outcnt++;
                } else {
                    base <<= result;
                    base |= 1 << (result - 1);

                    score += Integer.bitCount(base >> 3);
                    base &= 0b111;
                }
            }
            inning++;
        }
        return score;
    }
}
