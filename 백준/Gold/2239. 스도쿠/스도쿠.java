import java.io.*;
import java.util.*;

public class Main {
    static int[][] board = new int[9][9];
    static List<int[]> blanks = new ArrayList<>();
    static boolean[][] rowUsed = new boolean[9][10];
    static boolean[][] colUsed = new boolean[9][10];
    static boolean[][] boxUsed = new boolean[9][10];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 9; i++) {
            String line = br.readLine();
            for (int j = 0; j < 9; j++) {
                int v = line.charAt(j) - '0';
                board[i][j] = v;
                if (v == 0) {
                    blanks.add(new int[]{i, j});
                } else {
                    rowUsed[i][v] = true;
                    colUsed[j][v] = true;
                    boxUsed[(i / 3) * 3 + j / 3][v] = true;
                }
            }
        }
        solve(0);
    }

    static void solve(int idx) {
        if (idx == blanks.size()) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) sb.append(board[i][j]);
                sb.append('\n');
            }
            System.out.print(sb.toString());
            System.exit(0);
        }
        int[] p = blanks.get(idx);
        int r = p[0], c = p[1], b = (r / 3) * 3 + c / 3;
        for (int n = 1; n <= 9; n++) {
            if (!rowUsed[r][n] && !colUsed[c][n] && !boxUsed[b][n]) {
                board[r][c] = n;
                rowUsed[r][n] = colUsed[c][n] = boxUsed[b][n] = true;
                solve(idx + 1);
                board[r][c] = 0;
                rowUsed[r][n] = colUsed[c][n] = boxUsed[b][n] = false;
            }
        }
    }
}
