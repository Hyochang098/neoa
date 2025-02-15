
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {

			int[][] sudoku = new int[9][9];

			boolean garo = true;
			for (int i = 0; i < 9; i++) {
				int garosum = 0;
				for (int j = 0; j < 9; j++) {
					sudoku[i][j] = sc.nextInt();
					garosum += sudoku[i][j];
				}
				if (garosum != 45) {
					garo = false;
				}
			}
			boolean sero = true;
			SE: for (int i = 0; i < 9; i++) {
				int serosum = 0;
				for (int j = 0; j < 9; j++) {
					serosum += sudoku[j][i];
				}
				if (serosum != 45) {
					sero = false;
					break SE;
				}
			}
			boolean nemo = true;
			NE: for (int i = 0; i < 3; i += 3) {
				for (int j = 0; j < 3; j += 3) {
					nemo = checknemo(sudoku, i, j);
					if (!nemo) {
						break;
					}
				}
			}

			if (garo && nemo && sero) {
				System.out.println("#" + tc + " " + 1);
			} else {
				System.out.println("#" + tc + " " + 0);
			}

		}
	}

	static boolean checknemo(int[][] arr, int y, int x) {
		int sum = 0;
		for (int i = y; i < y + 3; i++) {
			for (int j = x; j < x + 3; j++) {
				sum += arr[i][j];
			}
		}
		if (sum == 45) {
			return true;
		} else {
			return false;
		}
	}
}
