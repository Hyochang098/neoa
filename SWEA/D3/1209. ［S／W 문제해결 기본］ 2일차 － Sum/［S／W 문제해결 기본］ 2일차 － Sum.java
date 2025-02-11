import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int tc = 0; tc < 10; tc++) {
			int test = sc.nextInt();
			int[][] arr = new int[100][100];
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					arr[i][j] = sc.nextInt();
				}
			}

			int daegak = 0;
			int reverse = 0;
			int max = 0;
			for (int i = 0; i < 100; i++) {
				int garo = 0;
				int sero = 0;
				for (int j = 0; j < 100; j++) {
					garo += arr[i][j];
					sero += arr[j][i];

				}
				max = Math.max(max, Math.max(garo, sero));
				daegak += arr[i][i];
				reverse += arr[i][99 - i];
			}
			int crosmax=Math.max(daegak, reverse);
			int ans = Math.max(max, crosmax);
			System.out.println("#" + test + " " + ans);
		}

	}
}