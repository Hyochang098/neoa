import java.util.*;

public class Main {
    private static long getValue(int x, int y) {
        int layer = Math.max(Math.abs(x), Math.abs(y));
        if (layer == 0) return 1L;

        long len = 2L * layer;
        long maxVal = (2L * layer + 1) * (2L * layer + 1);
        long offset;

        if (x == layer && y != -layer) {
            offset = layer - y;
        } else if (y == -layer && x != -layer) {
            offset = len + (layer - x);
        } else if (x == -layer && y != layer) {
            offset = 2 * len + (y + layer);
        } else {
            offset = 3 * len + (x + layer);
        }
        return maxVal - offset;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r1 = sc.nextInt();
        int c1 = sc.nextInt();
        int r2 = sc.nextInt();
        int c2 = sc.nextInt();
        sc.close();

        int rows = r2 - r1 + 1;
        int cols = c2 - c1 + 1;

        long[][] board = new long[rows][cols];
        long maxNum = 0;

        for (int i = 0; i < rows; i++) {
            int x = r1 + i;
            for (int j = 0; j < cols; j++) {
                int y = c1 + j;
                long val = getValue(x, y);
                board[i][j] = val;
                if (val > maxNum) maxNum = val;
            }
        }
        int width = String.valueOf(maxNum).length();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                sb.append(String.format("%" + width + "d", board[i][j]));
                if (j < cols - 1) sb.append(' ');
            }
            sb.append('\n');
        }
        System.out.print(sb.toString());
    }
}
