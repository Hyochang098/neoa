import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			int[][] sudoku = new int[9][9];
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					sudoku[i][j] = sc.nextInt();
				}
			}

			if (checking(sudoku)) {
				System.out.println("#"+tc+" "+1);
			} else {
				System.out.println("#"+tc+" "+0);
			}
		}
	}

	public static boolean checking(int[][] sudoku) {
        for (int i = 0; i < 9; i++) {
            boolean[] rowCheck = new boolean[10];
            boolean[] colCheck = new boolean[10];
            for (int j = 0; j < 9; j++) {
                if (rowCheck[sudoku[i][j]]) return false;
                if (sudoku[i][j] != 0) rowCheck[sudoku[i][j]] = true;

                if (colCheck[sudoku[j][i]]) return false;
                if (sudoku[j][i] != 0) colCheck[sudoku[j][i]] = true;
            }
        }

        for (int startRow = 0; startRow < 9; startRow += 3) {
            for (int startCol = 0; startCol < 9; startCol += 3) {
                boolean[] check = new boolean[10];
                for (int i = startRow; i < startRow + 3; i++) {
                    for (int j = startCol; j < startCol + 3; j++) {
                        if (check[sudoku[i][j]]) return false;
                        if (sudoku[i][j] != 0) check[sudoku[i][j]] = true;
                    }
                }
            }
        }

        return true;
    }
}
